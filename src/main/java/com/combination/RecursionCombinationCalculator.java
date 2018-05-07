package com.combination;

import java.util.Arrays;

public class RecursionCombinationCalculator implements CombinationCalculator {

    /*
     * formula: f(n, r) = f(n-1, r) + f(n-1, r-1)
     *
     * Base cases:
     * f(0, 0) = 1
     * f(n, 0) = 1
     * f(n, 1) = n
     * f(n, r) = 0, r > n
     * f(n, r) = 1, r = n
     *
     * Naive recursion approach: Repeating calculation
     *                      (n, r)
     *         (n-1, r)              (n-1, r-1)
     *    (n-2, r)  (n-2, r-1) (n-2, r-1) (n-2, r-2)
     * ..(n)
     *
     * Improved approach: Recursion with cache
     */

    private int [][] cache;

    public RecursionCombinationCalculator(int n, int r) {
        this.cache = new int[n+1][r+1];
        for (int[] cacheRow: cache) {
            Arrays.setAll(cacheRow, cellIndex -> cacheRow[cellIndex] = -1);
        }
    }

    @Override
    public int calculate(int n, int r) {
        // Base cases
        if(r == 0 || r == n) {
            return 1;
        } else if(r == 1) {
            return n;
        } else if(r > n) {
            return 0;
        }

        // Update cache
        if(cache[n][r] == -1) {
            cache[n][r] = calculate(n-1, r) + calculate(n-1, r-1);
        }

        return cache[n][r];
    }
}
