package boomerangs;

import java.util.HashMap;

/*
You are given n points in the plane that are all distinct, where points[i] = [xi, yi].
A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals 
the distance between i and k (the order of the tuple matters).

Return the number of boomerangs.

Input: points = [[0,0],[1,0],[2,0]]
Output: 2
Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
*/


// O(n^2) solution
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        int boomerangs = 0;
        if(length < 3){
            return 0;
        }
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        while(index < length){
            for(int i = 0; i < length; i++){
                if(i != index){
                    int[] pointA = points[index];
                    int[] pointB = points[i];
                    int distance = calculateDistance(pointA, pointB);
                    if(map.containsKey(distance) == false){
                        map.put(distance, 1);
                    }else{
                        map.put(distance, map.get(distance) + 1);
                    }
                }
            }
            /*
            For every i, we capture the number of points equidistant from i. Now for this i,
            we have to calculate all possible permutations of (j,k) from these equidistant points.
            Total number of permutations of size 2 from n different points is nP2 = n!/(n-2)! = n * (n-1).
            */
            for(int val: map.values()){
                boomerangs += val * (val-1);
            }
            map.clear();
            index++;
        }
 
        return boomerangs;
    }
    
    
    public int calculateDistance(int[] pointA, int[] pointB){
        int x1 = pointA[0];
        int x2 = pointB[0];
        int y1 = pointA[1];
        int y2 = pointB[1];
        return ((x2 - x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }
}