package com.sort.impl;

public class DescendingArrayMerger implements ArrayMerger {

	@Override
	public void mergeArray(int[] first, int[] second, int[] merged) {
		// Index Position in first array - starting with first element
		int inedxFirst = 0;

		// Index Position in second array - starting with first element
		int indexSecond = 0;

		// Index Position in merged array - starting with first position
		int indexMerged = 0;

		// Compare elements at iFirst and iSecond,
		// and move smaller element at iMerged
		while (inedxFirst < first.length && indexSecond < second.length) {
			if (first[inedxFirst] > second[indexSecond]) {
				merged[indexMerged] = first[inedxFirst];
				inedxFirst++;
			} else {
				merged[indexMerged] = second[indexSecond];
				indexSecond++;
			}
			indexMerged++;
		}
		// copy remaining elements from both halves - each half will have
		// already sorted elements
		System.arraycopy(first, inedxFirst, merged, indexMerged, first.length - inedxFirst);
		System.arraycopy(second, indexSecond, merged, indexMerged, second.length - indexSecond);
	}

}
