import java.util.Scanner;
public class TestWaterConsumptionApp
{
	public static void main(String[] args)
	{
		///Create an object of the Scanner class 
		Scanner scaninput = new Scanner(System.in);
		
		//Prompt and get usage information
		System.out.print("Enter the initial water meter reading in kiloliters (KL):");
		double initialReading = scaninput.nextDouble();
		
		System.out.print("Enter the final water meter reading in kiloliters (KL):");
		double 	finalReading = scaninput.nextDouble();
		
		//Create an object of the WaterConsumptionApp class
		waterConsumptionApp usage = new waterConsumptionApp(initialReading,finalReading);
		
		//Invoke method to set the data member consumption
		usage.calculateConsumption();
		
		//Invoke method to calculate charge 
		usage.determineTerrif();
		
		//invoke  method to display
		System.out.println(usage.toString());
	}
}