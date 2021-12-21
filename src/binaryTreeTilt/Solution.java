package binaryTreeTilt;

/*
 * Given the root of a binary tree, return the sum of every tree node's tilt.

The tilt of a tree node is the absolute difference between the sum of all left 
subtree node values and all right subtree node values. If a node does not have a 
left child, then the sum of the left subtree node values is treated as 0. The rule 
is similar if the node does not have a right child.
 */

public class Solution {
	int result = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        result += Math.abs(left - right);
        
        return left + right + root.val;
    }
}
