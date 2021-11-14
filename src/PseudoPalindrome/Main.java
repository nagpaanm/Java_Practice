package PseudoPalindrome;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	
	/*
	 * 1) Get path
	 * 2) path can be palindrone if and only if at most one odd frequency of a 
	 * character occurs 1 time and all other character frequencies are even.
	 * 
	 */
	int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        // step 1; get all possible paths to leaf-nodes and store in ArrayList<Arraylist<Integer>>
    	getPaths(root, new int[10]);
        return count;
    }
    
    public void getPaths(TreeNode root, int[] map){
        map[root.val] = map[root.val] + 1;
        if(root.left == null && root.right == null){
        	int b = 0;
        	for(int i = 0 ; i < map.length; i++) {
        		if(map[i] % 2 != 0) {
        			b++;
        		}
                if(b > 1){
                    break;
                }
        	}
        	if(b <= 1) {
        		count++;
        	}
        }
        if(root.left != null){
            getPaths(root.left, map);
        }
        if(root.right != null){
            getPaths(root.right, map);
        }
        //backtrace - since map is being referenced by pointer.
        map[root.val] = map[root.val] - 1;
    }
    
    /*
    public void getPaths(TreeNode root, String path){
        path += Integer.toString(root.val);
        if(root.left == null && root.right == null){
        	if(isSame(path)) {
        		count++;
        	}else {
        		HashMap<String, Integer> map = new HashMap<String, Integer>();
        		int b = 0;
                for(int i = 0; i < path.length(); i++){
                    if(map.get(String.valueOf(path.charAt(i))) == null){
                        map.put(String.valueOf(path.charAt(i)), 1);
                    } else{
                        map.put(String.valueOf(path.charAt(i)), map.get(String.valueOf(path.charAt(i))) + 1);
                    }
                }
                for(int value: map.values()){
                    if(value % 2 != 0){
                    	b++;
                    } 
                }
                if(b <= 1){
                    count++;
                }
        	}
            return;
        }
        if(root.left != null){
            getPaths(root.left, path);
        }
        if(root.right != null){
            getPaths(root.right, path);
        }
    }
    */
    /*
    // O(n)
    public boolean isSame(String path) {
    	for(int i = 0; i < path.length(); i++) {
    		if(path.charAt(i) != path.charAt(0)) {
    			return false;
    		}
    	}
    	return true;
    }
	*/
}
