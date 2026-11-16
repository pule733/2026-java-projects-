import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class Dealership
{
	
	public static void populateCustomers(int[] customers)
	{
		
		Random rand = new Random();
		for(int i = 0 ; i < customers.length;i++)
		{
			customers[i] = rand.nextInt(2981) + 20;
		}
	}
	public static int getUserOption()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select any option to start:");
		System.out.println("\t\t\t 1 Display all dealerships");
		System.out.println("\t\t\t 2 Display dealership with highest sales ");
		System.out.println("\t\t\t 3 Exit");
		int option = input.nextInt();
		return option;
	}
	public static double  determineDealerTotals(double[] dealer)
	{
		double dealerTotalSalesAmount = 0;
		for(int i = 0; i < dealer.length;i++)
		{
			dealerTotalSalesAmount += dealer[i];
		}
		return dealerTotalSalesAmount;
	}	
	public static int determineTotalCust(int[] customers)
	{
		int totalNumOfCustomers = 0;
		for(int i = 0; i < customers.length;i++)
		{
			totalNumOfCustomers += customers[i];
		}
		return totalNumOfCustomers;
	}	
	public static void calcTotalSales(double[] dealer1, double[] dealer2,double[] dealer3, double[] totalSales)
	{
		for(int i = 0; i < totalSales.length;i++)
		{
			totalSales[i] = dealer1[i] + dealer2[i] + dealer3[i];
		}
	}
	public static String determineHighestDealerSales (double[] dealer1, double[] dealer2,double[] dealer3, int monthNumber)
	{
		DecimalFormat df = new DecimalFormat("#,##0.00");
		int index = monthNumber - 1;
		double highest = dealer1[index];
		String dealer = "dealer 1";
			if(dealer2[index] > highest)
			{
				highest = dealer2[index];
				dealer = "Dealer 2";
			}
		   if(dealer3[index] > highest)
			{
				highest = dealer3[index];
				dealer = "Dealer 3";
			}	
		
        return "Highest selling dealer for Month" + monthNumber + ":" + dealer + "(R" + df.format(highest) + ")";
			
		
	}
	public static void displayDealerDetails(double[] dealer1, double[] dealer2, double[] dealer3, int[] customers, String[] month,double[] totalSales, double tottalNum1, double totalNum2, double totalNum3, int totalCust, double grandTotal)
	{
		DecimalFormat df = new DecimalFormat("#,##0.00");
		System.out.println("Month\t\tDealer 1\t\tDealer 2\t\tDealer 3\t\tCustomers\t\tTotal Sales");
		for(int i = 0; i < dealer1.length;i++)
		{
			System.out.println(month[i] + "\t\tR" + df.format(dealer1[i]) + "\t\tR" + df.format(dealer2[i]) + "\t\tR" + df.format(dealer3[i]) + "\t\t" + customers[i] + "\t\tR" + df.format(totalSales[i]));
			
		}
		System.out.println("=============================================================================================================");
		System.out.println("\t\t\t\tR" + df.format(tottalNum1) + "\t\tR" + df.format(totalNum2) + "\t\tR" + df.format(totalNum3) + "\t\t" + totalCust + "\t\tR" + df.format(grandTotal));
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug"};
		double[] dealer1 = {22000.00,330000.00,44000.00,89000.00,150000.00,250000.00,31000.00,84000.00};
		double[] dealer2 = {65000.00,95000.00,88000.99,53000.55,31000.00,65500.00,98000.00,74000.00};
		double[] dealer3 = {55000.00,15000.00,96000.00,98000.00,88000.00,85000.00,65000.00,44000.00}; 
		int[] customers = new int[dealer1.length];
		double[] totalSales = new double[dealer1.length];
		
		populateCustomers(customers);
		
		int option = getUserOption();
		
		while(option != 3)
		{
			switch(option)
			{
				case 1:
					calcTotalSales(dealer1,dealer2,dealer3,totalSales);
					double tot1 = determineDealerTotals(dealer1);
					double tot2 = determineDealerTotals(dealer2);
					double tot3 = determineDealerTotals(dealer3);
					int totCust = determineTotalCust(customers);
					double grand = tot1 + tot2 + tot3;
					displayDealerDetails(dealer1,dealer2,dealer3,customers,month,totalSales,tot1,tot2,tot3,totCust,grand);
					break;
				case 2:
					System.out.print("Enter a month you want to check highest sales for 1 - 8");
					int monthNumber = input.nextInt();
					System.out.println(determineHighestDealerSales(dealer1,dealer2,dealer3,monthNumber));
					break;
				
				default: 
					System.out.println("Invalid option!");
					
			}
			option = getUserOption();
		}
		System.out.println("Goood bye!!!");
	}
	
}