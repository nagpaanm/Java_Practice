package longestUniquePath;

/*
 * Given the root of a binary tree, return the length of the longest path, 
 * where each node in the path has the same value. This path may or may not 
 * pass through the root.

The length of the path between two nodes is represented by the number of edges 
between them.
 */

public class Solution {
	int len = 0; // global variable
    public int longestUnivaluePath(TreeNode root){
        if(root == null){
            return 0;
        }
        getLen(root, root.val);
        return len;
    }

    private int getLen(TreeNode node, int val) {
        if(node == null){
            return 0;
        }
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if(val == node.val){
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}
