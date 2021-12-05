package containerWithMostWater;
/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the two 
 * endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, 
 * together with the x-axis forms a container, such that the container contains 
 * the most water.

Notice that you may not slant the container.
 */

//using 2 pointers
public class Solution {
    public int maxArea(int[] height) {
        int maxVolume = 0;
        int left = 0;
        int right = height.length - 1;
        //O(n) time
        while(left < right){
            maxVolume = Math.max(maxVolume, Math.min(height[left], height[right]) * (right - left));
            if(height[left] <= height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return maxVolume;
    }
}
