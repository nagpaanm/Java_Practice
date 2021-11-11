package Mergesort;

import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	 * Merge sort algorithm. Worst case run time -> O(nlogn). 
	 * 
	 * *Fastest sorting algorithm*
	 */
	public static void main(String[] args) {
		int[] arr = {1,4,2,6,8,5,3,7};
		//static to call method without initializing
		Mergesort.mergesort(arr);	
		for(int i = 0; i < arr.length; i ++) {
			System.out.print(arr[i] + ", ");
		}
	}

}
