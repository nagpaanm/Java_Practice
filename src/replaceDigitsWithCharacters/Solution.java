package replaceDigitsWithCharacters;

public class Solution {
	public String replaceDigits(String s) {
        char[] str = s.toCharArray();
        char[] arr = {'0', 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        for(int i = 0; i < str.length - 1; i = i + 2){
            int y = str[i + 1] - '0';
            str[i + 1] = (char) (arr[findCharIndex(str[i], arr)] + y);
        }
        
        return String.valueOf(str);
    }
    
    public int findCharIndex(char c, char[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == c){
                return i;
            }
        }
        return 0;
    }
}
