package PermutationWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public void permute(List<String> arr, List<String> temp, List<ArrayList<String>> main) {
		if(temp.size() == arr.size()) {
			ArrayList<String> al = new ArrayList<String>(temp);
			main.add(al);
			//System.out.println(main);
			return;
		}
		for(int i = 0; i < arr.size(); i++) {
			if(!temp.contains(arr.get(i))) {
				temp.add(arr.get(i));
				permute(arr, temp, main);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
