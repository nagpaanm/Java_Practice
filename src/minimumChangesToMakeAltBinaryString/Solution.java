package minimumChangesToMakeAltBinaryString;

public class Solution {
	public int minOperations(String s) {
        int counter1 = 0; //start with 0
        int counter2 = 0; //start with 1
    
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                if(!String.valueOf(s.charAt(i)).equals("0")){
                    counter1++;
                }
                else{
                    counter2++;
                }
            }else{
                if(!String.valueOf(s.charAt(i)).equals("1")){
                    counter1++;
                }
                else{
                    counter2++;
                }
            }
        }
        
        return Math.min(counter1, counter2);
    }
}
