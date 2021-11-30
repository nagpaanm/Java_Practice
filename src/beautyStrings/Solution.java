package beautyStrings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int beautySum(String s) {
        int total = 0;
        for(int i = 0; i < s.length(); i++){
            total = formBeauty(s.substring(i, s.length()), "", 0, total);
        }
        return total;
    }
    
    public int formBeauty(String s, String pre, int index, int total){
        if(pre.length() > 2){
            total += calcBeauty(pre);
        }
        if(index == s.length()){
            return total;
        }
        total = formBeauty(s, pre + String.valueOf(s.charAt(index)), index + 1, total);
        return total;
    }
    
    public int calcBeauty(String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i ++){
        	if(map.containsKey(s.charAt(i))){
        		map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        	}else {
                map.put(s.charAt(i), 1);
        	}
        }
        int min = s.length();
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
