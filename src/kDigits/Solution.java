package kDigits;

public class Solution {
	public String removeKdigits(String num, int k) {
        int n = num.length();
        if(k >= n){
            return "0";
        }
        int smallest = Integer.parseInt(num.substring(k, n));
        //will remove leading 0 - which is perfect =)
        for(int i = 0; i + k <= n; i++) {
        	String right = num.substring(i + k, n);
        	String left = "";
        	for(int j = 0; j < i; j++) {
        		left += num.charAt(j);
        	}
        	if(left.length() == 0) {
        		left = "0";
        	}
        	int val = Integer.parseInt(left + right);
        	System.out.println(i + " " +val + " " + left + " " +right);
        	if(val < smallest) {
        		smallest = val;
        	}
        }
        
        return Integer.toString(smallest);
    }
}
