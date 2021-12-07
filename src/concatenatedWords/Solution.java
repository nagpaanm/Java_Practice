package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> arr = new ArrayList<String>();
        
        int left = 0;
        int right = words.length - 1;
        int tmpCount = 0;
        while(right > 0){
            if(tmpCount >= 2){
                arr.add(words[right]);
                tmpCount = 0;
                left = 0;
                right--;
            }
            
            if(left == right){
                left = 0;
                right--;
                tmpCount = 0;
            }
            if(words[right].contains(words[left])){
                tmpCount++;
            }
            left++;
        }
        
        return arr;
    }
}
