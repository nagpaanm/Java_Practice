package arrayNesting;

import java.util.HashSet;
import java.util.Set;

/*
 * You are given an integer array nums of length n where nums is a permutation 
 * of the numbers in the range [0, n - 1].

You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } 
subjected to the following rule:

The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].
 * 
 */

public class Solution {
	public int arrayNesting(int[] nums) {
        int length = 1;
        int size = nums.length;
        //since nums does not contain duplicates, add them to a set
        Set<Integer> indices = new HashSet<Integer>();
        for(int i = 0; i < size; i++){
            if(!indices.contains(i)){
                int num = nums[i];
                int ph = num;
                int max = 1;
                // depth first search
                while(true){
                    indices.add(num);
                    num = nums[num];
                    if(num == ph){
                        break;
                    }
                    max++;
                }
                length = Math.max(length, max);
                if(length > size / 2){
                    break;
                }
            }
        }
        return length;
    }
}
