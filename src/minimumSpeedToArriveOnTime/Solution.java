package minimumSpeedToArriveOnTime;

/*
 * You are given a floating-point number hour, representing the amount of time 
 * you have to reach the office. To commute to the office, you must take n trains 
 * in sequential order. You are also given an integer array dist of length n, 
 * where dist[i] describes the distance (in kilometers) of the ith train ride.

Each train can only depart at an integer hour, so you may need to wait in 
between each train ride.

For example, if the 1st train ride takes 1.5 hours, you must wait for an 
additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
Return the minimum positive integer speed (in kilometers per hour) that 
all the trains must travel at for you to reach the office on time, or -1 if it 
is impossible to be on time.

Tests are generated such that the answer will not exceed 107 and hour will have 
at most two digits after the decimal point.
 */

public class Solution {
	 public int minSpeedOnTime(int[] dist, double hour) {
	        int length = dist.length;
	        if(length - 1 > hour || (length > 1 && hour == 1)){
	            return -1;
	        }
	        // O(n)
	        int min = 1;
	        int max = findMinMax(dist) * 100; //because 2 decimal places allowed on hour
	        int left = 1;
	        int right = max;
	        
	        // O(nlogn) - binary search
	        while(left <= right){
	            int hours = 0;
	            int mid = (left + right) / 2;
	            for(int i = 0; i < length; i++){
	                if(hours >= hour){
	                    left = mid + 1;
	                    break;
	                }
	                if(i != length - 1){
	                    int val = (int)Math.ceil((double)dist[i]/mid);
	                    hours += val;
	                }
	                else{
	                    double val = (double) dist[i]/mid;
	                    if(val + hours <= hour){
	                        min = mid;
	                        right = mid - 1;
	                    }else{
	                        left = mid + 1;
	                    }
	                }
	            }
	        }
	        return min;
	    }
	    
	 	// O(n)
	    public int findMinMax(int[] dist){
	        int max = 0;
	        for(int num: dist){
	            if(num > max){
	                max = num;
	            }
	        }
	        return max;
	    }
}
