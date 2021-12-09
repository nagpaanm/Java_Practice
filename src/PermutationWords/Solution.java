package PermutationWords;

import java.util.List;

public class Solution {

	public void permute(List<String> arr, List<List<String>> temp) {
		if(temp.size() == arr.size()) {
			for(int i = 0; i < temp.size(); i++){
				System.out.print(temp.get(i));
			}
			System.out.print("\n");
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
