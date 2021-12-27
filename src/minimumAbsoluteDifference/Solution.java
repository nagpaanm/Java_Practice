package minimumAbsoluteDifference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of distinct integers arr, find all pairs of elements with the
 *  minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair 
[a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 */

// O(nLogn)
public class Solution {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		int minDifference = 1000000;
		// O(nlogn)
		Arrays.sort(arr);
		// O(n)
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i] - arr[i + 1]) < minDifference) {
				minDifference = Math.abs(arr[i] - arr[i + 1]);
			}
		}
		// O(n)
		for (int i = 0; i < arr.length - 1; i++) {
			if (Math.abs(arr[i] - arr[i + 1]) == minDifference) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(arr[i]);
				temp.add(arr[i + 1]);
				result.add(temp);
			}
		}
		return result;
	}
}
