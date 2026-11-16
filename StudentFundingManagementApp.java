import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;
public class StudentFundingManagementApp
{
	public static void  populateYearOfStudy(int[] yearsOfStudy)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < yearsOfStudy.length;i++)
		{
			yearsOfStudy[i] = input.nextInt(5) + 1;
		}
	}	
	public static void  populateHouseholdIncome (String[] studentIDs, double[] householdIncomeAmount)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < studentIDs.length;i++)
		{
			System.out.print("Enter household income (in ZAR) for " + studentIDs[i] + ":");
			double incomeHouseHold = input.nextDouble();
			
			boolean isValid = validateHouseholdIncome(incomeHouseHold);
			
			while(isValid == false)
			{
				System.out.println("Invalid income. Please enter a value between 0 and 600,000");
				System.out.print("Enter household income (in ZAR) for " + studentIDs[i] + ":");
			    incomeHouseHold = input.nextDouble();
				
			    isValid = validateHouseholdIncome(incomeHouseHold);
			}
			householdIncomeAmount[i] = incomeHouseHold;
		}
	}
	private static boolean validateHouseholdIncome(double incomeHouseHold)
	{
		if(incomeHouseHold >= 0 && incomeHouseHold < 600000)
		{
			return true;
		}else{
			return false;
		}
	}
	public static char getUserOption()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select any option to start or continue:");
		System.out.println("\t\t\t1/A Display all student in the funding management List");
		System.out.println("\t\t\t2/S Search for a student's funding status using student ID");
		System.out.println("\t\t\t3/X Exit");
		char option = Character.toUpperCase(input.next().charAt(0));
		return option;
	}	
	public static void  determineFundingRecommendation(double[] average, double[] householdIncomeAmount,int[] yearsOfStudy, String[] fundingStatus)
	{
		for(int i = 0; i < average.length;i++)
		{
			fundingStatus[i] = "No Funding";
			
			if(yearsOfStudy[i] == 1)
			{
				if(average[i] >= 75)
				{
					if(householdIncomeAmount[i] < 350000)
					{
						fundingStatus[i] = "Full Funding";
					}
				}else if(average[i] >= 65 && average[i] <= 74)
				{
					if(householdIncomeAmount[i] < 600000)
					{
						fundingStatus[i] = "Partial Funding";
					}
				}else{
					if(average[i] < 65)
					{
						if(householdIncomeAmount[i] >= 0)
						{
							fundingStatus[i] = "No Funding";
						}
					}
				}
			}else if(yearsOfStudy[i] >= 2 && yearsOfStudy[i] <= 5)
			{
				if(average[i] >=70)
				{
					if(householdIncomeAmount[i] < 350000)
					{
						fundingStatus[i] = "Full Funding";
					}
				}
			}else{
				if(yearsOfStudy[i] >= 4 && yearsOfStudy[i] <= 5)
				{
					if(average[i] >= 60 && average[i] < 69)
					{
						if(householdIncomeAmount[i] < 600000)
						{
							fundingStatus[i] = "Partial Funding";
						}
					}
				}
			}
		}
	}
	public static int searchStudent(String searchId, String[] studentIDs)
	{
		int index = -1;
		for(int i = 0; i < studentIDs.length;i++)
		{
			if(studentIDs[i].equalsIgnoreCase(searchId))
			{
				index = i;
				break;
			}
		}
		return index;
	}	
	public static void  displayAllStudents(String[] studentIDs, String[] courses,int[] yearsOfStudy,double[] average, double[] householdIncomeAmount,String[] fundingStatus)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("************************************************");
		System.out.println("Stud#\t\tCourse\t\tYear\t\tAverage\t\tHousehold Income\t\tFunding Status");
		for(int i = 0; i < studentIDs.length;i++)
		{
			System.out.println(studentIDs[i] + "\t\t" + courses[i] + "\t\t" + yearsOfStudy[i] + "\t\t" + df.format(average[i]) + "\t\tR " +  householdIncomeAmount[i] + "\t\t" + fundingStatus[i]);
		}
		System.out.println("************************************************");
	}	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String[] studentIDs = {"SA2201","SA4302","SA5303","SA5414","SA6325","SA7302"};
		String[] courses = {"Accounting","Engineering","Psychology","LLB Law","Medicine","Informatics"}; 
		double[] average = {55,45,75,66,68,82}; 	
		int[] yearsOfStudy = new int[average.length];
		double[] householdIncomeAmount = new double[average.length];
		String[] fundingStatus = new String[studentIDs.length];
		
		populateYearOfStudy(yearsOfStudy);
		populateHouseholdIncome(studentIDs,householdIncomeAmount);
		determineFundingRecommendation(average,householdIncomeAmount,yearsOfStudy,fundingStatus);
		
		char option = getUserOption();
		while(option !='3' && option != 'X');
		{
			switch(option)
			{
				case'1':
				case'A':
					displayAllStudents(studentIDs,courses,yearsOfStudy,average,householdIncomeAmount,fundingStatus);
					break;
				case'2':
				case'S':
					System.out.print("Enter the student ID you're searching for: ");
					String searchId = input.nextLine();
					int index = searchStudent(searchId,studentIDs);
					if(index == -1)
					{
						System.out.println("Stud#\t\tCourse\t\tYear\t\tAverage\t\tHousehold Income\t\tFunding Status");
					System.out.println(studentIDs[index] + "\t\t" + courses[index] + "\t\t" + yearsOfStudy[index] + "\t\t" + average[index] + "\t\t" + householdIncomeAmount[index] + "\t\t" + fundingStatus[index]);
					}else{
						System.out.println("Student " + searchId + " not found.");
					}
					break;
				case'3':
				case'X':
					System.out.println("Good Bye!!!");
					break;
				default:
					System.out.println("Invalid Option");
					System.out.println("************************************************");
					break;
			}
			option = getUserOption();
		}
	}
 
}