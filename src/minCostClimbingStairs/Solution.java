package minCostClimbingStairs;

/*
 * You are given an integer array cost where cost[i] is the cost of ith step on 
 * a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */

// dynamic programming
public class Solution {
	public int minCostClimbingStairs(int[] cost) {
        //int[] memoize = new int[cost.length + 1];
        //return Math.min(minCost(cost, 0, memoize), minCost(cost, 1, memoize));
        return bp(cost);
    }
    
    //recursion memoize solution
    public int minCost(int[] cost, int index, int[] memoize){
        if(index >= cost.length){
            return 0;
        }
        if(memoize[index] != 0){
            return memoize[index];
        }
        int total = cost[index] + Math.min(minCost(cost, index + 1, memoize), minCost(cost, index + 2, memoize));
        memoize[index] = total;
        return total;
    }
    
    //bottom-up approach
    public int bp(int[] cost) {
	    int n = cost.length;
	    int[] dp = new int[n];
	    for (int i = 0; i < n; i++) {
		    if (i < 2 ){
                dp[i] = cost[i];
            }
		    else{
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
	    }
	    return Math.min(dp[n-1], dp[n-2]);
    }
}
