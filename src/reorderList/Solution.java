package reorderList;

import java.util.ArrayList;
import java.util.List;

import linkedListCycleii.ListNode;

public class Solution {
	public void reorderList(ListNode head) {
        //first element, then last element, then second element, then second last, element, then third element, then third-last element
        List<ListNode> arr = new ArrayList<ListNode>();
        if(head != null){
            ListNode pointer = head;
            // O(n)
            while(pointer != null){
                arr.add(pointer);
                pointer = pointer.next;
            }
            int size = arr.size();
            if(size > 2){
                for(int i = 1; i < size; i++){
                    if(size - i >= i){
                        head.next = arr.get(size - i);
                        head.next.next = arr.get(i);
                        head = head.next.next;
                    }
                    else{
                        //last element, make .next null so no loop
                        head.next = null;
                    }
                }
            }
        }
    }
}
