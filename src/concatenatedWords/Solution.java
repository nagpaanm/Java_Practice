package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> arr = new ArrayList<String>();
        
        int left = 0;
        int right = words.length - 1;
        String s = words[right];
        List<String> temp = new ArrayList<String>();
        while(right > 0){
            if(left == right){
                if(recurse(temp, words[right], 0) == true){
                    arr.add(words[right]);
                }
                left = 0;
                right--;
                s = words[right];
            }
            if(words[right].contains(words[left]) && words[right].length() > words[left].length()){
                temp.add(words[left]);
            }
            //s = s.replace(words[left], "");
            //System.out.println(s);
            left++;
        }
        
        return arr;
    }
    
    public boolean recurse(List<String> temp, String word, int index){
        if(word.length() == 0){
            return true;
        }
        boolean exp = false;
        for(int i = index; i < temp.size(); i++){
            String alt = word.replace(temp.get(i), "");
            System.out.println(alt);
            exp = recurse(temp, alt, index + 1);
        }
        
        return exp;
    }
}
