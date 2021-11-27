package arrayNesting;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int arrayNesting(int[] nums) {
        int length = 1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == nums[num]){
                continue;
            }
            Set<Integer> set = new HashSet<Integer>();
            set.add(num);
            while(true){
                num = nums[num];
                if(set.contains(num)){
                    break;
                }
                set.add(num);
            }
            length = Math.max(length, set.size());
            if(length > nums.length - i){
                break;
            }
        }
        return length;
    }
}
