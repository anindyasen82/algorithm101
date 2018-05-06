package com.sort.impl;

import com.sort.Sort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MergerSortTest {

	@Test
	public void testAscend() {
		Sort mergeSort = new MergeSort();

		int[] arrayToSort = { 5, 2, 4, 6, 1, 3 };
		mergeSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);

		arrayToSort = new int[] { 2, 5, 4, 6, 1, 3 };
		mergeSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);

		arrayToSort = new int[] { 1, 2, 3, 4, 5, 6 };
		mergeSort.ascend(arrayToSort);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arrayToSort);
		
		assertNull(mergeSort.ascend(null));
	}

	@Test
	public void testDescend() {
		Sort mergeSort = new MergeSort();

		int[] arrayToSort = { 5, 2, 4, 6, 6, 1, 3, 2 };
		mergeSort.descend(arrayToSort);
		assertArrayEquals(new int[] { 6, 6, 5, 4, 3, 2, 2, 1 }, arrayToSort);
		
		assertNull(mergeSort.descend(null));
	}

}
