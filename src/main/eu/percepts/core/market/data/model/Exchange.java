package net.quantworx.core.market.data.model;

import java.util.Date;
import java.util.List;

public class Exchange 
{
	/**
	 * The exchange identity, for example: 
	 *   LSE = London Stock Exchange
	 *   NYSE = New York Stock Exchange
	 *   JSE = Johannesburg Stock Exchange 
	 *   NASDAQ
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String exchangeName;
	private String exchangeTimeZone;
	private int tradingDayOpenHour;
	private int tradingDayOpenMinute;
	private int tradingDayCloseHour;
	private int tradingDayCloseMinute;
	private List<Date> businessDays;
	private Country country;
	
	

}
