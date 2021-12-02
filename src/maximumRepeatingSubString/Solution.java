package maximumRepeatingSubString;
/*
 * For a string sequence, a string word is k-repeating if word 
 * concatenated k times is a substring of sequence. The word's 
 * maximum k-repeating value is the highest value k where word 
 * is k-repeating in sequence. If word is not a substring of sequence, 
 * word's maximum k-repeating value is 0.

Given strings sequence and word, return the maximum k-repeating value 
of word in sequence.
 */

//O(n * (n/wLength))
class Solution {
  public int maxRepeating(String sequence, String word) {
      int total = 0;
      int wLength = word.length();
      int sLength = sequence.length();
      if(wLength == sLength){
          if(word.equals(sequence)){
              total++;
          }
      }else{
          // O(n)
          for(int i = 0; i < sLength; i++){
              int count = 0;
              int a = i;
              int b = (wLength) + i;
              if(b > sLength){
                  break;
              }
              String s = sequence.substring(a, b);
              //O(n / wLength) = O(n)
              while(s.equals(word)){
                  count++;
                  a += wLength;
                  b += wLength;
                  if(b > sLength){
                      break;
                  }
                  s = sequence.substring(a, b);
              }
              if(count > total){
                  total = count;
              }
          } 
      }

      return total;
  }
}