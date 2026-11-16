import java.util.Scanner;
public class EmailAddressApp
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter your contact details here :");
		String contactDetails = kb.nextline();
		
		//call the method 
		String extractedNumbers = getNumbers(contactDetails);
		
		System.out.print("Enter email address domain here:");
		String emailDomain = kb.nextLine();
		
		//we creating the email addresss 
		String emailAddress = extractedNumbers + "@" + emailDomain;
		
		//call the method 
		displayEmailAddress(extractedNumbers, emailAddress);
		
		
	}
	public static String getNumbers(String input)
	{
		String numbersOnly = "";
		for(int i = 0; i < input.length(); i++)
		{
			char currentChar = input.charAt(i);
			if(Character.isDigit(currentChar))
			{
				numbersOnly += currentChar;
			}
		}
		return numbersOnly;
	}
	public static void displayEmailAddress(String numbers, String email)
	{
		System.out.println("Extracted numeric substring: " + numbers);
		System.out.println("Email address:" + email);
	}
	
}