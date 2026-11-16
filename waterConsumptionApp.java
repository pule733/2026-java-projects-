import java.text.DecimalFormat;
public class WaterConsumptionApp{
	//Data members 
	private double initialReading;
	private double finalReading;
	private double consumption;
	private double tarrifCharge;
	
	//methods 
	public WaterConsumptionApp(double initialReading,double finalReading)
	{
		this.initialReading = initialReading;
		this.finalReading = finalReading;
	}
	
	public void calculateConsumption()
	{
		if(finalReading > initialReading)
		{
			consumption = finalReading - initialReading;
		}else{
			System.out.println("Final reading should be greater than or equal to initial reading.");
		}
	}
	public void determineTerrif()
	{
		if(consumption >= 10 && consumption <= 30)
		{
			tarrifCharge = 33.90;
		}else if(consumption >= 31 && consumption <= 61)
		{
			tarrifCharge = 41.75;
		}else{
			if(consumption > 60)
			{
				tarrifCharge = 44.70;
			}
		}			
	}
	
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return "Initial Reading:"+ initialReading + "KL\n" + "Final Reading:" finalReading + "KL/n" + "Consumption" + consumption + "KL/n" + "Tariff Charge: R" + df.format(tarrifCharge) + "per Kl\n" + "Total Amount: R" + df.format(consumption * tarrifCharge);
	}
}