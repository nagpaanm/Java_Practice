package kClosestPointsToOrigin;

import java.util.Arrays;

/*
 * Given an array of points where points[i] = [xi, yi] represents a point on 
 * the X-Y plane and an integer k, return the k closest points to the origin 
 * (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance 
(i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique 
(except for the order that it is in).
 */

// solution -> O(nlogn)
public class Solution {
	public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        int[][] calcs = new int[points.length][2];
        // O(n)
        for(int i = 0; i < points.length; i++){
            int distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            calcs[i] = new int[]{distance, i};
  
        }
        // O(nlogn)
        Arrays.sort(calcs, (a, b) -> Integer.compare(a[0], b[0]));
        int counter = 0;
        
        // O(m)
        while(counter < k){
            result[counter] = points[calcs[counter][1]];
            counter++;
        }
        return result;
    }
}
