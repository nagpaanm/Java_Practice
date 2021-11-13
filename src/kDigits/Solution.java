package kDigits;

/*
 * 
 * k-digit solution - literally just scan through the string k times and remove
 * the 'peak' - that is, the digit that is greater than the digit to it's immediate
 * right.
 */
public class Solution {
	public String removeKdigits(String num, int k) {
		if(num.length() == k) {
			return "0";
		}
		// O(n^2)
        while(k > 0) {
        	int n = num.length();
        	int i = 0;
        	// keep looping and incrementing i until we find the peak digit
        	while(i + 1 < n) {
        		if(num.charAt(i) > num.charAt(i + 1)) {
        			break;
        		}
        		i++;
        	}
        	// remove peak digit
        	String left = num.substring(0,i);
        	String right = num.substring(i + 1, n);
        	num = left + right;
        	k--;
        }
        
        int i = 0;
        char z = '0'; // note: as to be single quotes *sighs*
        // O(n) run time.
        // must add the first condition below in case input is all zeros "i.e. 00000"
        while(num.length() > 1 && num.charAt(0) == z) {
        	num = num.substring(1);
        }
        return num;
    }
	
	/*
	private void permutation(char[] perm, int pos, String str) {
	    if (pos == perm.length) {
	        System.out.println(new String(perm));
	    } else {
	        for (int i = 0 ; i < str.length() ; i++) {
	            perm[pos] = str.charAt(i);
	            permutation(perm, pos+1, str);
	        }
	    }
	}
	*/
}
