package com.cache.common;

public class Node {
	public int key;
	public int value;
	public Node previousNode;
	public Node nextNode;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

}
