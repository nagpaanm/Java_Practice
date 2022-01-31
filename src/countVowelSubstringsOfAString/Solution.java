package countVowelSubstringsOfAString;

import java.util.*;

/*
 * A substring is a contiguous (non-empty) sequence of characters within a string.

A vowel substring is a substring that only consists of vowels 
('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.

Given a string word, return the number of vowel substrings in word.
 */

public class Solution {
	public int countVowelSubstrings(String word) {
        if(word.length() < 5){
            return 0;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        Map<String, Integer> map = createNewMap();
        while(j < word.length()){
            if(map.containsKey(String.valueOf(word.charAt(j)))){
                map.put(String.valueOf(word.charAt(j)), map.get(String.valueOf(word.charAt(j))) + 1);
                if(checkValues(map)){
                    count++;
                }
            }
            if(!map.containsKey(String.valueOf(word.charAt(j))) || j == word.length() - 1){
                i++;
                j = i - 1;
                map = createNewMap();
            }
            j++;
        }
        return count;
    }
    
    
    public boolean checkValues(Map<String, Integer> map){
        for(String s : map.keySet()){
            if(map.get(s) == 0){
                return false;
            }
        }
        return true;
    }
    
    public Map<String, Integer> createNewMap(){
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 0);
        map.put("e", 0);
        map.put("i", 0);
        map.put("o", 0);
        map.put("u", 0);
        return map;
    }
}
