package net.quantworx.core.market.data.model;

public enum AssetClass 
{
	/**
	 * Share or stock in a public traded company
	 */
	EQUITY,
	/**
	 * Government or corporate debt instrument (bond)
	 */
	DEBT,
	/**
	 * Natural resources included metals and agricultural commodities.  Examples: Gold, Copper, Wheat etc 
	 */
	COMMODITY,
	/**
	 * Foreign currency exchange rates
	 */
	FOREX,
	/**
	 * Composites - usually equity
	 */
	INDEX,
	/**
	 * Derivatives of equity, commodity, debt, index and forex instruments. Derivatives includes 
	 * tradable futures contracts, options and warrants
	 */
	DERIVATIVE
}
