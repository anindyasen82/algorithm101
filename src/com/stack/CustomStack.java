package com.stack;

import java.util.EmptyStackException;

public class CustomStack {
	
	private int[] elements;
	private int size;
	
	public CustomStack(int size) {
		elements = new int[size];
	}
	
	public void push(int element) throws StackOverflowError {
		elements[size] = element;
		size++;
	}
	
	public int pop() throws EmptyStackException {
		if(size == 0) {
			throw new EmptyStackException();
		}
		int element = elements[size - 1];
		size--;
		return element;
		
	}
	
	public int peek() throws EmptyStackException {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return elements[size - 1];
		
	}
	
	public int size() {
		return size;
	}

}
