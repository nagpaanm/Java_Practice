package numberOfPrimeBIts;

/*
 * Given two integers left and right, return the count of numbers in the 
 * inclusive range [left, right] having a prime number of set bits in their 
 * binary representation.

Recall that the number of set bits an integer has is the number of 1's present 
when written in binary.
 */

public class Solution {
	public int countPrimeSetBits(int left, int right) {
        int primeCounter = 0;
        for(int i = left; i <= right; i++){
            String bs = Integer.toBinaryString(i);
            int amount = countOnes(bs);
            if(checkPrime(amount)){
                primeCounter++;
            }
        }
        
        return primeCounter;
    }
    
    public int countOnes(String s){
        int counter = 0;
        for(int i = 0; i < s.length(); i++){
            if(String.valueOf(s.charAt(i)).equals("1")){
                counter++;
            }
        }
        return counter;
    }
    
    public boolean checkPrime(int number){
        if(number == 1){
            return false;
        }
        if(number == 2 || number == 3){
            return true;
        }
        for(int i = number / 2; i > 1 ; i--){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}
