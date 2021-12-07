package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> arr = new ArrayList<String>();
        
        int left = 0;
        int right = words.length - 1;
        String s = words[right];
        while(right > 0){
            if(left == right){
                if(s.length() == 0){
                    arr.add(words[right]);
                }
                left = 0;
                right--;
                s = words[right];
            }
            s = s.replace(words[left], "");
            System.out.println(s);
            left++;
        }
        
        return arr;
    }
}
