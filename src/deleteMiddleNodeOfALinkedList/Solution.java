package deleteMiddleNodeOfALinkedList;

public class Solution {
	public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return null;
        }
        if(head.next.next == null){
            head.next = null;
            return head;
        }
        // else
        ListNode ptr1 = head;
        ListNode ptr2 = head.next.next;
        while(ptr2.next != null && ptr2.next.next != null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if(ptr2 != null && ptr2.next != null){
            ptr1 = ptr1.next;
            ptr1.next = ptr1.next.next;
        }
        else{
            ptr1.next = ptr1.next.next;
        }
        
        return head;
    }
}
