import java.util.Scanner;
public class passCodeQ2sickTest2024Manipulation
{
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter your full names to generate user id");
		String fullNames = kb.nextLine();
		
		System.out.println("Enter your user id");
		String passCode = kb.nextLine();
		
		//finding the initial from the 1st name
		String initials = "";
		if(fullNames.length() > 0)
		{
			initials = initials + Character.toUpperCase(fullNames.charAt(0));
			
		}
		
		//finding the initial after the space 
		for(int i =0 ; i < fullNames.length() ; i++)
		{
			if(fullNames.charAt(i) == ' ')
			{
				if(i + 1 < fullNames.length())
				{
					if(fullNames.charAt(i + 1) != ' ')
					{
						initials = initials + Character.toUpperCase(fullNames.charAt(i + 1));
					}
				}
			}
		}
		//we are checking the length since they said 9 characters long
		int expectedLength = initials.length() + 6;
		if(passCode.length() != expectedLength)
		{
			System.out.println("The length of the passcode is not correct!");
			return;
		}
		
		//checking if they are in Caps
		if(!passCode.equals(passCode.toUpperCase()))
		{
			System.out.println("The passcode is not valid");
			return;
		}
		
		//we are checking the initials 
		String passInitials = passCode.substring(0,initials.length());
		if(!passInitials.equals(initials))
		{
			System.out.println("The initials do not match!");
			return;
		}
		
		//we are checking the digits as the remaining must be digits
		String digitPart = passCode.substring(initials.length());
		for(int i = 0; i < digitPart.length(); i++)
		{
			if(!Character.isDigit(digitPart.charAt(i)))
			{
				System.out.println("The passcode is not valid" + passCode + "Digits incorrect!!");
				return;
			}
		}
		
		//the valid display 
		System.out.println("The passcode is valid");
	}
}