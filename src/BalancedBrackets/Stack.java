package BalancedBrackets;

import java.util.ArrayList;

public class Stack {

	private ArrayList<String> stack;
	public Stack() {
		this.stack = new ArrayList<String>();
	}
	
	public void push(String element) {
		this.stack.add(element);
	}
	
	public String pop() {
		if(!this.isEmpty()) {
			String e = this.stack.remove(this.size() - 1);
			return e;
		}
		return null;
	}
	
	public boolean isEmpty() {
		if(this.size() == 0){
			return true;
		}
		return false;
	}
	
	private int size() {
		return this.stack.size();
	}
}
