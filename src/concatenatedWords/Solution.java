package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	boolean found = false;
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> arr = new ArrayList<String>();
        
        int left = 0;
        int right = words.length - 1;
        List<String> temp = new ArrayList<String>();
        while(right > 0){
            if(left == words.length - 1){ //right
            	permute(temp, new ArrayList<String>(), words[right]);
                if(this.found == true){
                    arr.add(words[right]);
                    this.found = false;
                }
                left = 0;
                right--;
                temp = new ArrayList<String>();
            }
            if(words[right].contains(words[left]) && words[right].length() > words[left].length()){
                temp.add(words[left]);
            }
            left++;
        }
        
        return arr;
    }
    
	public void permute(List<String> arr, List<String> temp, String s) {
		if(temp.size() == arr.size()) {
            for(int i = 0; i < temp.size(); i++){
                s = s.replace(temp.get(i), "");
                if(i >= 1 && s.length() == 0){
                    this.found = true;
                }
            }
			return;
		}
		for(int i = 0; i < arr.size(); i++) {
			if(!temp.contains(arr.get(i))) {
				temp.add(arr.get(i));
				permute(arr, temp, s);
                if(this.found == true){
                    return;
                }
				temp.remove(temp.size() - 1);
			}
		}
	}
}
