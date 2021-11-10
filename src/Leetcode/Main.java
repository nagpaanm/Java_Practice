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
	 * 
	 * Find largest num -> check (num - 1) spots below to see if that spot equals num,
	 * if so, check if num to num - 1 spots below occupy a 1, and check the same
	 * for the beginning (where it starts at 1). If so, # elements = num x num.
	 * 
	 * If not, find second largest number and repeat process above.
	 * 
	 * If not, find third largest number.. then 4th largest.. and so on until
	 * number = 1. If a 1 exists, return 1,
	 * 
	 * else, return 0;
	 */

	public static void main(String[] args) {
		int[][] grid = new int[][]{
			  { 1, 1, 1, 1},
			  { 0, 1, 1, 1},
			  { 1, 1, 1, 0}
		};
		Solution solution = new Solution();
		System.out.println(solution.largest1BorderedSquare(grid));
	}

}
