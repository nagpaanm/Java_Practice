package mergeKSortedLists;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

	Merge all the linked-lists into one sorted linked-list and return it.
	
	
	
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
 */

public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        ListNode head = node;
        List<int[]> arr = new ArrayList<int[]>();
        boolean first = true;
        
        // O(mxn)
        while(true){
            for(int i = 0; i < lists.length; i++){
                ListNode curr = lists[i];
                if(curr != null){
                    int[] temp = {lists[i].val, i};
                    arr.add(temp);
                }
            }
            if(arr.size() == 0){
                break;
            }
            int index = getMinIndex(arr);
            if(first){
                node.val = lists[index].val;
                first = false;
            }
            else{
                node.next = lists[index];
                node.next.val = lists[index].val;
                node = node.next;
            }
            lists[index] = lists[index].next;
            arr = new ArrayList<int[]>();
        }
        
        if(head.val == 0 && head.next == null){
            return null;
        }
        return head;
    }
    
    // O(n) time
    public int getMinIndex(List<int[]> arr){
        int index = 0;
        int min = 10000;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i)[0] < min){
                min = arr.get(i)[0];
                index = arr.get(i)[1];
            }
        }
        
        return index;
    }
}
