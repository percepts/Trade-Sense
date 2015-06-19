package net.quantworx.data.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.URL;
import java.net.URLConnection;

import net.quantworx.core.market.data.model.EodData;
import net.quantworx.core.market.data.model.QuoteData;
import net.quantworx.core.market.data.model.Security;

//import org.apache.http.client.methods.HttpGet;


/**
 * Provider specific implementation of the MarketDataProvider interface for finance data from Yahoo.com
 * 
 * @author Austin
 */
public class YahooMarketDataProviderImpl
{
    public enum MarketDataType
    {
        QUOTE,
        PRICE_HISTORY,
        INCOME_STATEMENT,
        BALANCE_SHEET,
        CASH_FLOW;
    }
    

    // http://ichart.finance.yahoo.com/table.csv?s=BLT.L&d=3&e=13&f=2011&g=d&a=4&b=15&c=2000&ignore=.csv

     // http://ichart.finance.yahoo.com/table.csv?s=BSY.L&a=0&b=1&c=2011&d=3&e=12&f=2011&g=d&ignore=.csv
    // http://ichart.finance.yahoo.com/table.csv?s=GBPUSED&a=0&b=1&c=2011&d=3&e=12&f=2011&g=d&ignore=.csv

    /* Data service URLs */
    /** Quote data URL */
    private final String QUOTE_URL_PREFIX =     "http://finance.yahoo.com/d/quotes.csv?";  
    /** Historical price data URL */ 
    private final String HISTORICAL_PRICE_URL_PREFFIX = "http://ichart.finance.yahoo.com/table.csv?";
    /* The following are unsupported URLs for screen scraping fundamental finance data */
    private final String INCOME_STATEMENT_URL = "http://uk.finance.yahoo.com/q/is?";
    private final String BALANCE_SHEET_URL =    "http://uk.finance.yahoo.com/q/bs?";
    private final String CASH_FLOW_URL =        "http://uk.finance.yahoo.com/q/cf?";
    
    /** String constants for market data URL parameters */
    private static final char HTTP_PARAM_DELIM = '&';
    private static final char HTTP_VALUE_DELIM = '=';
    
    private static final String FORMAT_PARAM = "f";
    private static final String EMPTY = "";
    
    /** Historical data request parameters */
    private final String SYMBOL_PARAM = "s";
    private final String START_MONTH_PARAM = "a";
    private final String START_DAY_PARAM = "b";
    private final String START_YEAR_PARAM = "c";
    private final String END_MONTH_PARAM = "d";
    private final String END_DAY_PARAM = "e";
    private final String END_YEAR_PARAM = "f";
    private final String INTERVAL = "g";
    
    
    
    /** HTTP Response data, parsed */ 
    private final String FIELD_SEPERATOR = ",";
	
    /**
     * Market data response format codes enum    
     * @author Austin
     *
     */
    private enum MarketDataTerminal
    {
    	ASK ("a", "Ask Price"),
    	BID ("b", "Bid Price"),
    	LAST_TRADE_SIZE ("k1", "Last trade size"),
    	LAST_TRADE_PRICE ("l1", "Last trade price"),
    	DAILY_VOLUME ("v", "daily volume"),
    	LAST_TRADE_TIME ("t1", "Last trade time"),
    	TRADE_DATE(EMPTY, "Trade date"),
    	OPEN (EMPTY, "Open price"),
    	HIGH (EMPTY, "High price"),
    	LOW (EMPTY, "Low price"),
    	CLOSE (EMPTY,"Close price"),
    	VOLUME (EMPTY, "Trading volume"),
    	ADJUSTED_CLOSE (EMPTY, "Adjusted close");
    	
    	
    	private String requestCode;
    	private String name;
    	private 
    	
    	MarketDataTerminal (String code, String name)
    	{	
    		this.requestCode = code;
    		this.name = name;
    	}
    	
    	public String getRequestCode() 
    	{ 	
    		return this.requestCode;
    	}
    	
    	public String getName()
    	{
    		return this.name;
    	}
    	
    	
    	public Object parse(String dataStr)
    	{
    		
    		return null;
    	}
    	
    }
    
   
    
    
    private final String[] QUOTE_FORMAT_PARAMETER = {MarketDataTerminal.ASK.getName() };//"f=abk3l1vt1"; 
    private final String [] QUOTE_REPSONSE_DATA = {"Ask Price", "Bid Price", "Last trade size", "Last trade price", "daily volume"};

