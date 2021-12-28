package binaryNumberLinkedList;

public class Solution {
	public int getDecimalValue(ListNode head) {
        if(head == null){
            return 0;
        }
        String str = "";
        ListNode ptr = head;
        while(ptr != null){
            str += ptr.val;
            ptr = ptr.next;
        }
        int val = Integer.parseInt(str, 2); //base 2
        return val;
    }
}
