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
        //O(n)
        while(last != null){
            // local maxima
            if(mid.val > first.val && mid.val > last.val){
                arr.add(index);
            }
            // local minima
            else if(mid.val < first.val && mid.val < last.val){
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
        int minD = getMinD(arr);
        sol[0] = minD;
        sol[1] = maxD;
        return sol;
    }
    
    // O(n)
    public int getMinD(List<Integer> arr){
        int minD = 100000;
        for(int i = 0; i < arr.size() - 1; i++){
            if(arr.get(i + 1) - arr.get(i) < minD){
                minD = arr.get(i + 1) - arr.get(i);
            }
        }
        
        return minD;
    }
}