    private SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    private SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    private SimpleDateFormat TradeDateFormat = new SimpleDateFormat("yyyy-mm-dd");
    private SimpleDateFormat quoteDateFormat = new SimpleDateFormat("h:mma");
    private SimpleDateFormat finStmtDateFormat = new SimpleDateFormat("dd MMMM yyyyy");
    
    
   // private static ConcurrentMap<String, HttpGet> quoteUriCache;
    /**       */
    private static ConcurrentHashMap<MarketDataType, List<MarketDataTerminal>> responseParseMap;
    

   
    public synchronized List<String> getInterDayPriceData(Security sec, Date startDate, Date endDate) 
    {
        URL url = null;
        URLConnection urlConn = null;
        BufferedReader br = null;
        //String urlStr = buildInterDayURI(t,startDate, endDate);
        try {
            url = new URL("http://ichart.finance.yahoo.com/table.csv?s=BSY.L&a=0&b=1&c=2011&d=3&e=12&f=2011&g=d&ignore=.csv");
                    //new URL(urlStr);
            urlConn = url.openConnection();
            urlConn.getInputStream();
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String s;
            while ((s = br.readLine())!= null)
            {
                System.out.println(s);
            }    
            
        } 
        catch (MalformedURLException ex) {
            Logger.getLogger(YahooMarketDataProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ioe)
        {
            
        }
        finally
        {
            try {
                
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(YahooMarketDataProviderImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }    
        
        return null;
    }

    
    
    public synchronized QuoteData getQuote(Security sec)
    {
        return null;
    }
    
    public List<QuoteData> getQuotes(List<Security> secList)
    {
    	return null;
    }
    




    
    
    protected String constructQuoteURIString(String ticker)
    {
    	StringBuilder sb = new StringBuilder(QUOTE_URL_PREFIX);
    	sb.append(SYMBOL_PARAM).append(ticker).append(HTTP_PARAM_DELIM);
    	sb.append(QUOTE_FORMAT_PARAMETER);    	
    	return sb.toString();
    }



    protected String constructEodDataRequestURI(String ticker, Date startDate, Date endDate)
    {
        StringBuilder sb = new StringBuilder(HISTORICAL_PRICE_URL_PREFFIX);
        // calendar object to use for data component conversion
        Calendar c = Calendar.getInstance();
        int startMonth, endMonth;
        // ensure the dates are set
        if (endDate == null || endDate.getTime() > System.currentTimeMillis())
           endDate = new Date(System.currentTimeMillis()-86400000);
        if (startDate == null || startDate.after(endDate))
           startDate = new Date(System.currentTimeMillis()-86400000);
        // construct date strings
 
        c.setTime(startDate);
        startMonth = c.get(Calendar.MONTH);//Integer.parseInt(monthFormat.format(startDate))-1;
        c.setTime(endDate);
        endMonth =  c.get(Calendar.MONTH); //Integer.parseInt(monthFormat.format(endDate))-1;        
        sb.append(SYMBOL_PARAM).append(HTTP_VALUE_DELIM).append(ticker).append(HTTP_PARAM_DELIM);
        sb.append(START_MONTH_PARAM).append(HTTP_VALUE_DELIM).append(startMonth).append(HTTP_PARAM_DELIM);
        sb.append(START_DAY_PARAM).append(HTTP_VALUE_DELIM).append(dayFormat.format(startDate)).append(HTTP_PARAM_DELIM);
        sb.append(START_YEAR_PARAM).append(HTTP_VALUE_DELIM).append(yearFormat.format(startDate)).append(HTTP_PARAM_DELIM);
        sb.append(END_MONTH_PARAM).append(HTTP_VALUE_DELIM).append(endMonth).append(HTTP_PARAM_DELIM);
        sb.append(END_DAY_PARAM).append(HTTP_VALUE_DELIM).append(dayFormat.format(endDate)).append(HTTP_PARAM_DELIM);
        sb.append(END_YEAR_PARAM).append(HTTP_VALUE_DELIM).append(yearFormat.format(endDate)).append(HTTP_PARAM_DELIM);
        sb.append(INTERVAL).append(HTTP_VALUE_DELIM).append("d");
        return sb.toString();
    }
    
    
    
    /**
     * 
     * Parses f=abk3l1v
     * ask, bid, last trade size, last trade price, volume
     * 
     * @param ticker
     * @param quoteDataStr
     * @return
     */
    private QuoteData parseQuoteData(String ticker, String quoteDataStr)
    {
    	QuoteData qd = new QuoteData(ticker);
    	String [] quoteDataStrings = quoteDataStr.split(FIELD_SEPERATOR);
    	if (quoteDataStrings.length == 5)
    	{
    		
    		for (int i = 0; i < 5 ; i++)
    		{
    			
    		}
    		
    	}
    	
    	
    	return qd;
    }
    
    /**
     * 
     * @param ticker the security exchange ticker or instrument id
     * @param eodDataStr the EOD pricing data string
     * @return the EodData object
     * @throws MarketDataException
     */
    protected EodData parseEodData(String ticker, String eodDataStr) throws MarketDataException
    {
        EodData eodData = new EodData();
        String [] eodDataElems = eodDataStr.split(",");
        eodData.setTicker(ticker);
        try {
        	
			eodData.setTradeDate(TradeDateFormat.parse(eodDataElems[0]));
			eodData.setOpenPrice(Double.parseDouble(eodDataElems[1]));
			eodData.setHighPrice(Double.parseDouble(eodDataElems[2]));
			eodData.setLowPrice(Double.parseDouble(eodDataElems[3]));
			eodData.setClosePrice(Double.parseDouble(eodDataElems[4]));
			eodData.setTradeVolume(Long.parseLong(eodDataElems[5]));
			eodData.setAdjustedClosePrice(Double.parseDouble(eodDataElems[6]));	
		} 
        // cathch parse exception or run time exception (indexout of bounds)
        catch (Exception e) 
        {
			throw new MarketDataException("Exception processing market data = ["+eodDataStr+"] cause = "+ e.getMessage());
		}
        return eodData;
    }        
}