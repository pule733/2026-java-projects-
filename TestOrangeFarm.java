import java.util.Scanner;
import java.text.DecimalFormat;
public class TestOrangeFarm {

	public static void main(String [] args)
	{
	Scanner input = new Scanner(System.in);
	 DecimalFormat df = new DecimalFormat ("######.00");
	 int orangesPrevWeek, orangesCurrWeek, numBox;
	 System.out.print("Enter number of oranges produced the previous week: ");
	orangesPrevWeek = input.nextInt();
	 System.out.print("Enter number of oranges produced this week (current): ");
	 orangesCurrWeek = input.nextInt();
	System.out.println();
	//create an object of the OrangeFarm class

	 OrangeFarm oranges = new OrangeFarm(orangesPrevWeek,orangesCurrWeek);
	 numBox = oranges.calcBoxesNeeded() ;

	 double  profit = oranges.calculateProfit();
	System.out.println("Number of boxes needed: " + numBox
	 + "\nProfit R" + df.format(profit));

    }
}
