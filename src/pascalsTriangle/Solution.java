package pascalsTriangle;

import java.util.*;

/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above 
it as shown:
 */

public class Solution {
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>();
        formulate(numRows, 1, arr);
        return arr;
    }
    
    // dp - recursion - top-down approach
    public void formulate(int numRows, int target, List<List<Integer>> arr){
        if(target <= numRows){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if(target >= 3){
                for(int i = 1; i < target; i++){
                    if(arr.get(target - 2).size() <= i){
                        temp.add(1);
                    }
                    else{
                        temp.add(arr.get(target - 2).get(i) + arr.get(target - 2).get(i - 1));
                    }
                } 
            } else {
                for(int i = 1; i < target; i++){
                    temp.add(1);
                }
            }
            arr.add(temp);
            formulate(numRows, target + 1, arr);
        }
        return;
    }
}
