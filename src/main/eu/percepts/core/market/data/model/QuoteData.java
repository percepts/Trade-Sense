package net.quantworx.core.market.data.model;

import java.util.Date;

public class QuoteData 
{
	
	
	/**  The security ticker */
	private final String ticker;
	
	/**  System timestamp of quote */ 
	private final Date lastUpdateTime;
	
	/**  The current lowest asking (selling) price */
	private double ask;
	
	/**  The current highest bid (buying) price */
	private double bid;
	
	/** The last trade time */
	private Date lastTradeTime;
	
	/**  The last trade size (quantity) */
	private int lastTradeSize;
	
	/**  The last traded price */
	private double lastTradePrice;
	
	/**  The traded volume for the day thus far */
	private long tradeVolume;
	
	
	public QuoteData(String ticker)
	{
		this.ticker = ticker;
		this.lastUpdateTime = new Date(System.currentTimeMillis());
	}


	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}


	/**
	 * @return the ask
	 */
	public double getAsk() {
		return ask;
	}


	/**
	 * @param ask the ask to set
	 */
	public void setAsk(double ask) {
		this.ask = ask;
	}


	/**
	 * @return the bid
	 */
	public double getBid() {
		return bid;
	}


	/**
	 * @param bid the bid to set
	 */
	public void setBid(double bid) {
		this.bid = bid;
	}


	/**
	 * @return the lastTradeTime
	 */
	public Date getLastTradeTime() {
		return lastTradeTime;
	}


	/**
	 * @param lastTradeTime the lastTradeTime to set
	 */
	public void setLastTradeTime(Date lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}


	/**
	 * @return the lastTradeSize
	 */
	public int getLastTradeSize() {
		return lastTradeSize;
	}


	/**
	 * @param lastTradeSize the lastTradeSize to set
	 */
	public void setLastTradeSize(int lastTradeSize) {
		this.lastTradeSize = lastTradeSize;
	}


	/**
	 * @return the lastTradePrice
	 */
	public double getLastTradePrice() {
		return lastTradePrice;
	}


	/**
	 * @param lastTradePrice the lastTradePrice to set
	 */
	public void setLastTradePrice(double lastTradePrice) {
		this.lastTradePrice = lastTradePrice;
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
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	
}