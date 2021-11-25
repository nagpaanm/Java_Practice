package Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * A happy string is a string that:

- consists only of letters of the set ['a', 'b', 'c'].
- s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).

For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and 
strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n 
sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less 
than k happy strings of length n.
 */
public class Solution {

	ArrayList<String> set = new ArrayList<String>();
	public String getHappyString(int n, int k) {
        String[] arr = {"a", "b", "c"};
        permute(arr, n, 0, "", 0, n*n);
        System.out.println(set);
        return "";
    }
	
	public void permute(String[] arr, int n, int index, String str, int count, int amount) {
		if(str.length() >= n) {
			set.add(str);
			str = "";
			index = set.size() % arr.length;
			count += 1;
		}
		if(count < amount) {
			if(index >= arr.length) {
				index = 0;
			}
			str += arr[index];
			permute(arr, n, index + 1, str, count, amount);
		}
	}
}
