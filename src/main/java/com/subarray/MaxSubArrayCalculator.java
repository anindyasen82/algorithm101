package com.subarray;

public class MaxSubArrayCalculator {
	
	public int calculate(int[] numbers) {
		int maxSum = 0;
		if(numbers != null && numbers.length > 0) {
			maxSum = numbers[0];
			int currentMaxSum = maxSum;
			for (int i = 1; i < numbers.length; i++) {
				int number = numbers[i];
				currentMaxSum = number > (currentMaxSum + number) ? number:(currentMaxSum + number);
				maxSum = maxSum > currentMaxSum ? maxSum:currentMaxSum;
			}
		}
		return maxSum;
	}

}
