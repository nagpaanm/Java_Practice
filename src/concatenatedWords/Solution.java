package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<ArrayList<String>> main = new ArrayList<ArrayList<String>>();
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> arr = new ArrayList<String>();
        
        int left = 0;
        int right = words.length - 1;
        String s = words[right];
        List<String> temp = new ArrayList<String>();
        while(right > 0){
            if(left == words.length  - 1){ //right
            	permute(temp, new ArrayList<String>());
            	for(ArrayList<String> ary: this.main) {
                    s = words[right];
            		for(String str: ary) {
            			s = s.replace(str, "");
            		}
            		if(s.length() == 0) {
            			arr.add(words[right]);
            			break;
            		}
            	}
                left = 0;
                right--;
                s = words[right];
                main = new ArrayList<ArrayList<String>>();
                temp = new ArrayList<String>();
            }
            if(words[right].contains(words[left]) && words[right].length() > words[left].length()){
                temp.add(words[left]);
            }
            left++;
        }
        
        return arr;
    }
    
	public void permute(List<String> arr, List<String> temp) {
		if(temp.size() == arr.size()) {
			ArrayList<String> al = new ArrayList<String>(temp);
            main.add(al);
			return;
		}
		for(int i = 0; i < arr.size(); i++) {
			if(!temp.contains(arr.get(i))) {
				temp.add(arr.get(i));
				permute(arr, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
