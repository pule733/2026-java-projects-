import java.util.Scanner;
import java.util.Random;
public class ThemeParkManagerApp2024
{
	
    public static void populateTicketsSold(int[] ticketsSold)
	{
		Random rand = new Random();
		for(int i = 0; i < ticketsSold.length;i++)
		{
			ticketsSold[i] = rand.nextInt(150) + 1;
		}
	}
    public static void calculateRevenues(int[] ticketsSold, double[] ticketPrices, double[] revenues)
	{
		for(int i = 0; i < ticketsSold.length;i++)
		{
			revenues[i] = ticketsSold[i] * ticketPrices[i];
		}
	}
    public static int searchRide(String[] rideNames, String search)
	{
		for(int i = 0; i < rideNames.length;i++)
		{
			if(rideNames[i].equalsIgnoreCase(search))
			{
				return i;
			}
		}
		return -1;
	}
    public static void sortByTicketPrice(String[] rideNames, int[] ticketsSold, double[] ticketPrices, double[] revenues)
	{
		for(int i = 0;i < ticketPrices.length;i++)
		{
			for(int j = 0; j < ticketPrices.length -1;j++)
			{
				double tempPrice = ticketPrices[j];
				ticketPrices[j] = ticketPrices[j + 1];
				ticketPrices[j + 1] = tempPrice;
				
				String tempName = rideNames[j];
				rideNames[j] = rideNames[j + 1];
				rideNames[j + 1] = tempName;
				
				int tempSold = ticketsSold[j];
				ticketsSold[j] = ticketsSold[j + 1];
				ticketsSold[j + 1] = tempSold;
				
				double tempRev = revenues[j];
				revenues[j] = revenues[j + 1];
				revenues[j + 1] = tempRev;
			}
		}
	}
    public static void displayRidesInformation(String[] rideNames, int[] ticketsSold, double[] ticketPrices, double[] revenues)
	{
		System.out.println("Rides : ");
		System.out.println("Ride Name\t\tTickets Sold\t\tTicket Prices\t\tRevenue");
		for(int i = 0; i < rideNames.length; i++)
		{
			System.out.println(rideNames[i] + "\t\t" + ticketsSold[i] + "\t\tR" + ticketPrices[i] + "\t\tR" + revenues[i]);
		}
	}
	public static void main(String[] args)
	{
		String[] rideNames = {"Anaconda","Golden Loop","Water Slide","Log House","Tower Terror"};
		double[] ticketPrices = {50.50,47.00,55.50,42.00,75.99};
		int[] ticketsSold = new int[ticketPrices.length];
		double[] revenues = new double[ticketPrices.length];
		
		populateTicketsSold(ticketsSold);
		calculateRevenues(ticketsSold,ticketPrices,revenues);
		displayRidesInformation(rideNames,ticketsSold,ticketPrices,revenues);
		
		sortByTicketPrice(rideNames,ticketsSold,ticketPrices,revenues);
		System.out.println("Rides sorted by ticket price (cheapest to most expensive):");
		displayRidesInformation(rideNames,ticketsSold,ticketPrices,revenues);
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a ride name to search: ");
		String search = kb.nextLine();
		
		int index = searchRide(rideNames,search);
		if(index!= -1)
		{
			System.out.println(rideNames[index] + "\t\tR" + ticketPrices[index]);
		}else{
			System.out.println("Ride not found ");
		}
		
		
	}

}