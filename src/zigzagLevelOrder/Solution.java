package zigzagLevelOrder;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, return the zigzag level order traversal of 
 * its nodes' values. (i.e., from left to right, then right to left for the next 
 * level and alternate between).
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */
public class Solution {
	 public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null){
            return list;
        }
        if(root != null){
            ArrayList<Integer> arr = new ArrayList<Integer>();
            arr.add(root.val);
            list.add(arr);
        }
        TreeNode pointer = root;
        List<TreeNode> arr = getChildren(pointer);
        int count = 1;
        while(arr.size() != 0){
            if(count % 2 == 0){
                //left to right
                list.add(leftToRight(arr));
            }else{
                //right to left
                list.add(rightToLeft(arr));
            }
            List<List<TreeNode>> tmpList = new ArrayList<List<TreeNode>>();
            // O(n)
            for(TreeNode node: arr){
                List<TreeNode> tmp = getChildren(node);
                if(tmp.size() > 0){
                    tmpList.add(tmp);
                }
            }
            arr = merge(tmpList);
            count++;
        }
        return list; 
    }
    
	 // O(n*m)
    public List<TreeNode> merge(List<List<TreeNode>> tmpList){
        List<TreeNode> merged = new ArrayList<TreeNode>();
        for(List<TreeNode> outer: tmpList){
            for(TreeNode inner: outer){
                merged.add(inner);
            }
        }
        return merged;
    }
    
    // O(1)
    public List<TreeNode> getChildren(TreeNode root){
        List<TreeNode> lst = new ArrayList<TreeNode>();
        if(root.left != null){
            lst.add(root.left);
        }
        if(root.right != null){
            lst.add(root.right);
        }
        return lst;
    }
    
    
    // O(n)
    public List<Integer> rightToLeft(List<TreeNode> arr){
        List<Integer> lst = new ArrayList<Integer>();
        for(int i = arr.size() - 1; i >= 0; i--){
            lst.add(arr.get(i).val);
        }
        return lst;
    }
    
    // O(n)
    public List<Integer> leftToRight(List<TreeNode> arr){
        List<Integer> lst = new ArrayList<Integer>();
        for(int i = 0; i < arr.size(); i++){
            lst.add(arr.get(i).val);
        }
        return lst;
    }
}
