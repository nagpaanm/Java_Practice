package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public ArrayList<List<Integer>> visited = new ArrayList<List<Integer>>();
    
    public int largest1BorderedSquare(int[][] grid) {
        /*
        [1,1,1,1]
        [0,1,1,1]
        [1,1,1,0]
        
        */
        //return 0;
        
    	//O(n^2) runtime
    	ArrayList<int[]> coordsList = new ArrayList<int[]>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int max_ = dfsRight(grid, i, j + 1, 1);
                    if(max_ > 1) {
                        int[] coords = {max_, j + max_ - 1, i};
                        // i.e. {4, 3, 0}
                        coordsList.add(coords);
                    }
                }
            }
        }
        int max_ = 1;
        int yLength = grid.length;
        for(int[] arr: coordsList) {
        	int m = arr[0];
        	int j = arr[1];
        	int i = arr[2];
        	if(i + m - 1 < yLength) {
        		if(grid[i + m - 1][j] == m) {
        			max_ = m;
        		}
    		}else {
    			int c = 1;
    			m--;
    			while(m > 1) {
    				if(i + m - 1 < yLength) {
    					if(grid[i + m - 1][j - c] == m) {
    						
    						max_ = m;
    						break;
    					}
    				}
    				c++;
    				m--;
    			}
        	}
        }
        return max_;
    }
    
    public int dfsRight(int[][] grid, int i, int j, int cum) {
    	int x = 1;
    	if(j < grid[i].length && grid[i][j] == 1) {
    		grid[i][j] += cum;
    		x += dfsRight(grid, i, j + 1, cum + 1);
    	}
    	return x;
    }

    public void dfs(int[][] grid, int i, int j){
        if((i >= grid.length || j >= grid[i].length) ||
            (i < 0 || j < 0)){
            return;
        }
        if(!exists(i,j)){
        	if(grid[i][j] == 1) {
            	System.out.println(i + " " + j);
        	}
            this.visited.add(Arrays.asList(i,j));
            if(i < grid.length - 1){
                dfs(grid, i + 1, j);
            }
            if(i > 0){
                dfs(grid, i - 1, j);
            }
            if(j < grid[i].length - 1){
                dfs(grid, i, j - 1);
            }
            if(j > 0){
                dfs(grid, i, j + 1);
            }
        }
    }
    
    public boolean exists(int i, int j){
        for(List<Integer> al: this.visited){
            if(al.get(0) == i && al.get(1) == j){
                return true;
            }
        }
        return false;
    }
}