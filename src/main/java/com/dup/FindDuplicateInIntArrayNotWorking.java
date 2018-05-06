package com.dup;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateInIntArrayNotWorking {

    public Set<Integer> findDuplicateInIntArray(int[] input) {
        Set<Integer> duplicateNumbers = new HashSet<>();

        // First check all the values that are
        // present in an array then go to that
        // values as indexes and increment by
        // the size of array
        int length = input.length;
        for (int i = 0; i < length; i++) {
            int index = input[i] % length;
            input[index] += length;
        }

        // Now check which value exists more
        // than once by dividing with the size
        // of array
        for (int i = 0; i < length; i++) {
            if ((input[i] / length) > 1)
                duplicateNumbers.add(i);
        }
        return duplicateNumbers;
    }

}