package net.quantworx.core.service;

public interface TimeValue
{
	
	
	/**
	 * 
	 * @param prensentValue
	 * @param ratePerAnum
	 * @param numYears
	 * @param conpundingPeriodsPerYear
	 * @return
	 */
	public double futureValue(double prensentValue, double ratePerAnum, int numYears, int conpundingPeriodsPerYear);
	
	/**
	 * 
	 * @param prensentValue
	 * @param ratePerAnum
	 * @param numYears
	 * @return
	 */
	public double futureValue(double prensentValue, double ratePerAnum, int numYears);
	
	
	public double presentValue(double futureValue, double ratePerAnum, int numYears, int conpundingPeriodsPerYear);
	
	public double presentValue(double futureValue, double ratePerAnum, int numYears);
	

}
