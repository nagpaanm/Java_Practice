package sumOfPowersOfThree;

/*
 * Given an integer n, return true if it is possible to represent n as the sum 
 * of distinct powers of three. Otherwise, return false.

An integer y is a power of three if there exists an integer x such that y == 3x.
 * 
 */

public class Solution {
	public boolean checkPowersOfThree(int n) {
        int max = 0;
        for(int i = 1; i < 16; i++){
            if(Math.pow(3,i) <= n && i > max){
                max = i;
            }
        }
        int m = n;
        m -= Math.pow(3,max);
        while(true){
            if(m == 0){
                return true;
            }
            max--;
            while(Math.pow(3, max) > m){
                max--;
            }
            m -= Math.pow(3, max);
            if(max < 0){
                return false;
            }
        }
    }
}
