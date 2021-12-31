package elementAppearingMoreThan25;

/*
 * Given an integer array sorted in non-decreasing order, 
 * there is exactly one integer in the array that occurs more than 25% of the 
 * time, return that integer.
 */

public class Solution {
	public int findSpecialInteger(int[] arr) {
        int count = 1;
        int element = 1;
        int temp = 1;
        for(int i = 0 ; i < arr.length - 1; i++){
            if(arr[i] == arr[i + 1]){
                temp++;
            }
            if(arr[i] != arr[i + 1] || i == arr.length - 2){
                if(temp > count){
                    count = temp;
                    element = arr[i];
                }
                temp = 1;
            }
        }
        return element;
    }
}
