package com.sort.impl;

import com.sort.Sort;

public class InsertionSort implements Sort {

	@Override
	public int[] ascend(int[] arrayToSort) {
		if(arrayToSort == null) {
			return null;
		}
		
		for(int j = 1; j < arrayToSort.length; j++) {
			int elementToBeInserted = arrayToSort[j];
			
			int i = j - 1;
			while(i >= 0 && arrayToSort[i] > elementToBeInserted) {
				arrayToSort[i + 1] = arrayToSort[i];
				i--;
			}
			
			arrayToSort[i + 1] = elementToBeInserted;
		}
		
		return arrayToSort;
	}

	@Override
	public int[] descend(int[] arrayToSort) {
		if(arrayToSort == null) {
			return null;
		}
		
		for(int j = 1; j < arrayToSort.length; j++) {
			int elementToBeInserted = arrayToSort[j];
			
			int i = j - 1;
			while(i >= 0 && arrayToSort[i] < elementToBeInserted) {
				arrayToSort[i + 1] = arrayToSort[i];
				i--;
			}
			
			arrayToSort[i + 1] = elementToBeInserted;
		}
		
		return arrayToSort;
	}

}
