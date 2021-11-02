package BinarySearchAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	
	/*
	 * Time Complexity of Binary Search: O(Logn). Much faster than linear 
	 * search, which is O(n)
	 * 
	 * I.e. If a sorted array has 10,000,000 (10 million) elements, then
	 * any element within the array can be located using Binary Search by 
	 * checking roughly 24 elements - which would be SUBSTANTIALLY less than
	 * the required number of elements had linear search been used.
	 */

	public static void main(String[] args) {
		//List<Integer> arr = Arrays.asList(-2,3,4,7,8,9,11,13);
		final int lowerbound = 1;
		final int upperbound = 100000;
		final int valueToFind = (int)Math.floor(Math.random()*(upperbound - lowerbound + 1) + lowerbound);
		List<Integer> arr = new ArrayList<Integer>(); //polymorphism
		for(int i = 0; i < 200000; i++) {
			int randomNumber = (int)Math.floor(Math.random()*(upperbound - lowerbound + 1) + lowerbound);
			if (!arr.contains(randomNumber)) {
				arr.add(randomNumber);
			}
		}
		
		//sort the array using built-in Java module
		long startTime = System.nanoTime();
		Collections.sort(arr);
		long endTime = System.nanoTime();
		double duration = (endTime - startTime);  //nanoseconds
		System.out.println("Collections.sort:, " + duration + " nanoseconds");
		
		// binary search - O(logn) runtime
		startTime = System.nanoTime();
		int index = binarySearch(arr, valueToFind);
		endTime = System.nanoTime();
		duration = (endTime - startTime);  //nanoseconds
		System.out.println("Binary Search: index = " + index + ", " + duration + " nanoseconds");
		
		// linear search - O(n) runtime
		startTime = System.nanoTime();
		index = arr.indexOf(valueToFind);
		endTime = System.nanoTime();
		duration = (endTime - startTime);  //nanoseconds
		System.out.println("Linear Search: index = " + index + ", " + duration + " nanoseconds");
	}
	
	public static int binarySearch(List<Integer> arr, int target) {
		/*
		 * Return the index of target if it exists. Return -1 otherwise.
		 * 
		 * Assumption: all items in arr are already sorted in ascending order.
		 */
		
		int left = 0;
		int right = arr.size() - 1;
		
		//if left is greater than right, target was not found
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr.get(mid) == target) {
				// target is found
				return mid;
			}else if (arr.get(mid) < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		// target not in arr
		return -1;
		
	}
	

}
