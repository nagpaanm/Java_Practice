package nearestExitFromEntrance;
import java.util.*;

public class Solution {
	int totalSteps = Integer.MAX_VALUE;
    public int nearestExit(char[][] maze, int[] entrance) {
        List<int[]> activeSteps = new ArrayList<int[]>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, entrance[0], entrance[1], 0, visited, entrance, activeSteps);
        if(totalSteps == Integer.MAX_VALUE){
            return -1;
        }
        return totalSteps;
    }
    
    public void dfs(char[][] maze, int i, int j, int steps, boolean[][] visited, int[] entrance, List<int[]> activeSteps){
        if(isValid(i, j, maze) && (i == 0 || i == maze.length - 1 || j == 0 || j == maze[0].length - 1) && (i != entrance[0] || j != entrance[1])){
            totalSteps = Math.min(totalSteps, steps);
            
            /*
            for(int index = 0; i < activeSteps.size(); i++){
                visited[activeSteps.get(index)[0]][activeSteps.get(index)[1]] = false;
            }
            activeSteps.clear();
            return;
            */
            
        }
        if(isValid(i, j, maze) && visited[i][j] == false){
            //System.out.println(i + " " + j);
            visited[i][j] = true;
            //activeSteps.add(new int[]{i,j});
            dfs(maze, i + 1, j, steps + 1, visited, entrance, activeSteps);
            dfs(maze, i - 1, j, steps + 1, visited, entrance, activeSteps);
            dfs(maze, i, j + 1, steps + 1, visited, entrance, activeSteps);
            dfs(maze, i, j - 1, steps + 1, visited, entrance, activeSteps);
            visited[i][j] = false;
        }
    }
    
    private boolean isValid(int i, int j, char[][] maze){
        if(i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == '.'){
            return true;
        }
        return false;
    }
}
