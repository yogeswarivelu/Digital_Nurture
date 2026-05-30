import java.util.Scanner;

class PalindromeChecker
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");

        String str = sc.nextLine();

        // Remove non-alphanumeric characters

        str = str.replaceAll("[^a-zA-Z0-9]", "");

        // Convert to lowercase

        str = str.toLowerCase();

        String reversed = "";

        for(int i = str.length()-1; i >= 0; i--)
        {
            reversed = reversed + str.charAt(i);
        }

        if(str.equals(reversed))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not a Palindrome");
        }

        sc.close();
    }
}