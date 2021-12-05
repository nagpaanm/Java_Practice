package containerWithMostWater;

public class Solution {
	public int maxArea(int[] height) {
        int maxVolume = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j < height.length; j++){
                if(maxVolume >= height[i] * height.length - 1){
                    break;
                }
                int volume = Math.min(height[i], height[j]) * (j - i);
                maxVolume = Math.max(volume, maxVolume);
            }
        }
        
        return maxVolume;
    }
}
