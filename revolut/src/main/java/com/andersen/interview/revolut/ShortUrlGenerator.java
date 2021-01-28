package com.andersen.interview.revolut;

import com.andersen.interview.revolut.configs.ShortUrlConfig;

/**
 * Class for generating short URL with different options.
 * 
 * @author Vadim Sorokin
 *
 */
public class ShortUrlGenerator {
	private static final String INVALID_SEO_KEYWORD_ERROR_MESSAGE = "SEO keyword is not valid. It must be not null and not greater than 20 charcters.";
	private static final String URL_SCHEME_DEFAULT = "http://";
	private static final String SHORT_DOMAIN_NAME_DEFAULT = "short.com";
	private static final String PATH_DELIMETER = "/";
	private static final int MAX_LENGTH_OF_SEO_KEYWORD_DEFAULT = 20;

	private String urlScheme = URL_SCHEME_DEFAULT;
	private String shortDomainName = SHORT_DOMAIN_NAME_DEFAULT;
	private int maxLengthOfSeoKeyword = MAX_LENGTH_OF_SEO_KEYWORD_DEFAULT;

	/**
	 * Default constructor with default settings for the generator.
	 */
	public ShortUrlGenerator() {

	}

	/**
	 * Constructor with abilities to specify custom settings.
	 * 
	 * @param shortUrlConfig - aggregation of settings available for customization
	 */
	public ShortUrlGenerator(final ShortUrlConfig shortUrlConfig) {
		if (shortUrlConfig != null) {
			processConfig(shortUrlConfig);
		}
	}

	/**
	 * Method checks if some custom setting was provided and if yes then override
	 * default one.
	 * 
	 * @param shortUrlConfig - aggregation of settings available for customization
	 */
	private void processConfig(final ShortUrlConfig shortUrlConfig) {
		if (shortUrlConfig.getUrlScheme() != null) {
			urlScheme = shortUrlConfig.getUrlScheme();
		}
		if (shortUrlConfig.getShortDomainName() != null) {
			shortDomainName = shortUrlConfig.getShortDomainName();
		}
		if (shortUrlConfig.getMaxLengthOfSeoKeyword() > 0) {
			maxLengthOfSeoKeyword = shortUrlConfig.getMaxLengthOfSeoKeyword();
		}
	}

	/**
	 * Method generates a short URL. It replaces a domain name with shorter one and
	 * a path with SEO keyword.
	 * 
	 * @param url        - basic URL
	 * @param seoKeyword - replacement for path
	 * @return generated short URL
	 */
	public String generateWithSeoKeyword(final String url, final String seoKeyword) {
		final String result;

		if (!isSeoKeywordValid(seoKeyword)) {
			throw new IllegalArgumentException(INVALID_SEO_KEYWORD_ERROR_MESSAGE);
		}
		result = buildUrl(seoKeyword);

		return result;
	}

	/**
	 * Method concatenates all parts of URL.
	 * 
	 * @param path - path for appending
	 * @return concatenated URL.
	 */
	private String buildUrl(final String path) {
		final StringBuilder result = new StringBuilder();

		result.append(urlScheme);
		result.append(shortDomainName);
		result.append(PATH_DELIMETER);
		result.append(path);

		return result.toString();

	}

	/**
	 * Method checks validity of a SEO keyword.
	 * 
	 * @param seoKeyword - SEO keyword
	 * @return result of validation. <code>true</code> - valid, <code>false</code> -
	 *         otherwise
	 */
	private boolean isSeoKeywordValid(final String seoKeyword) {
		boolean result = false;

		if (seoKeyword != null && seoKeyword.length() > 0 && seoKeyword.length() <= maxLengthOfSeoKeyword) {
			result = true;
		}

		return result;
	}
}
