package com.cache.impl;

import com.cache.Cache;
import com.cache.common.Node;

import java.util.HashMap;

public class LRUCache implements Cache {
	private int capacity;
	private HashMap<Integer, Node> map;
	private Node head;
	private Node end;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, Node>(capacity);
	}

	@Override
	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}

		return -9999;
	}

	private void remove(Node node) {
		if (node.previousNode != null) {
			node.previousNode.nextNode = node.nextNode;
		} else {
			head = node.nextNode;
		}

		if (node.nextNode != null) {
			node.nextNode.previousNode = node.previousNode;
		} else {
			end = node.previousNode;
		}

	}

	private void setHead(Node node) {
		node.nextNode = head;
		node.previousNode = null;

		if (head != null) {
			head.previousNode = node;
		}

		head = node;

		if (end == null) {
			end = head;
		}
	}

	@Override
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node oldNode = map.get(key);
			oldNode.value = value;
			remove(oldNode);
			setHead(oldNode);
		} else {
			Node node = new Node(key, value);
			if (map.size() == capacity) {
				map.remove(end.key);
				remove(end);
				setHead(node);
			} else {
				setHead(node);
			}

			map.put(key, node);
		}

	}

}
