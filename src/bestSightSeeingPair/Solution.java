package bestSightSeeingPair;

/*
 * You are given an integer array values where values[i] represents the value 
 * of the ith sightseeing spot. Two sightseeing spots i and j have a distance 
 * j - i between them.

The score of a pair (i < j) of sightseeing spots is 
values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, 
minus the distance between them.

Return the maximum score of a pair of sightseeing spots.
 */

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
