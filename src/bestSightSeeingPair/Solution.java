package bestSightSeeingPair;

public class Solution {
	/*
    public int maxScoreSightseeingPair(int[] values) {
        int max = 0;
        int left = 0;
        int right = values.length - 1;
        while(left != values.length - 1){
            int i = values[left];
            int j = values[right];
            int val = i + j + (left - right);
            max = Math.max(val, max);
            right--;
            if(right == left){
                right = values.length - 1;
                left++;
            }
        }
        
        return max;
    }
    */
    public int maxScoreSightseeingPair(int[] values) {
        int maxSoFar = values[0];
        int result = 0;
        for(int i=1; i < values.length; i++){
            result = Math.max(result, maxSoFar + values[i] - i);
            maxSoFar = Math.max(maxSoFar, values[i] + i);
        }   
        return result;
    }
}
