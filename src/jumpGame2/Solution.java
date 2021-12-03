package jumpGame2;

public class Solution {
	public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        return minimumJumps(nums, 0, nums.length - 1);
    }
    
    public int minimumJumps(int arr[], int index, int length){
        if(index == length){
            return 0;
        }
        if(arr[index] == 0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for(int i = index + 1; i <= length && i <= index + arr[index]; i++){
            int jumps = minimumJumps(arr, i, length);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min){
                min = jumps + 1;
            }
        }
        return min;
    }
}
