package com.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaxValueStackTest {
	
	private MaxValueStack stack;
	
	@Before
	public void init() {
		int[] elements = {1, 3, 2, 4, 5, 3};
		stack = new MaxValueStack(elements.length);
		for (int element : elements) {
			stack.push(element);
		}
	}

	@Test
	public void testPeekMaxWithNoPop() {
		int result = stack.peekMax();
		assertEquals(5, result, 0);
	}

	@Test
	public void testPeekMaxWithMaxElementPop() {
		stack.pop();
		int result = stack.peekMax();
		assertEquals(5, result, 0);
	}

	@Test
	public void testPeekMaxWithMaxElementPop1() {
		stack.pop();
		stack.pop();
		int result = stack.peekMax();
		assertEquals(4, result, 0);
	}

	@Test
	public void testPeekMaxWithMaxElementPop2() {
		stack.pop();
		stack.pop();
		stack.pop();
		int result = stack.peekMax();
		assertEquals(3, result, 0);
	}

}
