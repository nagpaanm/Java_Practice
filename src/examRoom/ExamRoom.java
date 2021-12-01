package examRoom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ExamRoom {
    List<Integer> arr = new ArrayList<Integer>();
    int length;
    
    public ExamRoom(int n) {
        length = n;
    }
    
    public int seat() {
        if(this.arr.size() == 0){
            arr.add(0);
            return 0;
        }
        if(arr.size() == 1){
            int num = arr.get(0);
            if(num < length / 2){
                arr.add(length - 1);
                return length - 1;
            }else{
                arr.add(0);
                return 0;
            }
        }
        // else
        
        // sort the list
        Collections.sort(arr);
        int index = length;
        int maxWidth = 0;
        int max = 0;
        for(int i = 0; i < arr.size() - 1; i++) {
        	if(arr.get(i + 1) - arr.get(i) > max) {
        		if(((arr.get(i + 1) + arr.get(i)) / 2) - arr.get(i) > maxWidth) {
        			index = ((arr.get(i + 1) + arr.get(i)) / 2);
        			maxWidth = ((arr.get(i + 1) + arr.get(i)) / 2) - arr.get(i);
        			max = arr.get(i + 1) - arr.get(i);
        		}
        	}
        }
        // edge case : beginning of list
        if(this.arr.get(0) >= maxWidth && !this.arr.contains(0)){
            index = 0;
        }
        
        // edge case: end of list
        if(index == length){
            index--;
        }
        
        this.arr.add(index);
        return index;
    }
    
    public void leave(int p) {
        int index = this.arr.indexOf(p);
        this.arr.remove(index);
    }
}
