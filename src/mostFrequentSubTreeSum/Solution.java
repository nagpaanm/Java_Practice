package mostFrequentSubTreeSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Given the root of a binary tree, return the most frequent subtree sum. 
 * If there is a tie, return all the values with the highest frequency in any
 *  order.

The subtree sum of a node is defined as the sum of all the node values formed 
by the subtree rooted at that node (including the node itself).
 */

public class Solution {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> arr = new ArrayList<>();
        for (int s : map.keySet()) {
            if (map.get(s) == maxCount)
                arr.add(s);
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
    
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        //post order traversal
        int val = dfs(root.left) + dfs(root.right) + root.val;
        map.put(val, map.getOrDefault(val, 0) + 1);
        maxCount = Math.max(maxCount, map.get(val));
        return val;
    }
}
