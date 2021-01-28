package com.andersen.interview.revolut.configs;

/**
 * Class aggregates all available settings for customization.
 * 
 * @author Vadim Sorokin
 *
 */
public class ShortUrlConfig {
	private String urlScheme;
	private String shortDomainName;
	private int maxLengthOfSeoKeyword;

	public String getUrlScheme() {
		return urlScheme;
	}

	public void setUrlScheme(String urlScheme) {
		this.urlScheme = urlScheme;
	}

	public String getShortDomainName() {
		return shortDomainName;
	}

	public void setShortDomainName(String shortDomainName) {
		this.shortDomainName = shortDomainName;
	}

	public int getMaxLengthOfSeoKeyword() {
		return maxLengthOfSeoKeyword;
	}

	public void setMaxLengthOfSeoKeyword(int maxLengthOfSeoKeyword) {
		this.maxLengthOfSeoKeyword = maxLengthOfSeoKeyword;
	}

}
