package net.quantworx.core.market.data.model;

import java.util.Date;

public class EodData
{
	
	private String ticker;
	private Date tradeDate;	
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private long tradeVolume;
	private double adjustedClosePrice;
	
	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}
	/**
	 * @param ticker the ticker to set
	 */
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	/**
	 * @return the tradeDate
	 */
	public Date getTradeDate() {
		return tradeDate;
	}
	/**
	 * @param tradeDate the tradeDate to set
	 */
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	/**
	 * @return the openPrice
	 */
	public double getOpenPrice() {
		return openPrice;
	}
	/**
	 * @param openPrice the openPrice to set
	 */
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	/**
	 * @return the highPrice
	 */
	public double getHighPrice() {
		return highPrice;
	}
	/**
	 * @param highPrice the highPrice to set
	 */
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	/**
	 * @return the lowPrice
	 */
	public double getLowPrice() {
		return lowPrice;
	}
	/**
	 * @param lowPrice the lowPrice to set
	 */
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	/**
	 * @return the closePrice
	 */
	public double getClosePrice() {
		return closePrice;
	}
	/**
	 * @param closePrice the closePrice to set
	 */
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	/**
	 * @return the tradeVolume
	 */
	public long getTradeVolume() {
		return tradeVolume;
	}
	/**
	 * @param tradeVolume the tradeVolume to set
	 */
	public void setTradeVolume(long tradeVolume) {
		this.tradeVolume = tradeVolume;
	}
	/**
	 * @return the adjustedClosePrice
	 */
	public double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}
	/**
	 * @param adjustedClosePrice the adjustedClosePrice to set
	 */
	public void setAdjustedClosePrice(double adjustedClosePrice) {
		this.adjustedClosePrice = adjustedClosePrice;
	}
	
	
	
	

}
