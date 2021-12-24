package setMismatch;

import java.util.HashMap;
import java.util.Map;

/*
 * You have a set of integers s, which originally contains all the numbers 
 * from 1 to n. Unfortunately, due to some error, one of the numbers in s got 
 * duplicated to another number in the set, which results in repetition of one 
 * number and loss of another number.

You are given an integer array nums representing the data status of this set 
after the error.

Find the number that occurs twice and the number that is missing and return 
them in the form of an array.
 */

public class Solution {
	public int[] findErrorNums(int[] nums) {
        int[] sol = new int[2];
        int dup = 0;
        int val = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //O(n)
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }
            else{
                dup = nums[i];
            }
        }
        
        // O(n)
        for(int i = 1; i < max; i++){
            if(!map.containsKey(i)){
                val = i;
            }
        }
        
        if(val == 0){
            val = max + 1;
        }
        
        sol[0] = dup;
        sol[1] = val;
        return sol;
    }
}
