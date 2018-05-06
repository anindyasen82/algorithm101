package com.subarray;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxSubArrayCalculatorTest {
	
	private MaxSubArrayCalculator calculator;
	
	@Before
	public void init() {
		calculator = new MaxSubArrayCalculator();
	}

	@Test
	public void testWithNegativeAndPositive() {
		int[] numbers = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSum = calculator.calculate(numbers);
		assertEquals(6, maxSum, 0);
	}

	@Test
	public void testWithNegativeOnly() {
		int[] numbers = {-2, -3, -4, -1, -5, -6};
		int maxSum = calculator.calculate(numbers);
		assertEquals(-1, maxSum, 0);
	}

	@Test
	public void testWithPositiveOnly() {
		int[] numbers = {2, 3, 4, 1, 5, 6};
		int maxSum = calculator.calculate(numbers);
		assertEquals(21, maxSum, 0);
	}

	@Test
	public void testWithEmptyInput() {
		int[] numbers = {};
		int maxSum = calculator.calculate(numbers);
		assertEquals(0, maxSum, 0);
	}

	@Test
	public void testWithNullInput() {
		int maxSum = calculator.calculate(null);
		assertEquals(0, maxSum, 0);
	}

}
