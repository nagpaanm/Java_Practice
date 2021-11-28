package palindromeNumber;

/*
Given an integer x, return true if x is palindrome integer.

An integer is a palindrome when it reads the same backward as forward. For example, 
121 is palindrome while 123 is not.


//Note: use recursion.
*/

public class Solution {
	public boolean isPalindrome(int x) {
        String xS = Integer.toString(x);
        try{
            int palindrome = Integer.parseInt(flip(xS, xS.length() - 1));
            return (palindrome == x);
        }
        catch(NumberFormatException e){
            return false;
        }
    }
    
    public String flip(String x, int index){
        if(index >= 0){
            return String.valueOf(x.charAt(index)) + flip(x, index - 1);
        }
        return "";
    }
}
