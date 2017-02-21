package com;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.cache.impl.LRUCacheTest;
import com.excel.ColumnNameGeneratorTest;
import com.expression.ExpressionTest;
import com.island.IslandCounterTest;
import com.permutation.impl.PermutationProviderArrayImplTest;
import com.permutation.impl.PermutationProviderMapImplTest;
import com.sort.impl.InsertionSortTest;
import com.sort.impl.MergerSortTest;
import com.stack.MaxValueStackTest;
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
	MaxValueStackTest.class
})

public class Algotithm101TestSuite {

}
