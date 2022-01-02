package bestTimeToBuyAndSellStock;

public class Solution {
	public int maxProfit(int[] prices) {
        // kadane's algorithm
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i = 1; i < prices.length; i++){
            maxCur += prices[i] - prices[i - 1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}
