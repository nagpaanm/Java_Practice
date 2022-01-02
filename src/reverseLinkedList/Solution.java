package reverseLinkedList;

/*
 * Given the head of a singly linked list, reverse the list, 
 * and return the reversed list.
 */

public class Solution {
	public ListNode reverseList(ListNode head) {
        ListNode ptr = head;
        ListNode prev = null;
        while(ptr != null){
            ListNode temp = ptr.next;
            ptr.next = prev;
            prev = ptr;
            if(temp == null){
                break;
            }
            ptr = temp;
        }
        return ptr;
    }
}
