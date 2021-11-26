package lexicographicalString;

import java.util.ArrayList;
import java.util.List;

/*
 * A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and 
strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n 
sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less 
than k happy strings of length n.



Ex)
Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 
["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. 

You will find the 9th string = "cab"
 */

public class Solution {
	public String getHappyString(int n, int k) {
        String[] set = {"a", "b", "c"};
        String str = "";
        List<String> arr = new ArrayList<String>();
        permute(set, n, str, arr);
        if(arr.size() >= k)
            str = arr.get(k - 1);
        return str;
    }
	
	private void permute(String[] set, int n, String str, List<String> arr) {
		if(n == 0) {
			arr.add(str);
			System.out.println("full str: " + str);
			return;
		}
		
		for(int i = 0; i < set.length; i++) {
			// make sure str is not empty and str[i] != s[i + 1]
			if(str.equals("") || !String.valueOf(str.charAt(str.length() -1)).equals(set[i])) {
				String pre = str + set[i];
				System.out.println(pre);
				permute(set, n - 1, pre, arr);
			}
		}
	}
}
