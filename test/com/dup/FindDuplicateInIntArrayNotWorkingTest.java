package com.dup;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FindDuplicateInIntArrayNotWorkingTest {

    private FindDuplicateInIntArrayNotWorking findDuplicateInIntArray;

    @Before
    public void init() {
        findDuplicateInIntArray = new FindDuplicateInIntArrayNotWorking();
    }

    @Test
    public void findDuplicateInIntArrayTestPositiveInt() throws Exception {
        int[] input = {1, 2, 3, 1, 3, 6, 6};
        Set<Integer> duplicateNumbers = findDuplicateInIntArray.findDuplicateInIntArray(input);
        assertEquals(3, duplicateNumbers.size());
        assertEquals(true, duplicateNumbers.contains(1));
        assertEquals(true, duplicateNumbers.contains(3));
        assertEquals(true, duplicateNumbers.contains(6));
    }

    @Test
    public void findDuplicateInIntArrayTestPositiveInt2() throws Exception {
        int[] input = {1, 2, 7, 1, 7, 8, 8};
        Set<Integer> duplicateNumbers = findDuplicateInIntArray.findDuplicateInIntArray(input);
        assertEquals(3, duplicateNumbers.size());
        assertEquals(true, duplicateNumbers.contains(1));
        assertEquals(true, duplicateNumbers.contains(7));
        assertEquals(true, duplicateNumbers.contains(8));
    }

    @Test
    public void findDuplicateInIntArrayTestPositiveInt3() throws Exception {
        int[] input = {14, 21, 35, 14, 35, 6, 6};
        Set<Integer> duplicateNumbers = findDuplicateInIntArray.findDuplicateInIntArray(input);
        assertEquals(3, duplicateNumbers.size());
        assertEquals(true, duplicateNumbers.contains(14));
        assertEquals(true, duplicateNumbers.contains(35));
        assertEquals(true, duplicateNumbers.contains(6));
    }

}
