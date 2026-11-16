public class CleaningServicesApp
{
    // data member declaration
    private String serviceName;
    private int normalHours;
    private double normalHourlyRate;
    private double extraHourlyRate;

    // Parameterised constructor
    public CleaningServicesApp(String serviceNam, double normalRate, double extraRate, int hours)
    {
        serviceName = serviceNam;
        normalHourlyRate = normalRate;
        extraHourlyRate = extraRate;
        normalHours = hours;
    }

    // Accessor methods
    public String getServiceName()
    {
        return serviceName;
    }

    public int getNormalHours()
    {
        return normalHours;
    }

    public double getNormalHourlyRate()
    {
        return normalHourlyRate;
    }

    public double getExtraHourlyRate()
    {
        return extraHourlyRate;
    }

    public double calculateServiceCost()
    {
        double serviceCost;

        if (normalHours <= 3)
        {
            serviceCost = normalHours * normalHourlyRate;
        }
        else
        {
            serviceCost = (3 * normalHourlyRate)
                       + ((normalHours - 3) * extraHourlyRate);
        }

        return serviceCost;
    }
}