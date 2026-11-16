/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package residenceallocationapp;

import java.util.Random;
import java.util.Scanner;

public class ResidenceAllocationApp {
    
    public static void populateDistance(int[] distances) {
        Random rd=new Random();
        for (int i = 0; i < distances.length; i++) {
            distances[i]=rd.nextInt(496)+5;
        }
    }
    public static void populateAverages(Scanner kb, String[] studentNumbers, double[] averages) {
        
        for (int i = 0; i < averages.length; i++) {
            System.out.print("Enter the average for "+studentNumbers[i]+": ");
            double average=kb.nextDouble();
            
            boolean valid=validateAverage(average);
            while(!valid)
             {
                 System.out.println("Invalid average. Enter a value from 0 to 100.");
                 System.out.print("Enter the average for "+studentNumbers[i]+": ");
                 average=kb.nextDouble();
                 
                 valid=validateAverage(average);
             }
            averages[i]=average;
            /*if (valid) {
               averages[i]=average; 
            }else
            {
                System.out.println("Invalid average. Enter a value from 0 to 100.");
                i--;
            }*/
             
        }
    }
    
    private static boolean validateAverage(double average)
    {
        boolean valid=false;
        if (average >= 0 && average <= 100) {
            valid=true;
        }
        return valid;
    }
    
    public static void determineStatus(int[] distances, double[] averages, String[] status)
    {
        for (int i = 0; i < status.length; i++) {
            status[i]="Not Allocated";
            if (distances[i] >= 100) {
                if (averages[i] >= 60) {
                    status[i]="Allocated";
                }else if(averages[i] >= 50 && averages[i] < 60)
                {
                    status[i]="Waiting List";
                }
            } 
        }
    }
    
    public static char getUserOption(Scanner kb)
    {
        char option;
        System.out.print("1/D - Display all applicants"
                       +"\n2/S - Search for an applicant"
                       +"\n3/N - Sort applicants by name"
                       +"\n4/X - Exit"
                       +"\nEnter your option: ");
        option=Character.toUpperCase(kb.next().charAt(0));
        return option;
    }
    
    public static void displayAll(String[] studentNumbers, String[] names, int[] distances, double[] averages, String[] status)
    {
        System.out.println("Student No\tName\tDistance(km)\tAverage\tStatus");
        for (int i = 0; i < status.length; i++) {
            System.out.println(studentNumbers[i]+"\t"+names[i]+"\t"+distances[i]+"\t"+averages[i]+"\t"+status[i]); 
        }
    }
    
    public static int searchStudent(String[] studentNumbers, String studNum)
    {
        int index=-1;
        for (int i = 0; i < studentNumbers.length; i++) {
            if (studentNumbers[i].equals(studNum)) {
                index=i;
                break;
            }
        }
        return index;
    }
    
    public static void sortByName(String[] studentNumbers, String[] names, int[] distances, double[] averages, String[] status) {
        for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < names.length-1; j++) {
                if (names[j].compareToIgnoreCase(names[j+1]) > 0) {
                    String tempName=names[j];
                    names[j]=names[j+1];
                    names[j+1]=tempName;
                    
                    String tempStudNum=studentNumbers[j];
                    studentNumbers[j]=studentNumbers[j+1];
                    studentNumbers[j+1]=tempStudNum;
                    
                    int tempDis=distances[j];
                    distances[j]=distances[j+1];
                    distances[j+1]=tempDis;
                    
                    double tempAve=averages[j];
                    averages[j]=averages[j+1];
                    averages[j+1]=tempAve;
                    
                    String tempSta=status[j];
                    status[j]=status[j+1];
                    status[j+1]=tempSta;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        String[] studentNumbers={"226010101","226020202","226030303","226040404","226050505","226060606","226070707","226080808"};
        String[] names={"Thando","Ayanda","Naledi","Boitumelo","Sipho","Karabo","Mpho","Lindiwe"};
        
        int[] distances=new int[studentNumbers.length];
        double[] averages=new double[studentNumbers.length];
        String[] status=new String[studentNumbers.length];
        
        populateDistance(distances);
        populateAverages(kb, studentNumbers, averages);
        determineStatus(distances, averages, status);
        
        char option=getUserOption(kb);
        
        while (option != '4' && option != 'X') { 
            switch (option) {
                case '1':
                case 'D':
                    displayAll(studentNumbers, names, distances, averages, status);
                break;
                
                case '2':
                case 'S':
                    System.out.print("Enter the student number to search for: ");
                    String studNum=kb.next();
                    
                    int index=searchStudent(studentNumbers, studNum);
                    if (index==-1) {
                        System.out.println("Student number "+studNum+" was not found.");
                    }
                    else
                    {
                        System.out.println(studentNumbers[index]+" "+names[index]+" lives "+distances[index]+" km from campus, average "+averages[index]+"% - "+status[index]);
                    }
                break;
                
                case '3':
                case 'N':
                    sortByName(studentNumbers, names, distances, averages, status);
                    System.out.println("Students sorted alphabetically by name: ");
                    displayAll(studentNumbers, names, distances, averages, status);
                break;
                /*case '4':
                case 'X':
                   
                break;*/
                default:
                    System.out.println("Invalid option. Please choose 1-4 or D, S, N, X.");  
            }
            System.out.println();
            option=getUserOption(kb);
        }
       System.out.println("Goodbye");  
    }
    
}
