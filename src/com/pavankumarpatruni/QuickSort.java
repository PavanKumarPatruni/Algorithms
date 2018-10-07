package com.pavankumarpatruni;

import java.util.Arrays;

public class QuickSort {

	private static int[] array = {1, 3, 5, 12, 7, 6, 2, 4};
	
	private void sortArray(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}
	
		int pivot = array[(start + end)/2];
		
		int partitionIndex = partition(array, start, end, pivot);
		
		sortArray(array, start, partitionIndex - 1);
		sortArray(array, partitionIndex, end);
	}
	
	private int partition(int[] array, int start, int end, int pivot) {
		while(start <= end) {
			
			while(array[start] < pivot) {
				start++;
			}
			while(array[end] > pivot) {
				end--;
			}
			
			if (start <= end) {
				swap(array ,start, end);
				start++;
				end--;
			}
		}
		
		return start;
	}

	private void swap(int[] array, int start, int end) {
		int total = array[start] + array[end];
		array[start] = total - array[start];
		array[end] = total - array[start];
		
	}

	public static void main(String args[]) {
		
		System.out.println("Input array is " + Arrays.toString(array));
		
		QuickSort quickSort = new QuickSort();
		quickSort.sortArray(array, 0, array.length-1);
		
		System.out.println("Sorted array is " + Arrays.toString(array));
	}
	
}
