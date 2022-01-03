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

// Solution -- O(n) runtime
public class Solution {
	public int waysToMakeFair(int[] nums) {
        int left = 0;
        int ways = 0;
        int totalOddSoFar = 0;
        int totalEvenSoFar = 0;  
        int totalEven = 0;
        int totalOdd = 0;
        int even = 0;
        int odd = 0;
        //calculate total of even and odd
        for(int i = 0 ; i < nums.length; i++){
            if(i % 2 == 0){
                totalEven += nums[i];
            }else{
                totalOdd += nums[i];
            }
        }
        while(left != nums.length){
            if(left % 2 == 0){
                // even = total even so far + total odd - total odd so far
                even = totalEvenSoFar + totalOdd - totalOddSoFar;
                // odd  = total odd so far + total even - total even so far - nums[left]
                odd = totalOddSoFar + totalEven - totalEvenSoFar - nums[left];
            }else{
                // even = total even so far + total odd - total odd so far + nums[left]
                even = totalEvenSoFar + totalOdd - totalOddSoFar - nums[left];
                // odd = total even - total even so far + total odd so far
                odd = totalEven - totalEvenSoFar + totalOddSoFar;
            }
            if(even == odd){
                ways++;
            }
            if(left % 2 == 0){
                // total even so far
                totalEvenSoFar += nums[left];
            }
            else{
                // total odd so far
                totalOddSoFar += nums[left];
            }
            left++;
        }
        
        return ways;
    }
}
