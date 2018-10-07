 package com.pavankumarpatruni;

 import java.util.Stack;
 
public class ReverseStack {

private static Stack<Integer> stack = new Stack<Integer>();
	
	private static void addToBottom(int temp) {
		if (stack.isEmpty()) {
			stack.push(temp);
		} else {
			int peek = stack.peek();
			stack.pop();
			addToBottom(temp);
			stack.push(peek);
		}
	}
	
	private static void reverse() {
		if(!stack.isEmpty()) {
			int peek = stack.peek();
			
			stack.pop();
			reverse();
			
			addToBottom(peek);
		}
	}
	
	public static void main(String args[]) {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println("Original Stack " + stack);
		
		reverse();
		
		System.out.println("Reverse Stack " + stack);
	}
	
	
}
