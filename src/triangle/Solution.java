package triangle;

import java.util.List;

/*
 * Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. 
More formally, if you are on index i on the current row, you may move to either 
index i or index i + 1 on the next row.
 */

public class Solution {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
			return 0;
		
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				List<Integer> nextRow = triangle.get(i+1);
				int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
    }
}
