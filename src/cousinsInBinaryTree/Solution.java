package cousinsInBinaryTree;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a binary tree with unique values and the values of two 
different nodes of the tree x and y, return true if the nodes corresponding to 
the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with 
different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each 
depth k node are at the depth k + 1.
 */


// solution -- using bfs
public class Solution {
	public boolean isCousins(TreeNode root, int x, int y) {
        return bfs(root, x, y);
    }
    
    public boolean bfs(TreeNode root, int x, int y){
        boolean xFound = false;
        boolean yFound = false;
        int xDepth = 0;
        int yDepth = 0;
        int xParent = 0;
        int yParent = 0;
        int depth = 0;
        if(root == null){
            return false;
        }
        TreeNode ptr = root;
        List<TreeNode> arr = new ArrayList<TreeNode>();
        arr.add(root);
        while(arr.size() != 0){
            List<TreeNode> temp = new ArrayList<TreeNode>();
            for(int i = 0 ; i < arr.size(); i++){
                if(arr.get(i) != null){
                    if(arr.get(i).left != null){
                        temp.add(arr.get(i).left);
                        if(arr.get(i).left.val == x){
                            xFound = true;
                            xDepth = depth;
                            xParent = arr.get(i).val;
                        }
                        if(arr.get(i).left.val == y){
                            yFound = true;
                            yDepth = depth;
                            yParent = arr.get(i).val;
                        }
                    }
                    if(arr.get(i).right != null){
                        temp.add(arr.get(i).right);
                        if(arr.get(i).right.val == x){
                            xFound = true;
                            xDepth = depth;
                            xParent = arr.get(i).val;
                        }
                        if(arr.get(i).right.val == y){
                            yFound = true;
                            yDepth = depth;
                            yParent = arr.get(i).val;
                        }
                    }
                }
            }
            
            if(xFound && yFound){
                if(xDepth == yDepth && xParent != yParent){
                    return true;
                }
                else{
                    return false;
                }
            }
            
            arr = new ArrayList<TreeNode>();
            for(int i = 0 ; i < temp.size(); i++){
                arr.add(temp.get(i));
            }
            depth++;
        }
        return false;
    }
}
