package LinkedList;

public class Node {
	/*
	 * A Node object. 
	 */
	
	// fields
	public int value; //initially undefined
	public Node _next; //initially undefined
	
	public Node(int value) {
		/*
		 * Constructor overloading
		 */
		this(value, null);
	}
	
	public Node(int value, Node _next) {
		/*
		 * Constructor overloading
		 */
		this.value = value;
		this._next = _next;
	}
}
