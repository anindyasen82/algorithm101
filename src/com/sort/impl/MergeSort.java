package com.sort.impl;

import com.sort.Sort;

public class MergeSort implements Sort {

	@Override
	public int[] ascend(int[] arrayToSort) {
		if (arrayToSort != null) {
			createSubArray(arrayToSort, new AscendingArrayMerger());
		}
		return arrayToSort;
	}

	@Override
	public int[] descend(int[] arrayToSort) {
		if (arrayToSort != null) {
			createSubArray(arrayToSort, new DescendingArrayMerger());
		}
		return arrayToSort;
	}

	private void createSubArray(int[] arrayToSort, ArrayMerger arrayMerger) {
		// If list is empty; no need to do anything
		if (arrayToSort.length <= 1) {
			return;
		}

		// Split the array in half in two parts
		int[] first = new int[arrayToSort.length / 2];
		int[] second = new int[arrayToSort.length - first.length];
		System.arraycopy(arrayToSort, 0, first, 0, first.length);
		System.arraycopy(arrayToSort, first.length, second, 0, second.length);

		// Sort each half recursively
		createSubArray(first, arrayMerger);
		createSubArray(second, arrayMerger);

		// Merge both halves together, overwriting to original array
		arrayMerger.mergeArray(first, second, arrayToSort);
	}

}
