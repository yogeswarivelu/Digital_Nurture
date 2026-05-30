import java.sql.Connection;
import java.sql.PreparedStatement;

public class AccountDAO {

    public void transferMoney(int fromAccount, int toAccount, double amount) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            // Disable Auto Commit
            con.setAutoCommit(false);

            // Debit Query
            String debitQuery =
                    "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";

            PreparedStatement debitStmt =
                    con.prepareStatement(debitQuery);

            debitStmt.setDouble(1, amount);
            debitStmt.setInt(2, fromAccount);

            int debitResult = debitStmt.executeUpdate();

            // Credit Query
            String creditQuery =
                    "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";

            PreparedStatement creditStmt =
                    con.prepareStatement(creditQuery);

            creditStmt.setDouble(1, amount);
            creditStmt.setInt(2, toAccount);

            int creditResult = creditStmt.executeUpdate();

            // Commit Transaction
            if (debitResult > 0 && creditResult > 0) {

                con.commit();

                System.out.println("Transaction Successful");

            } else {

                con.rollback();

                System.out.println("Transaction Failed");
            }

            con.close();

        } catch (Exception e) {

            try {

                if (con != null) {

                    con.rollback();

                    System.out.println("Transaction Rolled Back");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }
    }
}