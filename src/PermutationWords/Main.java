package PermutationWords;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		List<ArrayList<String>> main = new ArrayList<ArrayList<String>>();
		arr.add("dog");
		arr.add("rat");
		arr.add("cat");
		arr.add("cats");
		Solution sol = new Solution();
		sol.permute(arr, new ArrayList<String>(), main);
		System.out.println(main);
		for(List<String> a : main) {
			System.out.println(a.size());
		}
	}

}
