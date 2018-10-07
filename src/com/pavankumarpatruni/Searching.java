package com.pavankumarpatruni;

import java.util.Arrays;

public class Searching {
	
	private static int[] array = {19,28,12,1,6,3,9,54};
	
	private void linearSearch(int value) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == value) {
				System.out.println("Linear search took " + (index+1) + " iterations to found " + value);
				break;
			}
		}
	}
	
	private void binarySearch(int value) {
		int count = 0; 
		int start = 0;
		int end = array.length;
		int pivot = (start + end) /2;
		
		while(pivot < end) {					
			count++;
			if (array[pivot] == value) {
				System.out.println("Binary search took " + count + " iterations to found " + value);
				break;
			} else if (array[pivot] > value) {
				end = pivot;				
			} else {
				start = pivot + 1;
			}
			
			pivot = (start + end) /2;
		}
	}
	
	private void linearSearch(int[] array, int value, int count) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == value) {
				System.out.println("Jump search took " + (count + index + 1) + " iterations to found " + value);
				break;
			}
		}
	}
	
	private void jumpSearch(int value) {
		int step = (int)Math.floor(Math.sqrt(array.length));
		int stepSize = step;
		int count = 0;
		
		while(step < array.length) {			
			count++;
			if (array[step] == value) {
				System.out.println("Jump search took " + count + " iterations to found " + value);
				break;
			} else if (array[step] < value) {
				step *= 2;
			} else  if (array[step] > value) {
				int index = 0;
				if (step != stepSize) {
					step = step / 2;					
					index = step + 1;
				}
				
				int[] tempArray = new int[step];
				
				System.arraycopy(array, index, tempArray, 0, tempArray.length);
				
				linearSearch(tempArray, value, count);
				break;
			}
		}
		
		if (step >= array.length) {
			step = (step / 2) + 1;
			
			int[] tempArray = new int[array.length - step];			
			
			System.arraycopy(array, step, tempArray, 0, tempArray.length);
	
			linearSearch(tempArray, value, count);
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Input array is " + Arrays.toString(array));
		
		Searching searching  = new Searching();
		
		searching.linearSearch(3);
		
		Arrays.sort(array);
		
		System.out.println("After Sorting " + Arrays.toString(array));
		searching.linearSearch(3);
		searching.binarySearch(3);
		searching.jumpSearch(12);
	}
}
