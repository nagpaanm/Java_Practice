package houseRober3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	   public int rob(TreeNode root) {
	        List<Integer> arr = new ArrayList<Integer>();
	        dfs(root, arr);
	        for(int i = 0; i < arr.size(); i++){
	            System.out.print(arr.get(i) + ",");
	        }
	        return 0;
	    }
	    
	    public void dfs(TreeNode root, List<Integer> arr){
	        if(root == null){
	            arr.add(-1);
	            return;
	        }
	        arr.add(root.val);
	        dfs(root.left, arr);
	        dfs(root.right, arr);
	    }
}
