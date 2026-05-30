public class Main {

    public static void main(String[] args) {

        AccountDAO dao = new AccountDAO();

        // Transfer 1000 from account 101 to 102
        dao.transferMoney(101, 102, 1000);
    }
}