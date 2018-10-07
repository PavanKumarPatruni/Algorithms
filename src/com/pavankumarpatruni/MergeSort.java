package com.pavankumarpatruni;

import java.util.Arrays;

public class MergeSort {
	private static int[] array = {1, 3, 5, 12, 7, 6, 2, 4};
	
	private void sortArray(int[] array, int[] tempArray, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int middle = (start + end) / 2;
		
		sortArray(array, tempArray, start, middle);
		sortArray(array, tempArray, middle + 1, end);
		
		mergeArray(array, tempArray, start, end);
	}
	
	private void mergeArray(int[] array, int[] tempArray, int start, int end) {
		int startEnd = (start + end) / 2;
		int endStart = startEnd + 1;
		
		int size = end - start + 1;
		
		int left = start;
		int right = endStart;
		
		int index = start; 
		
		while(left <= startEnd && right <= end) {
			if (array[left] <= array[right]) {
				tempArray[index] = array[left];
				left++;				
			} else {
				tempArray[index] = array[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(array, left, tempArray, index, startEnd - left + 1);
		System.arraycopy(array, right, tempArray, index, end - right + 1);
		
		System.arraycopy(tempArray, start, array, start, size);
	}
	
	public static void main(String args[]) {
		
		System.out.println("Input array is " + Arrays.toString(array));
		
		MergeSort mergeSort = new MergeSort();
		mergeSort.sortArray(array, new int[array.length], 0, array.length-1);
		
		System.out.println("Sorted array is " + Arrays.toString(array));
	}

}
