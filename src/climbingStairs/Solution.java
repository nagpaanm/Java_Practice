package climbingStairs;

/*
 * You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways 
can you climb to the top?
 */

// dp - memoize solution
public class Solution {
	public int climbStairs(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] arr = new int[n + 1];
        //climb(n, arr);
        bottomUp(n, arr);
        return arr[n];
    }
    
    // memoize
    public int climb(int n, int[] arr){
        if(arr[n] != 0){
            return arr[n];
        }
        if(n == 1){
            arr[n] = 1;
            return 1;
        }
        if(n == 2){
            arr[2] = 2;
            return 2;
        }
        int total = climb(n - 1, arr) + climb(n - 2, arr);
        arr[n] = total;
        return total;
    }
    
    // bottom-up
    public void bottomUp(int n, int[] arr){
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i < arr.length; i++){
            arr[i] = arr[i - 1] + arr[i - 2];
        }
    }
}
