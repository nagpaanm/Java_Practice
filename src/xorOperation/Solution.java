package xorOperation;


// O(n^2)
public class Solution {
/*
 * Give the observation: For all pairs of i and k, 
 * where arr[i] ^ arr[i + 1] ^ ... ^ arr[k] = 0, then any 
 * j (i < j <= k) will be good to set as the answer 
 * (hint: proof by contradiction, if you cannot understand this trick 
 * immediately). So you just need to find all segments where XOR equals 
 * zero.
 */
	public int countTriplets(int[] arr) {
		int total = 0;
		for(int i = 0; i < arr.length; i++) {
			int xor = arr[i];
			for(int j = i + 1; j < arr.length; j++) {
				xor = xor ^ arr[j];
				if(xor == 0) {
					// if xor == 0, it means arr[i] and arr[j] are the same numbers
					total += (j - i);
				}
			}
		}
		
		return total;
	}
}
