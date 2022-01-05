package degreeOfAnArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a non-empty array of non-negative integers nums, 
the degree of this array is defined as the maximum frequency of any one of its 
elements.

Your task is to find the smallest possible length of a (contiguous) subarray of 
nums, that has the same degree as nums.
 */

public class Solution {
	public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxOccurence = 0;
        int number = 0;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if(map.get(nums[i]) > maxOccurence){
                maxOccurence = map.get(nums[i]);
                number = nums[i];
            }
        }
        
        List<Integer> numberList = new ArrayList<Integer>();
        
        for(int i: map.keySet()){
            if(map.get(i) == maxOccurence && !numberList.contains(map.get(i))){
                numberList.add(i);
            }
        }
        
        int index = 0;
        int minCount = Integer.MAX_VALUE;
        while(index <= numberList.size() - 1){
            number = numberList.get(index);
            boolean started = false;
            int start = 0;
            int end = 0;
            int occurences = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == number){
                    occurences++;
                    if(!started){
                        started = true;
                        start = i;
                    }
                }
                if(occurences == maxOccurence){
                    end = i;
                    break;
                }
            }
            minCount = Math.min(minCount, end - (start - 1));
            index++;
        }
        
        return minCount;
    }
}
