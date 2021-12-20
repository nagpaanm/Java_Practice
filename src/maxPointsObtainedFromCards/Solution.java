package maxPointsObtainedFromCards;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int maxScore(int[] cardPoints, int k) {
        int t = 0;
        for(int p: cardPoints){
            t += p;
        }
        if(k >= cardPoints.length){
            return t;
        }
        if(k == 1){
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        
        List<Integer> arr = new ArrayList<Integer>();
        int total = 0;
        int arrTotal = 0;
        for(int i = 0; i <= cardPoints.length; i++){
            if(arr.size() >= cardPoints.length - k){
                total = Math.max(total, t - arrTotal);
                int r = arr.get(0);
                arr.remove(0);
                arrTotal -= r;
            }
            if(i == cardPoints.length){
                break;
            }
            arr.add(cardPoints[i]);
            arrTotal += cardPoints[i];
        }

        return total;
    }
}
