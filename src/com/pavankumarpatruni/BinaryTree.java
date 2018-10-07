package com.pavankumarpatruni;

class Node {
	private Node left, right;
	private int data;
	
	Node(int data) {
		this.data = data;
	}
	
	void insert(int value) {
		if (value < data) {
			if (left == null) {
				left = new Node(value);

			} else {
				left.insert(value);
			}
		} else if (value > data) {
			if (right == null) {
				right = new Node(value);

			} else {
				right.insert(value);
			}
		}
	}
	
	boolean contains(int value) {
		if (data == value) {
			return true;	
		} else {
			if (data > value) {
				if (left == null) {
					return false;
				} else {
					return left.contains(value);
				}
			} else {
				if (right == null) {
					return false;
				} else {
					return right.contains(value);
				}
			}
		}
	}

	void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.print(data);
		if (right != null) {
			right.printInOrder();
		}
	}
	
	void printPreOrder() {
		System.out.print(data);
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}
	
	void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.print(data);
	}
}

public class BinaryTree {
	public static void main(String args[]) {
		
		Node node = new Node(3);
		node.insert(1);
		node.insert(4);
		node.insert(2);
		node.insert(10);
		node.insert(16);
		node.insert(13);
		node.insert(10);
		node.insert(18);
		
		System.out.println(node.contains(18));
		System.out.println(node.contains(10));
		System.out.println(node.contains(19));
		
		System.out.println("INORDER");
		node.printInOrder();
		System.out.println();
		
		System.out.println("PREORDER");
		node.printPreOrder();
		System.out.println();
		
		System.out.println("POSTORDER");
		node.printPostOrder();
	}
}
