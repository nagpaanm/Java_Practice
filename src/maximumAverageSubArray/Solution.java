package maximumAverageSubArray;

/*
 * You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum 
average value and return this value. Any answer with a calculation error less 
than 10-5 will be accepted.
 */

// sliding window -> O(n) runtime
public class Solution {
	public double findMaxAverage(int[] nums, int k) {
        double val = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        double avg = 0;
        while(j < nums.length){
            avg += nums[j];
            if(j - i + 1 == k){
                val = Math.max(avg, val);
                avg -= nums[i];
                i++;
            }
            j++;
        }
        return val / k;
    }
}
