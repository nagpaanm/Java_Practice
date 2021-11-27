package Permutations;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[] set = {"a", "b", "c"};
		List<String> permutations = sol.permutations(set);
		int i = 1;
		for(String permutation: permutations) {
			System.out.println(i + ": " + permutation);
			i++;
		}
	}

}
