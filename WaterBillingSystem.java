import java.util.Scanner;
public class WaterBillingSystem
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		double waterConsumed;
		String customerType;
		double hoursUsed;
		double cost =0.0;
		
		WaterUsage usage = new WaterUsage();//instatiating the WaterUsage class
		
		// Accept user inputs using setter methods
        System.out.print("Enter Water Consumed (in liters): ");
        waterConsumed = scanner.nextDouble();
		
		usage.setLitersConsumed(waterConsumed);
		
		scanner.nextLine(); // Consume newline
		
		System.out.print("Enter Customer Type (Residential/Commercial/Industrial): ");
        customerType=scanner.nextLine();
		
		usage.setCustomerType(customerType);
		
		System.out.print("Enter Hours Used: ");
        hoursUsed=scanner.nextDouble();
		
		usage.setHoursUsed(hoursUsed);
		
		cost = usage.calculateCost();
		
		// Display results
		usage.displayDetails(cost);
	}
}