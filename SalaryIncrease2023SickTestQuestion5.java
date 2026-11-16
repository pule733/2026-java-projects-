import java.util.Scanner;
import java.util.Random;
public class SalaryIncrease2023SickTestQuestion5
{
	public static void populateExperience(int[] experience)
	{
		Random rand = new Random();
		for(int i = 0 ; i < experience.length ; i++)
		{
			experience[i] = rand.nextInt(20) + 1;
		}
	}
	
	public static int getUserOption()
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Select any option to start:");
		System.out.println("\t1 Display all sorted employee details");
		System.out.println("\t2 Display employee with the lowest salary");
	    System.out.println("\t3 Exit");
		int option = kb.nextInt();
		return option;
	}
	
	public static void calcAnnualSal(double[] monthlySals, double[] annualSalaries)
	{
		for(int i = 0; i < monthlySals.length ; i++)
		{
			annualSalaries[i] = monthlySals[i] * 12; 
		}
	}
	
	public static int  determineLowestSalary(double[] newMonthlySals)
	{
		int lowestIndex = 0;
		for(int i = 0; i < newMonthlySals.length;i++)
		{
			if(newMonthlySals[i] < newMonthlySals[lowestIndex])
			{
				lowestIndex = i;
			}
		}
		return lowestIndex;
	}
	
	public static void sortEmployeeDetails(String[] employeesNames, int[] experience,double[] monthlySals, double[] newMonthlySals, double[] annualSalaries)
	{
		for(int i = 0 ; i < monthlySals.length - 1;i++)
		{
			for(int j = 0; j < monthlySals.length -1 ; j++)
			{
				if(newMonthlySals[j] > newMonthlySals[j +1])
				{
					double tempNew = newMonthlySals[j];
					newMonthlySals[j] = newMonthlySals[j +1];
					newMonthlySals[j + 1] = tempNew;
					
					double tempMonth = monthlySals[j];
					monthlySals[j] = monthlySals[j + 1];
					monthlySals[j + 1] = tempMonth;
					
					double tempAnn = annualSalaries[j];
					annualSalaries[j] = annualSalaries[j + 1];
					annualSalaries[j + 1] = tempAnn;
					
					int tempExp = experience[j];
					experience[j] = experience[j + 1];
					experience[j + 1] = tempExp;
					
					String tempName = employeesNames[j];
					employeesNames[j] = employeesNames[j + 1];
					employeesNames[j + 1] = tempName;
				}
			}
		}
	}
	
	public static void calcIncrease(int[] experience,double[] monthlySals,double[] newMonthlySals)
	{
		for(int i = 0;i < experience.length ; i++)
		{
			double increase = 0;
			double salary = monthlySals[i];
			int exp = experience[i];
			
			if(exp >= 0 && exp <= 5)
			{
				if(salary <= 100000)
				{
					increase = 0.06;
				}else {
					increase = 0.05;
				}
			}else if(exp >= 6 && exp <= 10)
			{
				if(salary <= 100000)
				{
					increase = 0.08;
				}else{
					increase = 0.05;
				}
			}else if(exp > 10)
			{
				if(salary <= 100000)
				{
					increase = 0.075;
				}else{
					increase = 0.09;
				}
			}
			
			newMonthlySals[i] = salary + (salary * increase);
		}
	}
	
	public static void displayEmployeeDetails(String[] employeesNames,double[] monthlySals, double[] newMonthlySals, double[] annualSalaries, int[] experience)
	{
		System.out.println("Employee\tExperience\tMonthly Salary\tNew Monthly Salary\tAnnual Salary");
		for(int i = 0; i < employeesNames.length;i++)
		{
			System.out.println(employeesNames[i] +"\t\t" + experience[i] + "\t\tR" + monthlySals[i] + "\t\tR" + newMonthlySals[i] + "\t\tR" + annualSalaries[i]); 
		}
	}
	
	public static void main(String[] args)
	{
		String[] employeesNames = {"Mudau T", "Msiza S", "Mabun V","Gcaza Y","Gcaza L","Shaku B","Jini S","Jele K","Khan C","Smith W"};
		double[] monthlySals = {22000.00,330000.00,44000.00,89000.00,150000.00,250000.00,31000.00,84000.00,35000.00,19000.00};
		double[] newMonthlySals = new double[10];
		double[] annualSalaries = new double[10];
		int[] experience = new int[10];
		
		populateExperience(experience);
		
		calcIncrease(experience,monthlySals,newMonthlySals);
		
		calcAnnualSal(monthlySals,annualSalaries);
		
		int option = getUserOption();
		
		while(true)
		{
			switch(option)
			{
				case 1:
					 sortEmployeeDetails(employeesNames,experience,monthlySals,newMonthlySals,annualSalaries);
					 displayEmployeeDetails(employeesNames,monthlySals,newMonthlySals,annualSalaries,experience);
					 break;
				case 2:
					 int lowestIndex = determineLowestSalary(newMonthlySals);
					 System.out.println(employeesNames[lowestIndex] + "\t\tR" + newMonthlySals[lowestIndex]);
					 break;
				case 3:
					 System.out.println("Good bye!!");
					 return;
				default:
					 System.out.println("Invalid option!!");
					 
					 break;
						
			}
			option = getUserOption();
		}
		
	}
	
}