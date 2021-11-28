package houseRober3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	/*
	public int rob(TreeNode root) {
        if(root == null){
           return 0;
        }
        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }
        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }
    */
	// dynammic programming approach. O(n) runtime.
	
	
	 public int rob(TreeNode root) {
	        return robSub(root, new HashMap<TreeNode, Integer>());
	    }
	    
    public int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if(root == null){
           return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int val = 0;
        if(root.left != null){
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }
        if(root.right != null){
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }
        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);
        return val;
    }
}
