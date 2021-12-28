package InorderAndPreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> arr = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return arr;
    }
    
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        arr.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);
    }
}
