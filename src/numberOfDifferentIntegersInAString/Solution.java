package numberOfDifferentIntegersInAString;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given a string word that consists of digits and lowercase English 
 * letters.

You will replace every non-digit character with a space. 
For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are 
left with some integers that are separated by at least one space: "123", "34", 
"8", and "34".

Return the number of different integers after performing the replacement 
operations on word.

Two integers are considered different if their decimal representations without 
any leading zeros are different.

 */
public class Solution {
	public int numDifferentIntegers(String word) {
        String s = "";
        for(int i = 0; i < word.length(); i++){
            if(Character.isLetter(word.charAt(i))){
                s += " ";
            }
            else{
                s += String.valueOf(word.charAt(i));
            }
        }
        String [] result = s.split(" ");
        List<String> arr = new ArrayList<String>();
        for(String a : result){
            a = a.trim();
            if(a.length() == 0){
                continue;
            }
            while(a.charAt(0) == '0'){
                if(a.length() == 1){
                    break;
                }
                a = a.substring(1, a.length());
            }
            if(a.length() > 0 && !arr.contains(a)){
                arr.add(a);
            }
        }
        return arr.size();
    }
}
