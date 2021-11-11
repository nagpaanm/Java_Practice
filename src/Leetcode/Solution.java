package Leetcode;

/*
 * Solution for largest-1-bordered-square (Leetcode).
 * 
 * Algorithm:
 * Iterate through the matrix and when a 1 is found perform a depth-first-search 
 * to the right until a 1 no longer is found. Then, perform a dfs down until a
 * 1 is no longer found. Then, perform a dfs to the left until a 1 is no longer
 * found. Then, perform a dfs upwards until a 1 no longer is found. Keep track
 * of the times dfs occures in all directions, and if these 4 values are equal
 * then it is a square. If this value is larger then the current largest,
 * make it the largest. 
 * 
 * If It is not a square, repeat the last step (dfs-up) but subtract 1. Check if 
 * square and if largest. If not, subtract 1 again and rinse and repeat until
 * 'up' >= 1;
 * 
 * Repeat the above step for left, down and right. All possible combinations
 * will have been found and a guarenteed answer will come.
 * 
 * 
 */
class Solution {
    
    public int largest1BorderedSquare(int[][] grid) {
        
    	// O(n^6) runtime :o
    	
    	int max_ = 0;
    	// O(n^2)
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int right = dfsRight(grid, i, j, 1); 
                    if(right >= 1) {
                    	// O(n^4)
                    	while(right >= 1) {
                    		int down = dfsDown(grid, i, j + right - 1, 1); 
                    		while(down >= 1) {
                    			int left = dfsLeft(grid, i + down - 1, j + right - 1, 1);
                    			while(left >= 1) {
                        			int up = dfsUp(grid, i + down - 1, j + right - (left), 1); 
                        			while(up >= 1) {
                            			//System.out.print(i + " " + j + " ");
                            			boolean isSquare = checkSquare(new int[]{right, down, left, up});
                            			if(up > max_ && isSquare == true) {
                            				max_ = up;
                            			}
                            			up--;
                        			}
                        			left--;
                    			}
                    			down--;
                    		}
                   			right--;
                    	}
                    }
                }
            }
        }
        return max_ * max_;
    }
    
    // O(n)
    public boolean checkSquare(int[] arr) {
    	for(int num: arr) {
        	//System.out.print(num + ",");
        	if(num != arr[0]) {
        		return false;
        	}
    	}
    	//System.out.println();
    	return true;
    };
    
    // O(n)
    public int dfsRight(int[][] grid, int i, int j, int cum) {
    	int x = 0;
    	if(j < grid[i].length && grid[i][j] == 1) {
    		//grid[i][j] += cum;
    		x += 1 + dfsRight(grid, i, j + 1, cum + 1);
    	}
    	return x;
    }
    
    // O(n)
    public int dfsLeft(int[][] grid, int i, int j, int cum) {
    	int x = 0;
    	if(j >= 0 && grid[i][j] == 1) {
    		//grid[i][j] += cum;
    		x += 1 + dfsLeft(grid, i, j - 1, cum + 1);
    	}
    	return x;
    }
    
    // O(n)
    public int dfsDown(int[][] grid, int i, int j, int cum) {
    	int x = 0;
    	if(i < grid.length && grid[i][j] == 1) {
    		//grid[i][j] += cum;
    		x += 1 + dfsDown(grid, i + 1, j, cum + 1);
    	}
    	return x;
    }
    
    // O(n)
    public int dfsUp(int[][] grid, int i, int j, int cum) {
    	int x = 0;
    	if(i >= 0 && grid[i][j] == 1) {
    		//grid[i][j] += cum;
    		x += 1 + dfsUp(grid, i - 1, j, cum + 1);
    	}
    	return x;
    }
}