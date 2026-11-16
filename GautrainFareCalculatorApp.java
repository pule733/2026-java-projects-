public class GautrainFareCalculatorApp
{
    // Data Members
    private String passengerName;
    private String destinationStation;
    private double fare;

    // Default Constructor
    public GautrainFareCalculatorApp()
    {
        passengerName = "Lerato";
        destinationStation = "Midrand";
        fare = 0.0;
    }

    // Parameterized Constructor
    public GautrainFareCalculatorApp(String pName, String destStation)
    {
        passengerName = pName;
        destinationStation = destStation;
        fare = 0.0;
    }

    // Setter methods   //mutator methods 
    public void setPassengerName(String passName)
    {
        passengerName = passName;
    }

    public void setDestinationStation(String destStation)
    {
        destinationStation = destStation;
    }

    public void setTicketFare()
    {
        fare = determineTicketFare();
    }

    // Determine ticket fare
    private double determineTicketFare()
    {
        double calculatedFare = 0.0;

        switch(destinationStation)
        {
            case "Sandton":
                calculatedFare = 60.00;
                break;

            case "Midrand":
                calculatedFare = 40.00;
                break;

            case "Centurion":
                calculatedFare = 20.00;
                break;

            default:
                calculatedFare = 0.00;
        }

        return calculatedFare;
    }

    // Display ticket details
    public void displayTicketDetails()
    {
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Destination Station: " + destinationStation);
        System.out.println("Ticket Fare: R" + fare);
    }
}