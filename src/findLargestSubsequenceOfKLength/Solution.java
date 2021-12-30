package findLargestSubsequenceOfKLength;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an integer array nums and an integer k. You want to find a 
ubsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting 
some or no elements without changing the order of the remaining elements.
 */

public class Solution {
	public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        List<Integer> indices = new ArrayList<Integer>();
        int counter = nums.length - k;
        while(counter != 0){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i = 0; i < nums.length; i ++){
                if(nums[i] <= min && !indices.contains(i)){
                    min = nums[i];
                    index = i;
                }
            }
            indices.add(index);
            counter--;
        }
        int val = 0;
        for(int i = 0; i < nums.length; i++){
            if(!indices.contains(i)){
                result[val] = nums[i];
                val++;
            }
        }
        return result;
    }
}
