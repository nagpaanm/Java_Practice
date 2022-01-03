package sumOfNodesWithEvenValuedGrandparents;

/*
 * Given the root of a binary tree, return the sum of values of nodes with an 
 * even-valued grandparent. If there are no nodes with an even-valued grandparent, 
 * return 0.

A grandparent of a node is the parent of its parent if it exists.
 */

public class Solution {
int total = 0;
    
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return total;
    }
    
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.val % 2 == 0){
            if(root.left != null && root.left.left != null){
                this.total += root.left.left.val;
            }
            if(root.left != null && root.left.right != null){
                this.total += root.left.right.val;
            }
            if(root.right != null && root.right.left != null){
                this.total += root.right.left.val;
            }
            if(root.right != null && root.right.right != null){
                this.total += root.right.right.val;
            }
        }
        dfs(root.left);
        dfs(root.right);
        return;
    }
}
