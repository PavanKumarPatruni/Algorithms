package com.pavankumarpatruni;

import java.util.Arrays;

public class PriorityQueue {

	private static class Node {
		private int data;
		private int priority;
		
		private Node(int data, int priority) {
			this.data = data;
			this.priority = priority;
		}
	}
	
	private int size = 0;
	private int capacity = 10;
	private Node[] items = new Node[capacity];
	
	private void ensureCapacity() {
		if (size == capacity) {
			capacity *= 2;
			items = Arrays.copyOf(items, capacity);
		}
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}
	
	private int getParentIndex(int index) {
		return (index - 1) / 2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	private void swap(int index1, int index2) {
		Node temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
	
	private int peek() {
		return items[0] != null ? items[0].data : -1;
	}
	
	private int remove() {
		if (size != 0) {
			Node node = items[0];
			items[0] = items[size-1];
			size--;
			
			swapifyDown();
			
			return node.data;
		}
		
		return -1;
	}
	
	private void add(int data) {
		add(data, 0);
	}
	
	private void add(int data, int priority) {
		ensureCapacity();
		
		Node node = new Node(data, priority);
		items[size++] = node;		
		
		swapifyUp();
	}
	
	private void swapifyUp() {
		int index = size - 1;
		
		while (index != 0 && hasParent(index) && items[getParentIndex(index)].priority < items[index].priority) {			
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}
	
	private void swapifyDown() {
		int index = 0;
		
		while (hasLeftChild(index)) {
			int childIndex = getLeftChildIndex(index);
			
			if (hasRightChild(index) && items[childIndex].priority < items[getRightChildIndex(index)].priority) {
				childIndex = getRightChildIndex(index);
			}
			
			if (items[childIndex].priority < items[index].priority) {
				break;
			} else {
				swap(childIndex, index);
			}
			
			index = childIndex;
		}
	}
	
	public static void main(String args[]) {
		PriorityQueue queue = new PriorityQueue();
	
		queue.add(1);
		queue.add(2, 1);
		queue.add(3);
		queue.add(4, 8);
		queue.add(5, 2);
		queue.add(6);
		queue.add(7, 2);
		queue.add(8, 1);
		queue.add(9, 3);
		queue.add(10, 5);
		queue.add(11, 6);
		queue.add(12, 7);
		queue.add(13, 8);
		queue.add(14, 9);
		
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		
		queue.add(10, 5);
		queue.add(11, 6);
		queue.add(12, 7);
		queue.add(13, 8);
		queue.add(14, 9);
		
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
		System.out.println("Peek " + queue.peek());
		System.out.println("removed " + queue.remove());
	}
	
}
