package com.pavankumarpatruni;

import java.util.Stack;

public class CopyStack {

	private static Stack<Integer> stack = new Stack<>();
	
	private static void addToBottom(int temp) {
		if (stack.isEmpty()) {
			stack.push(temp);
		} else {
			int peek = stack.peek();
			stack.pop();
			addToBottom(peek);
			stack.push(temp);
		}
	}
	
	private static void copy() {
		if(!stack.isEmpty()) {
			int peek = stack.peek();
			
			stack.pop();
			copy();
			
			addToBottom(peek);
		}
	}
	
	public static void main(String args[]) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("Original Stack " + stack);
		
		copy();
		
		System.out.println("Copied Stack " + stack);
	}
	
}
