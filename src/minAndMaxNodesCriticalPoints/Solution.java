package minAndMaxNodesCriticalPoints;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> arr = new ArrayList<Integer>();
        ListNode first = head;
        ListNode mid = first.next;
        int[] sol = {-1, -1};
        if(mid == null){
            return sol;
        }
        ListNode last = mid.next;
        if(last == null){
            return sol;
        }
        int index = 1;
        int minD = 100000;
        
        //O(n)
        while(last != null){
            // local maxima
            if(mid.val > first.val && mid.val > last.val){
                if(arr.size() > 0){
                    minD = Math.min(minD, index - arr.get(arr.size() - 1));
                }
                arr.add(index);
            }
            // local minima
            else if(mid.val < first.val && mid.val < last.val){
                if(arr.size() > 0){
                    minD = Math.min(minD, index - arr.get(arr.size() - 1));
                }
                arr.add(index);
            }
            first = first.next;
            mid = mid.next;
            last = last.next;
            index++;
        }
        
        if(arr.size() <= 1){
            return sol;
        }
        
        int maxD = arr.get(arr.size() - 1) - arr.get(0);
        sol[0] = minD;
        sol[1] = maxD;
        return sol;
    }
}
