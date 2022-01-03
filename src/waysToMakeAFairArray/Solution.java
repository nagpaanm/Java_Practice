package waysToMakeAFairArray;

/*
 * You are given an integer array nums. You can choose exactly one index 
 * (0-indexed) and remove the element. Notice that the index of the elements 
 * may change after the removal.

For example, if nums = [6,1,7,4,1]:

Choosing to remove index 1 results in nums = [6,7,4,1].
Choosing to remove index 2 results in nums = [6,1,4,1].
Choosing to remove index 4 results in nums = [6,1,7,4].
An array is fair if the sum of the odd-indexed values equals the sum of the 
even-indexed values.

Return the number of indices that you could choose such that after the removal, 
nums is fair.
 */


public class Solution {
	public int waysToMakeFair(int[] nums) {
        int left = 0;
        int ways = 0;
        int totalOdd = 0;
        int totalEven = 0;  
        while(left != nums.length){
            int even = totalEven;
            int odd = totalOdd;
            for(int i = left + 1; i < nums.length; i++){
                if(i % 2 == 0){
                    odd += nums[i];
                }
                else{
                    even += nums[i];
                }
            }
            
            if(even == odd){
                ways++;
            }
            if(left % 2 == 0){
                totalEven += nums[left];
            }
            else{
                totalOdd += nums[left];
            }
            left++;
        }
        
        return ways;
    }
}
