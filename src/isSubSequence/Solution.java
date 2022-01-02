package isSubSequence;

/*
Given two strings s and t, return true if s is a subsequence of t, o
r false otherwise.

A subsequence of a string is a new string that is formed from the original 
string by deleting some (can be none) of the characters without disturbing the 
relative positions of the remaining characters. (i.e., "ace" is a subsequence of
"abcde" while "aec" is not).
 */

// solution - O(n)
public class Solution {
	public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int index = 0;
        // O(n)
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(index)){
                index++;
            }
            if(index >= s.length()){
                break;
            }
        }
        return index == s.length();
    }
}
