package com.permutation.impl;

import java.util.HashMap;
import java.util.Map;

import com.permutation.PermutationProvider;

public class PermutationProviderMapImpl implements PermutationProvider {

	@Override
	public boolean isPermutation(String firstString, String secondString) {
		if (firstString.length() != secondString.length())
			return false; // Permutations must be same length

		Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
		for (int i = 0; i < firstString.length(); i++) {
			char currentChar = firstString.charAt(i);
			if(letterCount.containsKey(currentChar)) {
				int currentCharCount = letterCount.get(currentChar);
				letterCount.put(currentChar, currentCharCount++);
			} else {
				letterCount.put(currentChar, 1);
			}
		}

		for (int i = 0; i < secondString.length(); i++) {
			char currentChar = secondString.charAt(i);
			if(letterCount.containsKey(currentChar)) {
				int currentCharCount = letterCount.get(currentChar);
				if(currentCharCount-- < 0) {
					return false;
				}
				letterCount.put(currentChar, currentCharCount);
			} else {
				return false;
			}
		}

		return true; // letters array has no negative values, and therefore no positive values either
	}

}
