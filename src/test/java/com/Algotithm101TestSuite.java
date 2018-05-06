package com;

import com.cache.impl.LRUCacheTest;
import com.dup.FindDuplicateInIntArray;
import com.excel.ColumnNameGeneratorTest;
import com.expression.ExpressionTest;
import com.island.IslandCounterTest;
import com.permutation.impl.PermutationProviderArrayImplTest;
import com.permutation.impl.PermutationProviderMapImplTest;
import com.sort.impl.InsertionSortTest;
import com.sort.impl.MergerSortTest;
import com.stack.MaxValueStackTest;
import com.subarray.MaxSubArrayCalculatorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@RunWith(Suite.class)
@Suite.SuiteClasses({
	LRUCacheTest.class,
	ColumnNameGeneratorTest.class,
	ExpressionTest.class,
	IslandCounterTest.class,
	PermutationProviderArrayImplTest.class,
	PermutationProviderMapImplTest.class,
	InsertionSortTest.class,
	MergerSortTest.class,
	MaxValueStackTest.class,
	MaxSubArrayCalculatorTest.class,
	FindDuplicateInIntArray.class
})

public class Algotithm101TestSuite {

}
