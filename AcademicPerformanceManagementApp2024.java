import java.util.Scanner;
import java.util.Random;
public class AcademicPerformanceManagementApp2024
{
	public static void  populateYearOfStudy (int[] yearsOfStudy)
	{
		Random rand = new Random();
		for(int i = 0;i < yearsOfStudy.length;i++)
		{
			yearsOfStudy[i] = rand.nextInt(5)+1;
		}
	}
	public static void  populateFailedModules (String[] studentIDs, int[] failedModules)
	{
		Scanner input = new Scanner(System.in);
		for(int i = 0;i < failedModules.length;i++)
		{
			System.out.print("Enter number of failed modules " + studentIDs[i] + ":");
			int numModules =  input.nextInt();
			
			boolean isValid = validateFailedModules(numModules);
			
			while(!isValid)
			{
				System.out.println("Invalid number of modules entered, students can fail from 0 to 6 modules.");
				System.out.print("Enter number of failed modules " + studentIDs[i] + ":");
			    numModules =  input.nextInt();
			
			    isValid = validateFailedModules(numModules);
			}
			
			failedModules[i] = numModules;
		}
	}
	public static boolean validateFailedModules(int numModules)
	{
		boolean isValid = false;
		if(numModules >= 0 && numModules < 6)
		{
			isValid = true;
		}
		return isValid;
	}
	public static char getUserOption()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Select any option to start or continue:");
		System.out.println("\t 1/A Display all students in the academic performance monitoring list");
		System.out.println("\t 2/S Search for students status using student ID");
		System.out.println("\t 3/X Exit");
		char option = Character.toUpperCase(input.next().charAt(0));
		return option;
	}
	public static void determineRecommendation(int[] failedModules, int[] yearsOfStudy, String[] academicStatuses)
	{
		for(int i = 0; i < failedModules.length;i++)
		{
			if(yearsOfStudy[i] >=1 && yearsOfStudy[i] <=3)
			{
				if(failedModules[i] >= 0 && failedModules[i] <= 1)
				{
					academicStatuses[i] = "Good Standing, no recommendation required";
				}else if(failedModules[i] >= 2 && failedModules[i] <= 3)
				{
					academicStatuses[i] = "Probation with Tutoring & Academic Advising";
				}else{
					academicStatuses[i] = "Exclusion, may appeal";
				}
			}else if(yearsOfStudy[i] >=4 && yearsOfStudy[i] <=5)
			{
				if(failedModules[i] >= 0 && failedModules[i] <= 1)
				{
					academicStatuses[i] = "Good Standing, no recommendation required";
				}else if(failedModules[i] >= 2 && failedModules[i] <= 3)
				{
					academicStatuses[i] = "Probation, if able to complete in time and Academic Advising & Monitoring";

				}else{
					academicStatuses[i] = "Exclusion, may appeal";
				}
			}
		}
	}
	public static int searchStudent(String studSearch, String[] studentIDs)
	{
		int index = -1;
		for(int i = 0; i < studentIDs.length;i++)
		{
			if(studentIDs[i].equals(studSearch))
			{
				index = i;
			}
		}
		return index;
	}
	public static void displayAllStudents(String[] studentIDs, String[] courses,int[] yearsOfStudy,int[] failedModules,String[] academicStatuses)
	{
		System.out.println("**************************************************");
		System.out.println("Stud#\t\tCourse\t\tYear\t\tFailed Modules\t\tRecomendation");
		for(int i = 0; i < studentIDs.length;i++)
		{
			System.out.println(studentIDs[i] + "\t\t" + courses[i] + "\t\t" + yearsOfStudy[i] + "\t\t" + failedModules[i] + "\t\t" + academicStatuses[i]);
		}
		System.out.println("**************************************************");
	}
	public static void  main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int[] studentIDs = {23001,43002,43003,53014,63205};
		String[] courses = {"Computer Science","Computer Systems","Dip Informatics","Information Technology","Dip Informatics"};
		int[] yearsOfStudy = new int[studentIDs.length];
		int[] failedModules = new int[studentIDs.length];
        String[] academicStatuses = new String[courses.length];
		
		populateYearOfStudy(yearsOfStudy);
		
		populateFailedModules(studentIDs,failedModules);
		
		determineRecommendation(failedModules,yearsOfStudy,academicStatuses);
		
		char option = getUserOption();
		
		while(!option == '3' || !option == 'X')
		{
			switch(option)
			{
				case'1':
				case'A':
				    displayAllStudents(studentIDs,courses,yearsOfStudy,failedModules,academicStatuses);
					break;
				case'2':
				case'S':
					System.out.print("Enter the student ID you searching for :");
					String studSearch = input.next();
					int index = searchStudent(studSearch,studentIDs);
					if(!index = -1)
					{
						System.out.println("Stud#\t\tCourse\t\tYear\t\tFailed Modules\t\tRecomendation");
						System.out.println(studentIDs[index] + "\t\t" + courses[index] + "\t\t" + yearsOfStudy[index] + "\t\t" + failedModules[index] + "\t\t" + academicStatuses[index]);
						System.out.println("**************************************************");
					}else{
						System.out.println("Student " + studSearch + " not found");
					}
					break;
				case'3':
				case'X':
					System.out.println("Good Bye!!!!");
					break;
				default:
					System.out.println("Invalid option");
					System.out.println("************************************************");
					
			}
			option = getUserOption();
		}
		
		
	}
}