package com.dup;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInIntArray {

    public Set<Integer> findDuplicateInIntArray(int[] input) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        Set<Integer> duplicateNumbers = new HashSet<>();

        if(input == null) {
            return duplicateNumbers;
        }

        int length = input.length;
        for (int i = 0; i < length; i++) {
            if(!uniqueNumbers.add(input[i])) {
                duplicateNumbers.add(input[i]);
            }
        }

        return duplicateNumbers;
    }

}