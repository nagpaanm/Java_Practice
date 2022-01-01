package findAllGroupsOfFarmLand;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> arr = new ArrayList<>();
    List<String> visited = new ArrayList<String>();
    public int[][] findFarmland(int[][] land) {
        for(int i = 0 ; i < land.length; i ++){
            for(int j = 0; j < land[i].length; j++){
                if(!visited.contains(Integer.toString(i) + "," + Integer.toString(j)) && land[i][j] == 1){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(i);
                    temp.add(j);
                    dfsDown(i,j, land, temp);
                    dfsLeft(i,j, land, temp);
                    arr.add(temp);
                    int m = i + 1;
                    int n = j + 1;
                    while(m <= temp.get(2)){
                        while(n <= temp.get(3)){
                            visited.add(Integer.toString(m) + "," + Integer.toString(n));
                            n++;
                        }
                        m++;
                        n = j + 1;
                    }
                }
            }
        }
        /*
        int[][] result = new int[arr.size()][4];
        for(int i = 0 ; i < result.length; i ++){
            for(int j = 0; j < result[i].length; j++){
                result[i][j] = arr.get(i).get(j);
            }
        }
        */
        int[][] result = arr.stream().map(list -> list.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        return result;
    }
    
    public void dfsLeft(int i , int j, int[][] land, List<Integer> temp){
        if(land[i][j] == 1){
            visited.add(Integer.toString(i) + "," + Integer.toString(j));
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
            visited.add(Integer.toString(i) + "," + Integer.toString(j));
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
