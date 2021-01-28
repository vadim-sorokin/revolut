package com.andersen.interview.revolut;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.andersen.interview.revolut.configs.ShortUrlConfig;

/**
 * Unit test for ShortUrlGenerator class.
 * 
 * @author Vadim Sorokin
 *
 */
public class ShortUrlGeneratorTest {

	@Test
	public void test_generateWithSeoKeyword_success_seoKeywordLessThan20Symbols() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "MY-NEW-WS";
		final String expctedUrl = "http://short.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test
	public void test_generateWithSeoKeyword_success_seoKeywordEquals20Symbols() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "01234567890123456789";
		final String expctedUrl = "http://short.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_generateWithSeoKeyword_fail_seoKeywordGreaterThan20Symbols() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "012345678901234567890";

		// act
		shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_generateWithSeoKeyword_fail_seoKeywordIsNull() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = null;

		// act
		shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_generateWithSeoKeyword_fail_seoKeywordIsEmpty() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "";

		// act
		shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);
	}

	@Test
	public void test_generateWithSeokeyword_success_overridedShortDomainName() {
		// prepare
		final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
		shortUrlConfig.setShortDomainName("new-short-name.com");
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator(shortUrlConfig);
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "MY-NEW-WS";
		final String expctedUrl = "http://new-short-name.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test
	public void test_generateWithSeokeyword_success_overridedUrlScheme() {
		// prepare
		final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
		shortUrlConfig.setUrlScheme("https://");
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator(shortUrlConfig);
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "MY-NEW-WS";
		final String expctedUrl = "https://short.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test
	public void test_generateWithSeokeyword_success_overridedMaxLengthOfSeoKeyword_lessThan30() {
		// prepare
		final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
		shortUrlConfig.setMaxLengthOfSeoKeyword(30);
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator(shortUrlConfig);
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "01234567890123456789012345678";
		final String expctedUrl = "http://short.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test
	public void test_generateWithSeokeyword_success_overridedMaxLengthOfSeoKeyword_equal30() {
		// prepare
		final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
		shortUrlConfig.setMaxLengthOfSeoKeyword(30);
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator(shortUrlConfig);
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "012345678901234567890123456789";
		final String expctedUrl = "http://short.com/" + seoKeyword;

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_generateWithSeokeyword_fail_overridedMaxLengthOfSeoKeyword_greaterThan30() {
		// prepare
		final ShortUrlConfig shortUrlConfig = new ShortUrlConfig();
		shortUrlConfig.setMaxLengthOfSeoKeyword(30);
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator(shortUrlConfig);
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "0123456789012345678901234567890";

		// act
		shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);
	}
}
