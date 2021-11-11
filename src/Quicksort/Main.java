package Quicksort;

import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	 * Implementing the quicksort algorithm
	 */

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(3,-2,-1,0,2,4,1);
		quicksort(arr, 0, arr.size() - 1);
		System.out.println(arr);
	}
	
	public static void quicksort(List<Integer> arr, int l, int r) {
		/*
		 * Quick sort algorithm.
		 * 
		 * Runtime Complexity:
		 * - worst-case: Items are already sorted, or lots of duplicates. O(n^2)
		 * - best-case: Selected pivots equally (or almost equally) seperate
		 * 				the list in equal halves each and every time. 
		 * 				O(nlogn)
		 * - average-case: not many duplicates, and ordering of array is random.
		 * 				O(nlogn)
		 */
		if (l >= r) {
			return;
		}
		int p = partition(arr, l, r);
		quicksort(arr, l, p - 1);
		quicksort(arr, p + 1, r);
	}
	
	public static int partition(List<Integer> arr, int l, int r) {
		/*
		 * Partition method for quicksort.
		 * 
		 * Make the pivot the last element.
		 */
		int pivot = arr.get(r);
		int i = l - 1;
		for(int j = l; j < r; j++) {
			if (arr.get(j) < pivot) {
				i++;
				// swap arr[i] and arr[j]
				int temp = arr.get(j);
				arr.set(j, arr.get(i));
				arr.set(i, temp);
			}	
		}
		// swap arr[i + 1] and arr[r]
		int temp = arr.get(r);
		arr.set(r, arr.get(i + 1));
		arr.set(i + 1, temp);
		return i + 1;
	}
	
	public static void quicksortThreeWay(List<Integer> arr, int l, int r) {
		return;
	}
	

}
