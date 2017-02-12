package com.calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionTest {

	@Test
	public void testOneInteger() {
		String input = "1";
		try {
			Expression expression = new Expression(input);
			double result = expression.evaluate();
			assertEquals(1, result, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAddTwoInteger() {
		String input = "1+2";
		try {
			Expression expression = new Expression(input);
			double result = expression.evaluate();
			assertEquals(3, result, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testAddThreeInteger() {
		String input = "1+2+5";
		try {
			Expression expression = new Expression(input);
			double result = expression.evaluate();
			assertEquals(8, result, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
