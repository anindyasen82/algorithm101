package com.expression;

import static org.junit.Assert.*;

import org.junit.Test;

import com.expression.Expression;

public class ExpressionTest {

	@Test
	public void testOneInteger() {
		String input = "1";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(1, result, 0);
		
	}

	@Test
	public void testOneDouble() {
		String input = "1.1";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(1.1, result, 0);
		
	}

	@Test
	public void testAddTwoInteger() {
		String input = "1+2";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(3, result, 0);
		
	}

	@Test
	public void testAddOneIntegerOneDouble() {
		String input = "1+2.5";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(3.5, result, 0);
		
	}

	@Test
	public void testAddThreeInteger() {
		String input = "1+2+5";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(8, result, 0);
		
	}

	@Test
	public void testAddThreeDouble() {
		String input = "1.1+2.2+5.3";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(8.6, result, 0);
		
	}

	@Test
	public void testSubtractTwoInteger() {
		String input = "1-2";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(-1, result, 0);
		
	}

	@Test
	public void testIntegerWithAllOperator() {
		String input = "8*4/16+2*3-1/2";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(7.5, result, 0);
		
	}

	@Test
	public void testDoubleWithAllOperator() {
		String input = "1.5+2*5/2-1.9";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(4.6, result, 0);
		
	}

	@Test
	public void testForEmpty() {
		String input = "";
		Expression expression = new Expression(input);
		double result = expression.evaluate();
		assertEquals(0, result, 0);
	}

	@Test
	public void testForInvalidOperator() {
		String input = "1.5+2~5/2-1.9";
		try {
			new Expression(input);
		} catch (Exception e) {
			assertTrue(e instanceof RuntimeException);
		}
	}

}
