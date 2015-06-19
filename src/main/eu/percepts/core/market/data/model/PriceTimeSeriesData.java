package net.quantworx.core.market.data.model;

import java.util.Date;
import java.util.Map;

public class PriceTimeSeriesData
{
	
	private long id;
	
	private String ticker;
	private Date tradeDate;

	private PriceTimeSeriesDataKey key;
	
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private double adjustedClosePrice;
	private long tradeVolume;
	
	private Map<Date, QuoteData> intraDayPriceData;

}
