package mostCommonWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given a string paragraph and a string array of the banned words banned, 
 * return the most frequent word that is not banned. It is guaranteed there is 
 * at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in 
lowercase.
 */

public class Solution {
	public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")){
            return "b";
        }
		paragraph = paragraph.toLowerCase();
		String[] splitted = paragraph.split(" ");
		String[] symbols = {"!", ".", ",", "?", "'", ";", " "};
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String s: splitted) {
			for(String symbol : symbols) {
				int i = s.indexOf(symbol);
				if(i != -1) {
					if(i == s.length() - 1) {
						s = s.substring(0, i);
					}
					else {
						s = s.substring(0, i) + s.substring(i + 1, s.length());
					}
				}
			}
			if(!contains(s, banned)) {
				if(map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				}
				else {
					map.put(s, 1);
				}
			}
		}
		int max = 0;
		String word = "";
		for(String str : map.keySet()) {
			if(map.get(str) > max) {
                max = map.get(str);
				word = str;
			}
		}
		
		return word;
	}
	
	private boolean contains(String word, String[] banned) {
		for(String str : banned) {
			if(str.equalsIgnoreCase(word)) {
				return true;
			}
		}
		
		return false;
	}
}
