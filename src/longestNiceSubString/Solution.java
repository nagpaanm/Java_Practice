package longestNiceSubString;

import java.util.*;

/*
 * A string s is nice if, for every letter of the alphabet that s contains, 
 * it appears both in uppercase and lowercase. For example, "abABB" is nice 
 * because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not 
 * because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are 
multiple, return the substring of the earliest occurrence. If there are none, 
return an empty string.
 */

public class Solution {
	public String longestNiceSubstring(String s) {
        String solution = "";
        for(int i = 0; i < s.length() - 1; i++){
            String temp = String.valueOf(s.charAt(i));
            for(int j = i + 1; j < s.length(); j++){
                temp += String.valueOf(s.charAt(j));
                if(isNice(temp) && temp.length() > solution.length()){
                    solution = temp;
                }
            }
        }
        
        return solution;
    }
    
    public boolean isNice(String s){
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < s.length(); i++){
            map.put(String.valueOf(s.charAt(i)), 1);
        }
        for(String str : map.keySet()){
            if(map.containsKey(String.valueOf(Character.toUpperCase(str.charAt(0)))) && map.containsKey(String.valueOf(Character.toLowerCase(str.charAt(0))))){
                continue;
            }
            return false;
        }
        return true;
    }
}
