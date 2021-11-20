package linkedListCycleii;

import java.util.ArrayList;
import java.util.List;

/*
Given the head of a linked list, return the node where the cycle begins. 
If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that 
can be reached again by continuously following the next pointer. Internally, 
pos is used to denote the index of the node that tail's next pointer is 
connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not 
passed as a parameter.

Do not modify the linked list.
*/

public class Solution {
	public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        else if(head.next == null){
            return null;
        }
        //else
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while(head != slow){
                    head = head.next;
                    slow = slow.next; 
                }
                return slow;
            }
        }
        return null;
        /*
        List<ListNode> arr = new ArrayList<ListNode>();
        arr.add(head);
        ListNode pointer = head;
        
        //O(n)
        while(pointer != null){
            pointer = pointer.next;
            if(!arr.contains(pointer)){
                arr.add(pointer);
            }
            else{
                return pointer;
            }
        }
        return null;
        */
    }
}
