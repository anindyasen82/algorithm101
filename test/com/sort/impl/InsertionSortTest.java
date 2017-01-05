package com.sort.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sort.Sort;

public class InsertionSortTest {

	@Test
	public void testAscend() {
		Sort insertionSort = new InsertionSort();

		int[] arrayToSort = { 5, 2, 4, 6, 1, 3 };
		insertionSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);

		arrayToSort = new int[] { 2, 5, 4, 6, 1, 3 };
		insertionSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);

		arrayToSort = new int[] { 1, 2, 3, 4, 5, 6 };
		insertionSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);
	}

	@Test
	public void testDescend() {
		Sort insertionSort = new InsertionSort();

		int[] arrayToSort = { 5, 2, 4, 6, 1, 3 };
		insertionSort.descend(arrayToSort);
		assertArrayEquals(new int[] { 6, 5, 4, 3, 2, 1 }, arrayToSort);
	}

}
