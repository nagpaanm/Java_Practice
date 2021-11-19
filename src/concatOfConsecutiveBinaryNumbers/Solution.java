package concatOfConsecutiveBinaryNumbers;

/*
 * Given an integer n, return the decimal value of the binary string formed by 
 * concatenating the binary representations of 1 to n in order, modulo 109 + 7.
 */

public class Solution {

	public int concatenatedBinary(int n) {
        int m = 1000000007;
        long val = 0;
        for (int i = 1; i <= n; i++) {
            val = (val * (int)Math.pow(2, Integer.toBinaryString(i).length()) + i) % m;
        }
        return (int)val;
    }
}
