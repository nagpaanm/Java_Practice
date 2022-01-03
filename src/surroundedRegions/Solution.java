package surroundedRegions;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions 
 * that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.
 */

public class Solution {
	boolean onEdge = false;
    boolean[][] visited;
    List<int[]> arr = new ArrayList<int[]>();
    
    public void solve(char[][] board) {
        visited = new boolean[board.length][board[0].length];
        // O(n^2)
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    dfs(i, j, board);
                    if(!onEdge){
                        for(int[] pairs: arr){
                            board[pairs[0]][pairs[1]] = 'X';
                        }
                    }
                    else{
                        arr = new ArrayList<int[]>();
                    }
                    onEdge = false;
                }
            }
        }
    }
    
    public void dfs(int i, int j, char[][] board){
        if(isValid(i, j, board) && board[i][j] == 'O' && !visited[i][j]){
            visited[i][j] = true;
            if(onEdge == false){
                onEdge = checkEdge(i, j, board);
            }
            arr.add(new int[]{i,j});
            dfs(i, j + 1, board);
            dfs(i, j - 1, board);
            dfs(i + 1, j, board);
            dfs(i - 1, j, board);
        }
        return;
    }
    
    public boolean isValid(int i, int j, char[][] board){
        if(i >= 0 && i <= board.length - 1 && j >= 0 && j <= board[i].length - 1){
            return true;
        }
        return false;
    }
    
    public boolean checkEdge(int i, int j, char[][] board){
        if(i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1){
            return true;
        }
        return false;
    }
}
