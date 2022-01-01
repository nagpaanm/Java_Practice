package checkIfArrayIsSorted;

import java.util.Arrays;

/*
 * Given an array nums, return true if the array was originally sorted in 
 * non-decreasing order, then rotated some number of positions (including zero). 
 * Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length s
uch that A[i] == B[(i+x) % A.length], where % is the modulo operation.
 */


public class Solution {
	public boolean check(int[] nums) {
        int[] copy = nums.clone();
        // O(nlogn)
        Arrays.sort(copy);
        int x = 0;
        int count = 0;
        //O(n^2)
        while(x < nums.length){
            count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == copy[(i + x) % nums.length]){
                    count++;
                }
            }
            if(count == nums.length){
                return true;
            }
            x++;
        }
        return false;
    }
}
