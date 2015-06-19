package net.quantworx.core.market.data.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="Security", namespace="http//quantworx.net/marketData/model") 
public class Security 
{
	/**
	 * The security ticker
	 */
	private String ticker;
	/**
	 * The security name/identifier
	 */
	private String securityName;
	/**
	 * The asset class of the security
	 */
	private AssetClass assetClass;
	/**
	 * The exchange or market where the security trades
	 */
	private Exchange tradesOn;
	private Date expiresOn;
	
	private String legalEntityId;
	
	
	

}