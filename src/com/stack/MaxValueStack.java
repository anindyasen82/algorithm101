package com.stack;

import java.util.EmptyStackException;

public class MaxValueStack {
	
	private CustomStack elements;
	
	private CustomStack maxValues;
	
	public MaxValueStack(int size) {
		elements = new CustomStack(size);
		maxValues = new CustomStack(size);
	}
	
	public void push(int element) throws StackOverflowError {
		elements.push(element);
		if(maxValues.size() == 0) {
			maxValues.push(element);
		} else {
			int currentMaxValue = element > maxValues.peek() ? element:maxValues.peek(); 
			maxValues.push(currentMaxValue);
		}
	}
	
	public int pop() throws EmptyStackException {
		maxValues.pop();
		return elements.pop();
	}
	
	public int peek() throws EmptyStackException {
		return elements.peek();
		
	}
	
	public int size() {
		return elements.size();
	}
	
	public int peekMax() throws EmptyStackException {
		return maxValues.peek();
	}

}
