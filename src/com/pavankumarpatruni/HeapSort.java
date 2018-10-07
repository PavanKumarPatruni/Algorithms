package com.pavankumarpatruni;

import java.util.Arrays;

public class HeapSort {
	private static int[] array = {1, 3, 5, 12, 7, 6, 2, 4};
	private static int size = array.length;
	
	private static int index = 0, count = 0;
	
	private static int[] heapArray = new int[size];
	
	private void swap(int index1, int index2) {
		int total = heapArray[index1] + heapArray[index2];
		
		heapArray[index1] = total - heapArray[index1];
		heapArray[index2] = total - heapArray[index1];
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return parentIndex * 2 + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return parentIndex * 2 + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}
	
	private boolean hasLeftChild(int parentIndex) {
		return (parentIndex * 2 + 1) < size;
	}
	
	private boolean hasRightChild(int parentIndex) {
		return (parentIndex * 2 + 2) < size;
	}
	
	private boolean hasParent(int childIndex) {
		return ((childIndex - 1) / 2 ) != 0;
	}
	
	private void add(int data) {
		heapArray[index++] = data;
		
		heapifyUp();
	}
	
	private void sort() {
		while (count < array.length) {
			array[index++] = heapArray[0];
			
			heapArray[0] = heapArray[heapArray.length - 1];
			
			heapifyDown();
			
			count++;
		}
	}
	
	private void heapifyUp() {
		int heapIndex = index-1;
		
		while (hasParent(heapIndex) && heapArray[getParentIndex(heapIndex)] > heapArray[heapIndex]) {
			swap(getParentIndex(heapIndex), heapIndex);
			
			heapIndex = getParentIndex(heapIndex);
		}
	}
	
	private void heapifyDown() {
		int index = 0;
		
		while (hasLeftChild(index)) {
			int childIndex = getLeftChildIndex(index);
			
			if (hasRightChild(index) && heapArray[childIndex] > heapArray[getRightChildIndex(index)]) {
				childIndex = getRightChildIndex(index);
			}
			
			if (heapArray[childIndex] > heapArray[index]) {
				break;
			} else {
				swap(childIndex, index);
			}
			
			index = childIndex;
		}
	}
	
	public static void main(String args[]) {
		
		System.out.println("Input array is " + Arrays.toString(array));
		
		HeapSort heapSort = new HeapSort();

		for (int anArray : array) {
			heapSort.add(anArray);
		}
		
		index = 0;
		heapSort.sort();
		
		System.out.println("Sorted array is " + Arrays.toString(array));
	}
}
