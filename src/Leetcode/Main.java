package Leetcode;

public class Main {
	/*
	 * 
	 * 
	 * TRY THIS TOMORRROW:
	 * 
	 * {1, 2, 3}
	 * {1, 0, 1}
	 * {1, 2, 3}
	 */

	public static void main(String[] args) {
		int[][] grid = new int[][]{
			  {0, 1, 1, 1},
			  {1, 1, 1, 1},
			  {1, 0, 0, 1},
			  {1, 1, 1, 1},
			  {1, 0, 1, 1},
			  {1, 1, 0, 1}
		};
		Solution solution = new Solution();
		System.out.println(solution.largest1BorderedSquare(grid));
	}

}
