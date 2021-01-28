package com.andersen.interview.revolut.generators;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

/**
 * Class for generating a random alphanumeric sequence.
 * 
 * @author Vadim Sorokin
 *
 */
public class RandomAlphanumericSequenceGenerator {
	private static final String UPPERCASE_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWERCASE_ALPHABET = UPPERCASE_ALPHABET.toLowerCase();
	private static final String DIGITS = "01234566789";
	private static final String ALPHANUMERIC = UPPERCASE_ALPHABET + LOWERCASE_ALPHABET + DIGITS;
	private static final int LENGTH_OF_SEQUENCE_DEFAULT = 4;

	private final Random random;
	private final char[] buffer;

	/**
	 * Constructor with ability to specify length of sequence and concrete random
	 * generator.
	 * 
	 * @param length - length of sequence
	 * @param random - concrete random generator
	 */
	public RandomAlphanumericSequenceGenerator(final int length, final Random random) {
		if (length < 1) {
			throw new IllegalArgumentException("Length of sequence must be not less than 1 element.");
		}

		this.random = Objects.requireNonNull(random);
		this.buffer = new char[length];
	}

	/**
	 * Constructor with ability to specify length of sequence.
	 * 
	 * @param length - length of sequence
	 */
	public RandomAlphanumericSequenceGenerator(final int length) {
		this(length, new SecureRandom());
	}

	/**
	 * Constructor with default settings.
	 */
	public RandomAlphanumericSequenceGenerator() {
		this(LENGTH_OF_SEQUENCE_DEFAULT);
	}

	/**
	 * Method each time generates a new random alphanumeric sequence.
	 * 
	 * @return alphanumeric sequence
	 */
	public String nextSequence() {
		final String result;

		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length()));
		}
		result = new String(buffer);

		return result;
	}

}
