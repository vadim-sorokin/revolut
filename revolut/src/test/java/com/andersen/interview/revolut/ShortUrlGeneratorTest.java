package com.andersen.interview.revolut;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ShortUrlGeneratorTest {

	@Test
	public void test_generateWithSeoKeyword_success_1() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "MY-NEW-WS";
		final String expctedUrl = "http://short.com/MY-NEW-WS";

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

	@Test
	public void test_generateWithSeoKeyword_success_2() {
		// prepare
		final ShortUrlGenerator shortUrlGenerator = new ShortUrlGenerator();
		final String url = "http://looooong.com/somepath";
		final String seoKeyword = "POTATO";
		final String expctedUrl = "http://short.com/POTATO";

		// act
		final String result = shortUrlGenerator.generateWithSeoKeyword(url, seoKeyword);

		// assert
		assertEquals(expctedUrl, result);
	}

}
