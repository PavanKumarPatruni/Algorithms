package com.pavankumarpatruni;

public class Stack {

	private static class Node {
		private Node next;
		private int data;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node top = null;
	
	private boolean isEmpty() {
		return top == null;
	}
	
	private int peek() {
		return top != null ? top.data : -1;
	}
	
	private void push(int data) {
		Node node = new Node(data);
		node.next = top;
		top = node;
	}
	
	private void pop() {
		if (top != null) {
			System.out.println("Deleting " + top.data);
			top = top.next;
		}
	}
	
	private void print() {
		if (isEmpty()) {
			System.out.println("Empty");
			return;
		}
		Node node = top;
		while(node != null) {
			System.out.print(node.data);
			node = node.next;
			if (node != null) {
				System.out.print(", ");
			}
		}
		
		System.out.println();
	}
	
	public static void main(String args[]) {
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		stack.push(9);
		stack.push(10);
		
		System.out.println("Peek " + stack.peek());
		
		stack.print();
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("Peek " + stack.peek());
		
		stack.print();
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("Peek " + stack.peek());
		
		stack.print();
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		System.out.println("Peek " + stack.peek());
		
		stack.print();
		
		stack.pop();
		
		System.out.println("Peek " + stack.peek());
		
		stack.print();
	}
}
