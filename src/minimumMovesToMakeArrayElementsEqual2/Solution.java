package minimumMovesToMakeArrayElementsEqual2;

/*
 * Given an integer array nums of size n, return the minimum number of moves 
 * required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Test cases are designed so that the answer will fit in a 32-bit integer
 */

public class Solution {
	public int minMoves2(int[] nums) {
        long min = Integer.MAX_VALUE;
        int left = 0;
        while(left != nums.length){
            int num = nums[left];
            long count = 0;
            for(int i = 0; i < nums.length; i++){
                count += Math.abs(nums[i] - num);
            }
            min = Math.min(count, min);
            left++;
        }
        return Math.toIntExact(min);
    }
}
