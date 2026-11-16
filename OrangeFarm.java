public class OrangeFarm
{
    // data member declaration section
    private int previousWeek;
    private int currentWeek;

    // overloaded constructor
    public OrangeFarm(int prev, int curr)
    {
        previousWeek = prev;
        currentWeek = curr;
    }

    // accessor method
    public double getPrev()
    {
        return previousWeek;
    }

    // accessor method
    public double getCurrent()
    {
        return currentWeek;
    }

    public int calcBoxesNeeded()
    {
        int numTrays, numBoxes;

        numTrays = (int)Math.ceil((previousWeek + currentWeek) / 64.0);
        numBoxes = (int)Math.ceil(numTrays / 7.0);

        return numBoxes;
    }

    public double calculateProfit()
    {
        int numTrays;
        double profit;

        numTrays = (int)Math.ceil((previousWeek + currentWeek) / 64.0);
        profit = numTrays * (34.00 - 13.24);

        return profit;
    }
}