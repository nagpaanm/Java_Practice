package maximumWidthRamp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * A ramp in an integer array nums is a pair (i, j) for which i < j and 
 * nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. 
If there is no ramp in nums, return 0.
 */

public class Solution {
	public int maxWidthRamp(int[] nums) {
		Queue<int[]> queue = new LinkedList<int[]>();
		Stack<int[]> stack = new Stack<int[]>();
		int length = nums.length;
		int maxRamp = 0;
		for(int i = 0; i < length - 2; i++) {
			int[] combo = {nums[i], i};
			stack.add(combo);
			queue.add(combo);
		}
		//add last element
		int[] combo = {nums[length - 2], length - 2};
		stack.add(combo);
		int[] combo11 = {nums[length - 1], length - 1};
		stack.add(combo11);
		while(!stack.isEmpty()) {
			combo = stack.pop();
			System.out.println("stack: " + combo[0] + " index: " + combo[1]);
			for(int[] combo2: queue) {
				System.out.println("queue: " + combo2[0] + " index: " + combo2[1]);
				if(combo2[0] <= combo[0] && combo[1] - combo2[1] > maxRamp) {
					maxRamp = combo[1] - combo2[1];
					break;
				}
			}
			
			if(stack.size() < maxRamp) {
				return maxRamp;
			}
		}
		
		return maxRamp;
		/*
        int length = nums.length;
        int maxRamp = 0;
        int j = length - 1;
        while(0 < j){
            for(int i = j - maxRamp - 1; i >= 0; i--){
                if(nums[i] <= nums[j]){
                    if(j - i > maxRamp){
                        maxRamp = j - i;
                    }
                }
            }
            
            j--;
            if(j < maxRamp){
                return maxRamp;
            }
        }
    
        return maxRamp;
        */
    }
}
