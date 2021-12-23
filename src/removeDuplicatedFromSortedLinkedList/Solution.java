package removeDuplicatedFromSortedLinkedList;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while(ptr != null){
            ListNode cur = ptr;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            ptr.next = cur.next;
            ptr = ptr.next;
        }
        
        return head;
    }
}
