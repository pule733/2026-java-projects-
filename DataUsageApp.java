import java.text.DecimalFormat;
public class DataUsageApp
{
	private double dataConsumed;
	private String planType;
	private double efficiency;
	
	public DataUsageApp()
	{
		dataConsumed = 0.0;
		planType = " ";
		efficiency = 0.0;
	}
	
	public void setDataConsumed(double consumed)
	{
		dataConsumed = consumed;
	}
	
	public void setPlanType(String plan)
	{
		planType = plan;
	}
	
	public void setEfficiency(double eff)
	{
		efficiency = eff;
	}
	
	public void calculateEfficiency(double hoursUsed)
	{
		efficiency = hoursUsed/dataConsumed;
	}
	
	public double determineDataCost()
	{
		double dataCost = 0;
		if(planType.equlasIgnoreCase("Prepaid"))
		{
			dataCost = dataConsumed * 12.00;
		}else if(planType.equlasIgnoreCase("TopUp"))
		{
			dataCost = dataConsumed * 10.00;
		}else if(planType.equlasIgnoreCase("Unlimited"))
		{
			dataCost = 499.00;
		}
		return dataCost;
	}
	
	public String toString(double dataCosts)
	{
		DecimalFormat df = new DecimalFormat("R #.00");
		return "Data Consumed: " + dataConsumed + "GB" + "\nEfficiency: " + efficiency + "GB per hour" + "\nCost:  " + df.format(dataCost);
	}
	
}