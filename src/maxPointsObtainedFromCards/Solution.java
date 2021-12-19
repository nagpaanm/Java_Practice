package maxPointsObtainedFromCards;

public class Solution {
	public int maxScore(int[] cardPoints, int k) {
        int cardsPicked = 0;
        int total = 0;
        int left = 0;
        int right = cardPoints.length - 1;
        while(left <= right && cardsPicked < k){
            int i = cardPoints[left];
            int j = cardPoints[right];
            if(i > j){
                left++;
                total += i;
            }
            else{
                right--;
                total += j;
            }
            //System.out.println(total);
            cardsPicked++;
        }
        
        return total;
    }
}
