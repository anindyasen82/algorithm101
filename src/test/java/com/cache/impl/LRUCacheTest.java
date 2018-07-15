package com.cache.impl;

import com.cache.Cache;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {
	
	private Cache cache; 
	@Before
	public void init() {
		cache = new LRUCache(3);
	}

	@Test
	public void testGetOnEmptyCache() {
		int result = cache.get(1);
		assertEquals(-9999, result, 0);
	}

	@Test
	public void testSetDuplicateKey() {
		cache.set(1, 23);
		cache.set(1, 32);
		int result = cache.get(1);
		assertEquals(32, result, 0);
	}

	@Test
	public void testGet() {
		cache.set(1, 11);
		cache.set(2, 22);
		cache.set(3, 33);
		
		int result = cache.get(1);
		assertEquals(11, result, 0);
	}

	@Test
	public void testEvictOnContinuousSetMoreThanCapacity() {
		cache.set(1, 11);
		cache.set(2, 22);
		cache.set(3, 33);
		cache.set(4, 44);
		
		int result = cache.get(1);
		assertEquals(-9999, result, 0);
	}

	@Test
	public void testEvictOnGet() {
		cache.set(1, 11);
		cache.set(2, 22);
		cache.set(3, 33);
		
		cache.get(1);
		
		cache.set(4, 44);
		
		int result = cache.get(1);
		assertEquals(11, result, 0);
		
		result = cache.get(2);
		assertEquals(-9999, result, 0);
	}

}
