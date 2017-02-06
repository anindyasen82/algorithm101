package com.permutation.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.permutation.PermutationProvider;

public class PermutationProviderArrayImplTest {
	
	private PermutationProvider permutationProvider;
	
	@Before
	public void init() {
		permutationProvider = new PermutationProviderArrayImpl();
	}

	@Test
	public void testForUnequalLength() {
		boolean result = permutationProvider.isPermutation("abc", "abcd");
		assertFalse(result);
	}

	@Test
	public void testForFirstStringHasMoreOccurance() {
		boolean result = permutationProvider.isPermutation("abbb", "abbc");
		assertFalse(result);
	}

	@Test
	public void testForSecondStringHasMoreOccurance() {
		boolean result = permutationProvider.isPermutation("abbc", "abbb");
		assertFalse(result);
	}

	@Test
	public void testForPermutation() {
		boolean result = permutationProvider.isPermutation("abbc", "abcb");
		assertTrue(result);
	}

}
