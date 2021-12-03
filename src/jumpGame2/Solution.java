package jumpGame2;

public class Solution {
	public int jump(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        return jumpCount(nums, 0, nums[0]);
    }
    
    public int jumpCount(int[] nums, int index, int num){
        //System.out.println(index + num + " " + index);
        if(index + num >= nums.length - 1){
            return 1;
        }
        if(num >= 1){
            return Math.min(1 + jumpCount(nums, index + nums[index], nums[index]), 1 + jumpCount(nums, index + nums[index] - 1, nums[index] - 1));
        }
        return 1000;
    }
}
