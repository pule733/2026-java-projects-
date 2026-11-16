import java.util.Scanner;

public class StringManipulationApp 
{
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
        int wordCounting = 0;
        int digitCounting = 0;
        
        System.out.print("Enter a sentence: ");
        String sentence = kb.nextLine();
        
        String upperCase = sentence.toUpperCase();
        
        int length = sentence.length();
        
        // Count words
        for(int i = 0; i < sentence.length(); i++)
        {
            if(sentence.charAt(i) != ' ')
            {
                if(i == 0 || sentence.charAt(i - 1) == ' ')
                {
                    wordCounting++;
                }
            }
        }
        
        // Count digits
        for(int i = 0; i < sentence.length(); i++)
        {
            char ch = sentence.charAt(i);
            
            if(ch >= '0' && ch <= '9')
            {
                digitCounting++;
            }
        }
        
        System.out.println("");
        System.out.println("The sentence in upper case: " + upperCase);
        System.out.println("Length = " + length + " characters long");
        System.out.println("Number of words in the sentence: " + wordCounting);
        System.out.println("The number of digits = " + digitCounting);
    }
}