package com.excel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColumnNameGeneratorTest {
	
	private ColumnNameGenerator columnNameGenerator;
	
	@Before
	public void init() {
		columnNameGenerator = new ColumnNameGenerator();
	}

	@Test
	public void testGenerateFor0() {
		String result = columnNameGenerator.generate(0);
		assertEquals("", result);
	}

	@Test
	public void testGenerateFor1() {
		String result = columnNameGenerator.generate(1);
		assertEquals("A", result);
	}

	@Test
	public void testGenerateFor13() {
		String result = columnNameGenerator.generate(13);
		assertEquals("M", result);
	}

	@Test
	public void testGenerateFor26() {
		String result = columnNameGenerator.generate(26);
		assertEquals("Z", result);
	}

	@Test
	public void testGenerateFor27() {
		String result = columnNameGenerator.generate(27);
		assertEquals("AA", result);
	}

	@Test
	public void testGenerateFor28() {
		String result = columnNameGenerator.generate(28);
		assertEquals("AB", result);
	}

	@Test
	public void testGenerateFor700() {
		String result = columnNameGenerator.generate(700);
		assertEquals("ZX", result);
	}

	@Test
	public void testGenerateFor705() {
		String result = columnNameGenerator.generate(705);
		assertEquals("AAC", result);
	}

	@Test
	public void testGenerateForNegativeIndex() {
		String result = columnNameGenerator.generate(-10);
		assertEquals("", result);
	}

}
