package beautyStrings;

/*
 * The beauty of a string is the difference in frequencies between the most 
 * frequent and least frequent characters.
 * For example, the beauty of "abaacc" is 3 - 1 = 2.
 * Given a string s, return the sum of beauty of all of its substrings.
 * 
 * 
 * E.g.
 * 
 * Input: s = "aabcb"
 * Output: 5
 * Explanation: The substrings with non-zero beauty are 
 * ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int beautySum(String s) {
        int total = 0;
        // O(n^2)
        for(int i = 0; i < s.length(); i++){
            Map<Character, Integer> map = new HashMap<Character, Integer>();
            for(int j = i; j < s.length(); j++){
                char c = s.charAt(j);
        	    if(map.containsKey(c)){
        		    map.put(c, map.get(c) + 1);
        	    }else {
                    map.put(c, 1);
        	    }
                total += calcBeauty(map);
            }
        }

        return total;
    }
    
    public int calcBeauty(Map<Character, Integer> map){
        int min = 500; // given in the constraints
        int max = 1;
        for(int i: map.values()) {
        	if(i > max) {
        		max = i;
        	}
        	if(i < min) {
        		min = i;
        	}
        }
        return Math.max(0, max - min);
    }
}
