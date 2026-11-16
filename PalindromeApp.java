import java.util.Scanner;

public class PalindromeApp
{
    public static boolean isPalindrome(String word)
    {
        String lower = word.toLowerCase();
        String reversed = "";

        for (int i = lower.length() - 1; i >= 0; i--)
        {
            reversed += lower.charAt(i);
        }

        if (lower.equals(reversed))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String word;

        while (true)
        {
            System.out.println("Please enter a word or Stop to terminate:");
            word = input.nextLine();

            if (word.equalsIgnoreCase("Stop"))
            {
                break;
            }

            if (isPalindrome(word))
            {
                System.out.println(word + " is a palindrome");
            }
            else
            {
                System.out.println(word + " is NOT a palindrome");
            }
        }

        input.close();
    }
}
