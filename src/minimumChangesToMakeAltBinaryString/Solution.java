package minimumChangesToMakeAltBinaryString;

public class Solution {
	public int minOperations(String s) {
        String newString = "";
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(newString.length() == 0){
                newString += String.valueOf(s.charAt(i));
            }
            else{
                if(String.valueOf(s.charAt(i)).equals("1")){
                    if(String.valueOf(newString.charAt(i - 1)).equals("1")){
                        newString += "0";
                        counter++;
                    }
                    else{
                        newString += "1";
                    }
                }
                else if(String.valueOf(s.charAt(i)).equals("0")){
                    if(String.valueOf(newString.charAt(i - 1)).equals("0")){
                        newString += "1";
                        counter++;
                    }
                    else{
                        newString += "0";
                    }
                }
            }
        }
        return counter;
    }
}
