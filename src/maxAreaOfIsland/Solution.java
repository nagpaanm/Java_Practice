package maxAreaOfIsland;

/*
 * You are given an m x n binary matrix grid. An island is a group of 1's 
 * (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
 */

public class Solution {
	public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        //time complexity - O(n^2)
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    max = Math.max(dfs(i, j, grid, visited), max);
                }
            }
        }
        
        return max;
    }
        
    public int dfs(int i, int j, int[][] grid, boolean[][] visited){
        int count = 0;
        if(isValid(i, j, grid) && visited[i][j] == false && grid[i][j] == 1){
            visited[i][j] = true;
            count = 1 + dfs(i - 1, j, grid, visited) + dfs(i + 1, j, grid, visited) + dfs(i, j - 1, grid, visited) + dfs(i, j + 1, grid, visited);
        }
            
        return count;
    }
        
    public boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }
        return false;
    }
}
