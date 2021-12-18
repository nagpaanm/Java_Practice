package maxConsecutiveOnes;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary array nums and an integer k, return the maximum number of 
 * consecutive 1's in the array if you can flip at most k 0's.
 */

public class Solution {
	public int longestOnes(int[] nums, int k) {
        if(k == 0){
            return dfs(nums);
        }
        int max = 0;
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(arr.size() == k){
                max = Math.max(max, dfs(nums));
                int j = arr.get(0);
                arr.remove(0);
                nums[j] = 0;
            }
            if(nums[i] == 0 && arr.size() < k){
                arr.add(i);
                nums[i] = 1;
            }
            if(i == nums.length - 1){
                max = Math.max(max, dfs(nums));
            }
        }
        return max;
    }
    
    public int dfs(int[] nums){
        int max = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                counter++;
            }
            if(nums[i] == 0 || i == nums.length - 1){
                max = Math.max(max, counter);
                counter = 0;
            }
        }
        return max;
    }
}
