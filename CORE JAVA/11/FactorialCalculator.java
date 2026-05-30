import java.util.Scanner;
import java.math.BigInteger;

class FactorialCalculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");

        int num = sc.nextInt();

        BigInteger factorial = BigInteger.ONE;

        for(int i=1;i<=num;i++)
        {
            factorial =
            factorial.multiply(
            BigInteger.valueOf(i));
        }

        System.out.println(
        "Factorial of "
        + num
        + " = "
        + factorial);

        sc.close();
    }
}