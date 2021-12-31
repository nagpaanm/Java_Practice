package longPressedName;

/*
 * Your friend is typing his name into a keyboard. Sometimes, when typing a 
 * character c, the key might get long pressed, and the character will be typed 
 * 1 or more times.

You examine the typed characters of the keyboard. Return True if it is possible 
that it was your friends name, with some characters (possibly none) being long 
pressed.
 */

public class Solution {
	public boolean isLongPressedName(String name, String typed) {
        if(!String.valueOf(name.charAt(0)).equals(String.valueOf(typed.charAt(0)))){
            return false;
        }
        if(!String.valueOf(name.charAt(name.length() - 1)).equals(String.valueOf(typed.charAt(typed.length() - 1)))){
            return false;
        }
        int counter = 0;
        int left = 0;
        int temp1 = 0;
        int temp2 = 0;
        while(counter <= name.length() - 1 && left <= typed.length() - 1){
            temp1 = 0;
            temp2 = 0;
            if(String.valueOf(typed.charAt(left)).equals(String.valueOf(name.charAt(counter)))){
                temp1++;
                if(counter < name.length() - 1){
                    while(String.valueOf(name.charAt(counter)).equals(String.valueOf(name.charAt(counter + 1)))){
                        counter++;
                        temp1++;
                        if(counter == name.length() - 1){
                            break;
                        }
                    }
                }
                while(String.valueOf(typed.charAt(left)).equals(String.valueOf(name.charAt(counter)))){
                    left++;
                    temp2++;
                    if(left == typed.length()){
                        break;
                    }
                }
                System.out.println(temp1 + " " + temp2);
                if(temp1 > temp2){
                    return false;
                }
            }
            else{
                return false;
            }
            counter++;
        }
        if(left <= typed.length() - 1){
            if(!String.valueOf(typed.charAt(left)).equals(String.valueOf(name.charAt(name.length() - 1)))){
                return false;
            }
        }
        if(counter < name.length()){
            return false;
        }
        return true;
    }
}
