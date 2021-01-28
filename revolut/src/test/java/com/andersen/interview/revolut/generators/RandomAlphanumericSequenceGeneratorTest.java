package com.andersen.interview.revolut.generators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Test;

/**
 * Unit test for RandomAlphanumericSequenceGenerator class.
 * 
 * @author Vadim Sorokin
 *
 */
public class RandomAlphanumericSequenceGeneratorTest {

	@Test
	public void test_nextSequence_success_defaultLengthOf4() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator();
		final int expectedLengthOfSequence = 4;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final int actualLengthOfSequence = result.length();

		assertEquals(expectedLengthOfSequence, actualLengthOfSequence);	
	}

	@Test
	public void test_nextSequence_success_defaultSequenceIsAlphanumeric() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator();
		final boolean expectedIsSequenceAlphanumeric = true;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final boolean actualIsSequenceAlphanumeric = result.chars().allMatch(Character::isLetterOrDigit);

		assertEquals(expectedIsSequenceAlphanumeric, actualIsSequenceAlphanumeric);
	}
	
	@Test
	public void test_nextSequence_success_randomSequencesAreNotRepeated() {
		// Prepare
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator();
		
		// Act
		final String sequence1 = randomAlphanumericSequenceGenerator.nextSequence();
		final String sequence2 = randomAlphanumericSequenceGenerator.nextSequence();
		
		// Assert
		assertNotEquals(sequence1, sequence2);
	}

	@Test
	public void test_nextSequence_success_lengthEquals1() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator(1);
		final int expectedLengthOfSequence = 1;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final int actualLengthOfSequence = result.length();

		assertEquals(expectedLengthOfSequence, actualLengthOfSequence);
	}

	@Test
	public void test_nextSequence_success_sequenceWithLengthOf1ConsistsOfAlphanumericSymbols() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator(1);
		final boolean expectedIsSequenceAlphanumeric = true;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final boolean actualIsSequenceAlphanumeric = result.chars().allMatch(Character::isLetterOrDigit);

		assertEquals(expectedIsSequenceAlphanumeric, actualIsSequenceAlphanumeric);
	}
	
	@Test
	public void test_nextSequence_success_lengthEquals5() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator(5);
		final int expectedLengthOfSequence = 5;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final int actualLengthOfSequence = result.length();

		assertEquals(expectedLengthOfSequence, actualLengthOfSequence);		
	}
	
	@Test
	public void test_nextSequence_success_sequenceWithLengthOf5ConsistsOfAlphanumericSymbols() {
		// Act
		final RandomAlphanumericSequenceGenerator randomAlphanumericSequenceGenerator = new RandomAlphanumericSequenceGenerator(5);
		final boolean expectedIsSequenceAlphanumeric = true;

		// act
		final String result = randomAlphanumericSequenceGenerator.nextSequence();
		final boolean actualIsSequenceAlphanumeric = result.chars().allMatch(Character::isLetterOrDigit);

		assertEquals(expectedIsSequenceAlphanumeric, actualIsSequenceAlphanumeric);	
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_new_fail_lengthLessThan0() {
		// Act
		new RandomAlphanumericSequenceGenerator(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_new_fail_lengthEquals0() {
		// Act
		new RandomAlphanumericSequenceGenerator(0);
	}
}