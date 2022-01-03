package countSumSquareTriples;

import java.util.ArrayList;
import java.util.List;

/*
A square triple (a,b,c) is a triple where a, b, and c are integers and 
a2 + b2 = c2.

Given an integer n, return the number of square triples such that 1 <= a, b, 
c <= n.
 */

public class Solution {
	public int countTriples(int n) {
        int count = 0;
        List<int[]> arr = new ArrayList<int[]>();
        // O(n ^ 2)
        for(int i = 1 ; i < n; i++){
            for(int j = i + 1; j < n; j++){
                arr.add(new int[]{i,j});
            }
        }
        // O(n)
        for(int[] pair: arr){
            if(Math.sqrt(pair[0]*pair[0] + pair[1]*pair[1]) == (int)Math.sqrt(pair[0]*pair[0] + pair[1]*pair[1]) && 
               Math.sqrt(pair[0]*pair[0] + pair[1]*pair[1]) <= n){
                count +=2;
            }
        }
        return count;
    }
}
