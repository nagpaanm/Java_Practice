package toePlitzMatrix;
/*
 * 
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, 
 * return false.

 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the 
 * same elements.
 */

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(i == 0 || j == 0){
                    int x = j + 1;
                    int y = i + 1;
                    int num = matrix[i][j];
                    while(x < matrix[i].length && y < matrix.length){
                        //System.out.println(num + " " + matrix[y][x]);
                        if(matrix[y][x] != num){
                            return false;
                        }
                        x++;
                        y++;
                    }
                }
            }
        }
        
        return true;
    }
}
