package constructKPalindromeStrings;

/*
 * Given a string s and an integer k, return true if you can use all the 
 * characters in s to construct k palindrome strings or false otherwise.
 */

public class Solution {
	public boolean canConstruct(String s, int k) {
        if(k > s.length()){
            return false;
        }
        
        // count the occurences of each char in s
        int[] arr = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }
        
        // count the number of odd occurences of each char in s
        int oddCount = 0;
        for(int i = 0 ; i < 26; i++){
            if(arr[i] % 2 != 0){
                oddCount++;
            }
        }
        
        // if number of odd occurences is less than or equal to the number of palindromes, it is possible (i.e. return true)
        return oddCount <= k;
    }
}
