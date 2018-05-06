package com.permutation.impl;

import com.permutation.PermutationProvider;

public class PermutationProviderArrayImpl implements PermutationProvider {

	@Override
	public boolean isPermutation(String firstString, String secondString) {
		if (firstString.length() != secondString.length())
			return false; // Permutations must be same length

		int[] letters = new int[128]; // Assumption: ASCII
		for (int i = 0; i < firstString.length(); i++) {
			letters[firstString.charAt(i)]++;
		}

		for (int i = 0; i < secondString.length(); i++) {
			letters[secondString.charAt(i)]--;
			if (letters[secondString.charAt(i)] < 0) {
				return false;
			}
		}

		return true; // letters array has no negative values, and therefore no positive values either
	}

}
