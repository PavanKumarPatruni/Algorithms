package com.pavankumarpatruni;

public class Queue {

	private static class Node {
		private Node next;
		private int data;
		
		private Node(int data) {
			this.data = data;
		}
	}
	
	private Node head = null;
	private Node tail = null;
	
	private boolean isEmpty() {
		return head == null;
	}
	
	private int head() {
		return head != null ? head.data : -1;
	}
	
	private int tail() {
		return tail != null ? tail.data : -1;
	}
	
	private void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
		}
	}
	
	public void remove() {
		if (head != null) {
			head = head.next;
		}
		if (head == null) {
			tail = null;
		}
	}
	
	public static void main(String args[]) {
		Queue queue = new Queue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		queue.add(8);
		queue.add(9);
		queue.add(10);
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.head());
		System.out.println(queue.tail());
		
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.head());
		System.out.println(queue.tail());
		
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.head());
		System.out.println(queue.tail());
		
		queue.remove();
		queue.remove();
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.head());
		System.out.println(queue.tail());
	}
}
