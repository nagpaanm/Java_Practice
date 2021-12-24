package countingBits;

/*
 * Given an integer n, return an array ans of length n + 1 such that for each i 
 * (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 */

public class Solution {
	public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            String bRep = Integer.toBinaryString(i);
            arr[i] = countOnes(bRep);
        }
        
        return arr;
    }
    
    public int countOnes(String bRep){
        int counter = 0;
        for(int i = 0; i < bRep.length(); i++){
            if(String.valueOf(bRep.charAt(i)).equals("1")){
                counter++;
            }
        }
        
        return counter;
    }
}
