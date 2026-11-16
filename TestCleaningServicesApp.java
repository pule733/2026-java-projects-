import java.util.Scanner;
import java.text.DecimalFormat;

public class TestCleaningServicesApp
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        // Prompt for service details
        System.out.print("Enter the type of service you are requesting (Cleaner, Gardner, Handyman): ");
        String serviceType = input.nextLine();

        System.out.print("Enter the number of hours required for the service: ");
        int hours = input.nextInt();

        System.out.print("Enter the normal hourly rate per day: ");
        double serviceRate = input.nextDouble();

        System.out.print("Enter the extra hourly rate per day: ");
        double extraHoursRate = input.nextDouble();

        // Creating the service object
        CleaningServicesApp service = new CleaningServicesApp(
            serviceType,
            serviceRate,
            extraHoursRate,
            hours
        );

        // Displaying service details and total cost
        System.out.println("================== Service Required ============");

        System.out.println("Service Required: " + service.getServiceName());
        System.out.println("Normal Hours: " + service.getNormalHours());
        System.out.println("Normal Hourly Rate: R" + df.format(service.getNormalHourlyRate()));
        System.out.println("Extra Rate: R" + df.format(service.getExtraHourlyRate()));
        System.out.println("Total Service Fee: R" + df.format(service.calculateServiceCost()));
    }
}