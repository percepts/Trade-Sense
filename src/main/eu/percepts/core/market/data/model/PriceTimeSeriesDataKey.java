package net.quantworx.core.market.data.model;

import java.util.Date;
import java.util.Map;

public class PriceTimeSeriesDataKey
{
	
	
	private String ticker;
	private Date tradeDate;
	
	
	public PriceTimeSeriesDataKey(String ticker, Date tradeDate)
	{		
		this.ticker = ticker;
		this.tradeDate = tradeDate;
	}
	
	/**
	 * @return the ticker
	 */
	public String getTicker() {
		return ticker;
	}
	/**
	 * @return the tradeDate
	 */
	public Date getTradeDate() {
		return tradeDate;
	}
}