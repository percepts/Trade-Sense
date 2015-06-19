package net.quantworx.data.provider;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import net.quantworx.core.market.data.model.EodData;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class YahooMarketDataProviderImplTest
{

	private YahooMarketDataProviderImpl yahooMDP = null;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private final PrintStream console = System.out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception {
		
		yahooMDP = new YahooMarketDataProviderImpl();
	}

	@After
	public void tearDown() throws Exception
	{
		
	}

	@Test
	public void testConstructQuoteURIString() 
	{
		
	
	}
	
	
	/**
	 * Tests the construction of yahoo EOD url
	 * Test case 2 - 12/9/2009 to 31/12/2011
	 */
	@Test
	public void testConstructEodDataRequestUriTC1()
	{		
		String expectedRequestStr = "http://ichart.finance.yahoo.com/table.csv?s=OML.L&a=8&b=12&c=2009&d=11&e=31&f=2011&g=d";
		String requestStr = null;
		Date startDate = null, endDate = null;
		try {
			startDate = sdf.parse("2009-09-12");
			endDate = sdf.parse("2011-12-31");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		requestStr = yahooMDP.constructEodDataRequestURI(TICKER_TEST1, startDate, endDate);	
		console.println(requestStr);
		assertEquals(requestStr, expectedRequestStr);

	}
	
	
	/**
	 *  Tests the construction of yahoo EOD url
	 *  Test case 2 - 1/1/2011 to 31/3/2012
	 */
	@Test
	public void testConstructEodDataRequestUriTC2()
	{
		String expectedRequestStr = "http://ichart.finance.yahoo.com/table.csv?s=OML.L&a=0&b=01&c=2011&d=2&e=31&f=2012&g=d";
		String requestStr = null;
		Date startDate = null, endDate = null;
		try {
			startDate = sdf.parse("2011-01-01");
			endDate = sdf.parse("2012-03-31");
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		requestStr = yahooMDP.constructEodDataRequestURI(TICKER_TEST1, startDate, endDate);	
		console.println(requestStr);
		assertEquals(requestStr, expectedRequestStr);
		
	}
	
	
	
	
	/* Test data strings - Tickers*/
	public static final String TICKER_TEST1 = "OML.L";
	/* EOD data strings */
	public static final String EOD_DATA_VALID_TEST1 ="2012-03-19,163.50,166.13,163.00,164.60,8669000,164.60";
	public static final String EOD_DATA_INVALID_TEST1 ="2012/03/19,163.50,166.13,163.00,164.60,8669000,164.60";
	public static final String EOD_DATA_INVALID_TEST2 ="2012-03-19,163.50,166.13,163.00,164.60,8669000.34,164.60";
	/* Test trade date = 2012-03-19 = 1326924180000L */
	public static final Date TEST_TRADE_DATE = new Date (1326924180000L);
	
	
	/**
	 * Tests parsing an EOD data string
	 */
	@Test
	public void testParseEodData() 
	{
		EodData eodData = null;
		try {
			eodData = yahooMDP.parseEodData(TICKER_TEST1, EOD_DATA_VALID_TEST1);
		} catch (MarketDataException e) {
			
		}
		// assert that the 
		assertTrue("", eodData.getTradeDate().equals(TEST_TRADE_DATE));
		assertTrue("", eodData.getOpenPrice() == 163.50);
		assertTrue("", eodData.getHighPrice() == 166.13);
		assertTrue("", eodData.getLowPrice() == 163.00);
		assertTrue("", eodData.getClosePrice() == 164.60);
		assertTrue("", eodData.getTradeVolume() == 8669000);
		assertTrue("The EOD adjusted closed price was not 164.60",eodData.getAdjustedClosePrice() == 164.60);
	}
	
	/**
	 * Tests a malformed EOD data string
	 */
	@Test
	public void testParseMalformedEodData() 
	{
		EodData eodData = null;
		try {
			eodData = yahooMDP.parseEodData(TICKER_TEST1, EOD_DATA_INVALID_TEST1);
		} catch (MarketDataException e) {
			assertNotNull(e);
		}
	}
}
 