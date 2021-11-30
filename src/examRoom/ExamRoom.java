package examRoom;

import java.util.ArrayList;
import java.util.List;

public class ExamRoom {
	List<Integer> arr = new ArrayList<Integer>();
    int length;
    
    public ExamRoom(int n) {
        length = n;
    }
    
    public int seat() {
        if(this.arr.size() == 0){
            arr.add(0);
        }
        return 0;
        
    }
    
    public void leave(int p) {
        this.arr.remove(p);
    }
}
