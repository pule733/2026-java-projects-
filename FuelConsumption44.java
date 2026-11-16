import java.text.DecimalFormat;
public class FuelConsumption44
{
	private double fuelConsumed;
	private double distance;
	private double efficiency;
	private double fuelCost;
	private String fuelType;
	
	//Constructor to initialize the fuel consumption's data
	public FuelConsumption44(double distance, String fuelType, double fuelConsumed)
	{
		this.distance = distance;
		this.fuelType = fuelType;
		this.fuelConsumed = fuelConsumed;
	}
	//calculate the fuel efficiently
	public void calculateFuelEfficiency()
	{
		efficiency = distance / fuelConsumed;
	}
	//calculate fuel cost
	public void determineFuelCost()
	{
		if(fuelType.equals("95"))
		{
			fuelCost = fuelConsumed * 22.75;
		}else if(fuelType.equals("93"))
		{
			fuelCost = fuelConsumed * 21.15;
		}else if(fuelType.equals("DS"))
		{
			fuelCost = fuelConsumed * 20.70;
		}
	}
	//Display consumption details
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("######.00");
		return "Distance Travelled: " + distance + " Kilometer\nFuel Efficiently: " + efficiency + " kilometers per litre\nCost: R " + df.format(fuelCost);
	}
}