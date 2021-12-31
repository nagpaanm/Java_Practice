package smallestStringStartingFromLeaf;

import java.util.HashMap;
import java.util.Map;

/*
 * You are given the root of a binary tree where each node has a value in the 
 * range [0, 25] representing the letters 'a' to 'z'.

Return the lexicographically smallest string that starts at a leaf of this 
tree and ends at the root.

As a reminder, any shorter prefix of a string is lexicographically smaller.

For example, "ab" is lexicographically smaller than "aba".
A leaf of a node is a node that has no children.

 */


// solution - O(n)
public class Solution {
	Map<String, String> map = new HashMap<String, String>();
    String smallest = "zzzzz";
    public String smallestFromLeaf(TreeNode root) {
        map.put("0", "a");
        map.put("1", "b");
        map.put("2", "c");
        map.put("3", "d");
        map.put("4", "e");
        map.put("5", "f");
        map.put("6", "g");
        map.put("7", "h");
        map.put("8", "i");
        map.put("9", "j");
        map.put("10", "k");
        map.put("11", "l");
        map.put("12", "m");
        map.put("13", "n");
        map.put("14", "o");
        map.put("15", "p");
        map.put("16", "q");
        map.put("17", "r");
        map.put("18", "s");
        map.put("19", "t");
        map.put("20", "u");
        map.put("21", "v");
        map.put("22", "w");
        map.put("23", "x");
        map.put("24", "y");
        map.put("25", "z");
        if(root.left == null & root.right == null){
            return map.get(Integer.toString(root.val));
        }
        dfs(root, "");
        return smallest;
    }
    
    // O(n)
    public void dfs(TreeNode root, String s){
        if(root.left == null && root.right == null){
            s = reverseString(s + map.get(Integer.toString(root.val)));
            if(s.compareTo(smallest) < 0){
                smallest = s;
            }
            return;
        }
        if(root.left != null){
            dfs(root.left, s + map.get(Integer.toString(root.val)));
        }
        if(root.right != null){
            dfs(root.right, s + map.get(Integer.toString(root.val)));
        }
        return;
    }
    
    // O(n)
    public String reverseString(String s){
        String reversed = "";
        for(int i = s.length() - 1; i >= 0; i--){
            reversed += String.valueOf(s.charAt(i));
        }
        return reversed;
    }
}
