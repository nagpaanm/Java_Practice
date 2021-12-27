package minimumMovesToMakeArrayElementsEqual2;

import java.util.Arrays;

/*
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer
 */

public class Solution {
	public int minMoves2(int[] nums) {
		   // sort the array
		// O(nlogn)
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        // O(n)
        while(left < right){
            count += nums[right] - nums[left];
            left++;
            right--;
        }
        return count;
    }
}
