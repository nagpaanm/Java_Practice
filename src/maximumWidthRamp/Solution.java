package maximumWidthRamp;

/*
 * A ramp in an integer array nums is a pair (i, j) for which i < j and 
 * nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. 
If there is no ramp in nums, return 0.
 */

public class Solution {
	public int maxWidthRamp(int[] nums) {
        int length = nums.length;
        int maxRamp = 0;
        int j = length - 1;
        while(0 < j){
            for(int i = 0; i < j; i++){
                if(nums[i] <= nums[j]){
                    if(j - i > maxRamp){
                        maxRamp = j - i;
                    }
                }
            }
            j--;
            if(j - 0 < maxRamp){
                return maxRamp;
            }
        }
    
        return maxRamp;
    }
}
