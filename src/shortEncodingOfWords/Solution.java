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
        
		//this is a better solution.
		// 1) turn into set to remove any duplicates
		// 2) iterate over set, for each word in set:
		// 3) for each substring in word from length 1 to word.length()
		// 4) remove the substring from the set
		// 5) iterate over the set and count the total. Add 1 (+1) each time 
		// to account for the '#' that must be added.
        /*
        Set<String> s = new HashSet<>(Arrays.asList(words));
        for (String w : words){
            for (int i = 1; i < w.length(); ++i)
                s.remove(w.substring(i));
        }
        int res = 0;
        for (String w : s){
            res += w.length() + 1;
        }
        return res;
        */
        
        // O(n^2)
        int count = 0;
        for(int i = 0 ; i < words.length; i++) {
        	boolean found = findSmallestStringContained(words, words[i], i);
        	if(found == true) {
        		words[i] = "";
        	}
        	else {
            	count += words[i].length() + 1;
        	}
        }
        return count;
        
    }
	
	public boolean findSmallestStringContained(String[] words, String str, int i) {
		for(int j = 0 ; j < words.length; j++) {
			if(j != i) {
                if(words[i] == words[j]){
                    words[j] = "";
                }
				int index = words[j].lastIndexOf(str);
				if(index != -1) {
					if(str.length() + index == words[j].length()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
