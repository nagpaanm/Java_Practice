package findAllGroupsOfFarmLand;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given a 0-indexed m x n binary matrix land where a 0 represents a 
 * hectare of forested land and a 1 represents a hectare of farmland.

To keep the land organized, there are designated rectangular areas of hectares 
that consist entirely of farmland. These rectangular areas are called groups. 
No two groups are adjacent, meaning farmland in one group is not 
four-directionally adjacent to another farmland in a different group.

land can be represented by a coordinate system where the top left corner of 
land is (0, 0) and the bottom right corner of land is (m-1, n-1). Find the
 coordinates of the top left and bottom right corner of each group of farmland. 
 A group of farmland with a top left corner at (r1, c1) and a bottom right 
 corner at (r2, c2) is represented by the 4-length array [r1, c1, r2, c2].

Return a 2D array containing the 4-length arrays described above for each group 
of farmland in land. If there are no groups of farmland, return an empty array. 
You may return the answer in any order.
 */

public class Solution {
	List<List<Integer>> arr = new ArrayList<>();
    boolean[][] vis;
    public int[][] findFarmland(int[][] land) {
        vis = new boolean[land.length][land[land.length - 1].length];
        for(int i = 0 ; i < land.length; i ++){
            for(int j = 0; j < land[i].length; j++){
                if(!vis[i][j] && land[i][j] == 1){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    dfsDown(i,j, land, temp);
                    dfsLeft(i,j, land, temp);
                    arr.add(temp);
                    int m = i;
                    int n = j;
                    while(m <= temp.get(2)){
                        while(n <= temp.get(3)){
                            vis[m][n] = true;
                            n++;
                        }
                        m++;
                        n = j;
                    }
                }
            }
        }
        
        int[][] result = new int[arr.size()][4];
        for(int i = 0 ; i < result.length; i ++){
            for(int j = 0; j < result[i].length; j++){
                result[i][j] = arr.get(i).get(j);
            }
        }
        return result;
    }
    
    public void dfsLeft(int i , int j, int[][] land, List<Integer> temp){
        if(land[i][j] == 1){
            if(j < land[i].length - 1){
                if(land[i][j + 1] == 1){
                    dfsLeft(i, j + 1, land, temp);
                }
                else{
                    temp.add(j);
                }
            }
            else{
                temp.add(j);
            }
        }
        return;
    }
    
     public void dfsDown(int i , int j, int[][] land, List<Integer> temp){
        if(land[i][j] == 1){
            if(i < land.length - 1){
                if(land[i + 1][j] == 1){
                    dfsDown(i + 1, j, land, temp);
                }
                else{
                    temp.add(i);
                }
            }
            else{
                temp.add(i);
            }
        }
        return;
     }
}
