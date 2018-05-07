package com.combination;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionCombinationCalculatorTest {

    @Test
    public void testCalculate() throws Exception {
        CombinationCalculator combinationCalculator = new RecursionCombinationCalculator(3, 2);
        int result = combinationCalculator.calculate(3, 2);

        assertEquals(3, result);
    }

    @Test
    public void testCalculateForBaseNEqualsR() throws Exception {
        CombinationCalculator combinationCalculator = new RecursionCombinationCalculator(2, 2);
        int result = combinationCalculator.calculate(2, 2);

        assertEquals(1, result);
    }

    @Test
    public void testCalculateForBaseREqualsToZero() throws Exception {
        CombinationCalculator combinationCalculator = new RecursionCombinationCalculator(3, 2);
        int result = combinationCalculator.calculate(3, 0);

        assertEquals(1, result);
    }

    @Test
    public void testCalculateForBaseREqualsToOne() throws Exception {
        CombinationCalculator combinationCalculator = new RecursionCombinationCalculator(3, 2);
        int result = combinationCalculator.calculate(3, 1);

        assertEquals(3, result);
    }

    @Test
    public void testCalculateForBaseRGreaterThanN() throws Exception {
        CombinationCalculator combinationCalculator = new RecursionCombinationCalculator(3, 2);
        int result = combinationCalculator.calculate(3, 5);

        assertEquals(0, result);
    }

}
