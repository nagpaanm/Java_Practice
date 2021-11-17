package BalancedBrackets;


// total runtime = O(n)
// balanced brackets
public class Main {

	public static void main(String[] args) {
		String brackets = "(({[}])[])(){}(())";
		Stack stack = new Stack();
		boolean isBalanced = true;
		
		String[] opening = {"(", "{", "["};
		String[] closing = {")", "}", "]"};
		
		// O(n)
		for(int i = 0; i < brackets.length(); i++) {
			if(contains(opening, String.valueOf(brackets.charAt(i))) == true){
				stack.push(String.valueOf(brackets.charAt(i)));
			}
			else {
				// closing bracket
				if(stack.isEmpty()) {
					isBalanced = false;
					break;
				}
				String popped = stack.pop();
				String val = inverse(closing, opening, String.valueOf(brackets.charAt(i)));
				if(!val.equals(popped)) {
					// return false;
					isBalanced = false;
					break;
				}
			}
		}
		if(isBalanced == false) {
			System.out.println(false);
		}
		else {
			System.out.println(true);
		}
	}
	
	// O(n)
	public static boolean contains(String[] arr, String val) {
		for(String str: arr) {
			if(str.equals(val)) {
				return true;
			}
		}
		return false;
	}
	
	// O(n)
	public static String inverse(String[] closing, String[] opening, String val) {
		for(int i = 0; i < closing.length; i++) {
			if(closing[i].equals(val)) {
				return opening[i];
			}
		}
		return null;
	}

}
