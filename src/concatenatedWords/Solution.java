package concatenatedWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	 boolean found = false;
		public List<String> findAllConcatenatedWordsInADict(String[] words) {
	        List<String> arranged = new ArrayList<String>();
	        for(String word: words){
	            if(arranged.size() == 0){
	                arranged.add(word);
	            }
	            else{
	                if(word.length() <= arranged.get(0).length()){
	                    arranged.add(0, word);
	                }
	                else{
	                    int left = 0;
	                    int right = arranged.size() - 1;
	                    while(left <= right){
	                        int mid = (left + right) / 2;
	                        if(arranged.get(mid).length() <= word.length()){
	                            left++;
	                        }else{
	                            right--;
	                        }
	                    }
	                    arranged.add(left, word);
	                }
	            }
	        }
	        //System.out.println(arranged);
	        List<String> arr = new ArrayList<String>();
	        
	        int left = 0;
	        int right = arranged.size() - 1;
	        List<String> temp = new ArrayList<String>();
	        while(right > 0){
	            if(left == right){ //right
	            	permute(temp, new ArrayList<String>(), arranged.get(right));
	                if(this.found == true){
	                    arr.add(arranged.get(right));
	                    this.found = false;
	                }
	                left = 0;
	                right--;
	                temp = new ArrayList<String>();
	            }
	            if(arranged.get(right).contains(arranged.get(left)) && arranged.get(right).length() > arranged.get(left).length()){
	                temp.add(arranged.get(left));
	            }
	            left++;
	        }
	        
	        return arr;
	    }
	    
		public void permute(List<String> arr, List<String> temp, String s) {
			if(temp.size() == arr.size()) {
	            //System.out.println(temp);
	            for(int i = 0; i < temp.size(); i++){
	                s = s.replace(temp.get(i), "");
	                if(i >= 1 && s.length() == 0){
	                    this.found = true;
	                }
	            }
				return;
			}
			for(int i = 0; i < arr.size(); i++) {
	            if(this.found == true){
	                return;
	            }
				if(!temp.contains(arr.get(i))) {
					temp.add(arr.get(i));
					permute(arr, temp, s);
					temp.remove(temp.size() - 1);
				}
			}
		}
}
