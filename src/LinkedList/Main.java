package LinkedList;

public class Main {

	public static void main(String[] args) {

		int[] list = {1,2,4};
		Node node1 = createLinkedList(list);
		System.out.println(visualizeLinkedList(node1));
		node1 = insert(node1, 5);
		System.out.println(visualizeLinkedList(node1));
		node1 = insert(node1, 6);
		node1 = insert(node1, 7);
		System.out.println(visualizeLinkedList(node1));
		node1 = insertAtIndex(node1, 3, 2);
		node1 = insertAtIndex(node1, 8, 7);
		node1 = insertAtIndex(node1, 0, 0);
		System.out.println(visualizeLinkedList(node1));
		node1 = deleteAtIndex(node1, 5);
		System.out.println(visualizeLinkedList(node1));
		node1 = reverseLinkedList(node1);
		System.out.println(visualizeLinkedList(node1));
	}
	
	public static Node createLinkedList(int[] linkedList) {
		/*
		 * Created a linkedlist and return the 'head';
		 */
		if(linkedList.length == 0){
			return null;
		}
		Node head = new Node(linkedList[0]);
		Node current = head;
		for(int i = 1; i < linkedList.length; i++){
			Node node = new Node(linkedList[i]);
			head._next = node;
			head = head._next;
		}
		
		return current;
	}
	
	public static String visualizeLinkedList(Node head) {
		/*
		 * Return a string representation of the linkedlist
		 */
		Node pointer = head;
		String str = "";
		while(pointer != null) {
			str += pointer.value + "->";
			pointer = pointer._next;
		}
		str += "null";
		
		return str;
	}
	
	public static Node insert(Node head, int value) {
		/*
		 * Add an item to the end of the linkedlist and return the 'head'
		 */
		Node node = new Node(value);
		Node current = head;
		while(current._next != null) {
			current = current._next;
		}
		current._next = node;
		return head;
	}
	
	public static Node insertAtIndex(Node head, int value, int index) {
		/*
		 * Add an item at a specified index in the linkedlist and return the 
		 * 'head'. Assume the index is a valid index
		 */
		Node current = head;
		Node node = new Node(value);
		if(index == 0) {
			current = node;
			current._next = head;
			return current;
		}
		int i = 1;
		while(i != index) {
			current = current._next;
			i++;
		}
		Node temp = current._next;
		node._next = temp;
		current._next = node;
		
		return head;
	}
	
	public static Node deleteAtIndex(Node head, int index) {
		/*
		 * Delete a node at a specified index in the linkedlist and return the 
		 * 'head'. Assume the index is a valid index
		 */
		Node current = head;
		if(index == 0) {
			current = current._next;
			return current;
		}
		int i = 1;
		while(i != index) {
			current = current._next;
			i++;
		}
		current._next = current._next._next;
		
		return head;
	}
	
	public static Node reverseLinkedList(Node head) {
		/*
		 * Reverse the linkedlisted and return the new 'head'
		 */
		Node current = head;
		Node previous = null;
		while(true) {
			Node temp = current._next;
			current._next = previous;
			previous = current;
			if(temp == null) {
				break;
			}
			current = temp;
		}
		
		return current;
	}
	

}
