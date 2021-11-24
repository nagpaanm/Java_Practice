package Permutations;

public class Solution {

	public String getHappyString(int n, int k) {
        String[] set = {"a", "b", "c"};
        int combos = 3;
        for(int i = 2; i <= k; i++){
            combos *=2; 
        }
        if(k > combos){
            return "";
        }
        return "";
    }
}
