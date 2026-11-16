import java.util.Scanner; 
public class arrays
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String[] details = {"Katlego", "Motlanalo ", "Motsoge" };
		//displaying all the details 
		for( int i = 0; i < details.length; i++)
		{
			System.out.println(details[i]);
		}
		//search code
		String searchCode = "Motsoge";
		int index = -1;
		for(int i = 0; i< details.length; i++)
		{
		if(searchCode == details[i])
		{
			index = i;
			break;//to stop the search 
		}
		}
		//display outside the loop 
		if(index == -1)
		{
			System.out.print(searchCode + " was not found");
		}
		else 
		{
			System.out.print("congrats");
		}
	}
}