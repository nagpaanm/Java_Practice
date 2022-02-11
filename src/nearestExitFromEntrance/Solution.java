package nearestExitFromEntrance;
import java.util.*;

/*
 * You are given an m x n matrix maze (0-indexed) with empty cells 
 * (represented as '.') and walls (represented as '+'). You are also given 
 * the entrance of the maze, where entrance = [entrancerow, entrancecol] 
 * denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step 
into a cell with a wall, and you cannot step outside the maze. Your goal is to 
find the nearest exit from the entrance. An exit is defined as an empty cell 
that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the 
nearest exit, or -1 if no such path exists.
 */

// used DFS solution (not ideal). For shortest length questions, better to use
// BFS.
public class Solution {
	int totalSteps = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 1);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 2);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 3);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 4);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 5);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 6);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 7);
        visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, 8);
        if(totalSteps == Integer.MAX_VALUE){
            return -1;
        }
        return totalSteps;
    }
    
    public void dfs(char[][] maze, int i, int j, int steps, boolean[][] visited, int[] entrance, int order){
        if(isValid(i, j, maze) && (i == 0 || i == maze.length - 1 || j == 0 || j == maze[0].length - 1) && (i != entrance[0] || j != entrance[1])){
            totalSteps = Math.min(totalSteps, steps);
        }
        if(isValid(i, j, maze) && visited[i][j] == false){
            visited[i][j] = true;
            //System.out.println(i + " " + j);
            if(order == 1){
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 1);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 1);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 1);
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 1);
            }else if(order == 2){
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 2);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 2);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 2);
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 2);
            }else if(order == 3){
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 3);
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 3);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 3);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 3);
            }else if(order == 4){
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 4);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 4);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 4);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 4);
            }else if(order == 5){
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 5);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 5);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 5);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 5);
            }else if(order == 6){
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 6);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 6);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 6);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 6);
            }else if(order == 7){
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 7);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 7);
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 7);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 7);
            }
            else if(order == 8){
                dfs(maze, i, j + 1, steps + 1, visited, entrance, 8);
                dfs(maze, i - 1, j, steps + 1, visited, entrance, 8);
                dfs(maze, i, j - 1, steps + 1, visited, entrance, 8);
                dfs(maze, i + 1, j, steps + 1, visited, entrance, 8);
            }
        }
    }
    
    private boolean isValid(int i, int j, char[][] maze){
        if(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == '.'){
            return true;
        }
        return false;
    }
}
