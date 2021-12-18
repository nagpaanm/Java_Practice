package ReverseString2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
public String reverseStr(String s, int k) {
        if(s.length() == 1){
            return s;
        }
        String str = "";
        List<String> arr = new ArrayList<String>();
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            str += String.valueOf(s.charAt(i));
            counter++;
            if(counter == 2*k || i == s.length() - 1){
                counter = 0;
                arr.add(str);
                str = "";
            }
        }
        String main = "";
        for(String b: arr){
            String a = "";
            if(b.length() == 1){
                main += b;
            }
            else{
                for(int i = Math.min(k - 1, b.length() - 1); i >= 0; i--){
                    a += String.valueOf(b.charAt(i));
                }
                if(k < b.length()){
                    a += b.substring(k, b.length());
                }
                main += a;
            }
        }
        return main;
    }
}
