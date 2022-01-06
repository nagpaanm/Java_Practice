package minimumSizeSubArraySum;

/*
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., 
 * numsr-1, numsr] of which the sum is greater than or equal to target. 
 * If there is no such subarray, return 0 instead.
 */

// sliding window -> O(n) time
public class Solution {
	public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(j < nums.length){
            if(sum < target){
                sum += nums[j];
                j++;
            }
            if(sum >= target){
                while(sum >= target){
                    min = Math.min(j - i, min);
                    sum = sum - nums[i];
                    i++;
                }
            }
        }
        
        if(Integer.MAX_VALUE == min){
            return 0;
        }
        return min;
    }
}
