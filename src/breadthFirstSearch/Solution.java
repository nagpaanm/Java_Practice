package breadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public void bfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            System.out.println(root.val);
            return;
        }
        // else
        System.out.print(root.val + ",");
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root.left != null){
            q.add(root.left);
        }
        if(root.right != null){
            q.add(root.right);
        }
        while(!q.isEmpty()){
            TreeNode popped = q.remove();
            System.out.print(popped.val + ",");
            if(popped.left != null){
                q.add(popped.left);
            }
            if(popped.right != null){
                q.add(popped.right);
            }
        }
    }
}
