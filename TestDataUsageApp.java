import java.util.Scanner;
public class TestDataUsageApp
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		DataUsageApp dataApp = new DataUsageApp();
		
		System.out.print("Enter total data consumed (in GB):");
		double dataConsumption = scanner.nextDouble();
		System.out.print("Enter data plan type (PREPAID/TOPUP/UNLIMITED):");
		String dataPlan = scanner.next();
		System.out.print("Enter the number of hours you used the data:");
		double hoursUsed = scanner.nextDouble();
		
		dataApp.setDataConsumed(dataConsumption);
		dataApp.setPlanType(dataPlan);
		dataApp.setEfficiency(hoursUsed);
		
		double cost = dataApp.determineDataCost();
		
		System.out.println();
		System.out.println(dataApp.toString(cost));
		
		
	}
}