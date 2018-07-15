package com.cache;

public interface Cache {
	
	int get(int key);
	
	void set(int key, int value);

}
