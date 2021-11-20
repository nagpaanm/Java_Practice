package shortEncodingOfWords;


/*
 * A valid encoding of an array of words is any reference string s and array of 
 * indices indices such that:

words.length == indices.length
The reference string s ends with the '#' character.
For each index indices[i], the substring of s starting from indices[i] and up 
to (but not including) the next '#' character is equal to words[i].
Given an array of words, return the length of the shortest reference string s 
possible of any valid encoding of words.



Input: words = ["time", "me", "bell"]
Output: 10
Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5].
words[0] = "time", the substring of s starting from indices[0] = 0 to the next '#' is underlined in "time#bell#"
words[1] = "me", the substring of s starting from indices[1] = 2 to the next '#' is underlined in "time#bell#"
words[2] = "bell", the substring of s starting from indices[2] = 5 to the next '#' is underlined in "time#bell#"
 */

public class Solution {
	public int minimumLengthEncoding(String[] words) {
        if(words.length == 0) {
        	return 1;
        }
        else if(words.length == 1) {
        	return words[0].length() + 1;
        }
        // else
        String s = words[0] + "#";
        for(int i = 1; i < words.length; i++) {
        	int index = (words[i - 1].indexOf(words[i]));
        	//System.out.println(index + words[i].length() + 1 + " " + words[i - 1].length());
        	if(index < 0 || (index + words[i].length() != words[i - 1].length())) {
        		s += words[i] + "#";
        	}
        }
        return s.length();
    }
}
