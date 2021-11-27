package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

	public List<String> permutations(String[] set) {
		int length = set.length;
		String str = "";
		List<String> arr = new ArrayList<String>();
		permute(set, length, str, arr);
		return arr;
    }
	
	private void permute(String[] set, int length, String str, List<String> arr) {
		if(length == 0) {
			arr.add(str);
			return;
		}
		// else
		for(int i = 0; i < set.length; i++) {
			String pre = str + set[i];
			permute(set, length - 1, pre, arr);
		}
	}
	
}
