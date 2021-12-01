package BinarySearchAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//O(n) runtime
class ExamRoom {
 List<Integer> arr = new ArrayList<Integer>();
 int length;
 
 public ExamRoom(int n) {
     length = n;
 }
 
 public int seat() {
     int index = length;
     int maxWidth = 0;
     int max = 0;
     // case 1
     if(this.arr.size() == 0){
         arr.add(0);
         return 0;
     }
     // case 2
     else if(arr.size() == 1){
         int num = arr.get(0);
         if(num < length / 2){
             index = length - 1;
         }else{
             index = 0;
         }
     // case 3
     }else{
         for(int i = 0; i < arr.size() - 1; i++) {
     	if(arr.get(i + 1) - arr.get(i) > max) {
     		if(((arr.get(i + 1) + arr.get(i)) / 2) - arr.get(i) > maxWidth) {
     			index = ((arr.get(i + 1) + arr.get(i)) / 2);
     			maxWidth = ((arr.get(i + 1) + arr.get(i)) / 2) - arr.get(i);
     			max = arr.get(i + 1) - arr.get(i);
     		}
     	}
         }
         // edge case 1: beginning of list
         if(this.arr.get(0) >= maxWidth && !this.arr.contains(0)){
             index = 0;
         }
     
         // edge case 2: end of list
         if(index == length){
             index--;
         }
     }
     //System.out.println(arr);

     addElement(this.arr, index);
     return index;
 }
 
 public void leave(int p) {
     int index = this.arr.indexOf(p);
     this.arr.remove(index);
 }
 
 // add element in order
 public void addElement(List<Integer> arr, int element){
     for(int i = 0; i < arr.size(); i ++){
         if(element < arr.get(i)){
             arr.add(i, element);
             return;
         }
     }
     arr.add(arr.size(), element);
 }
}
