package shipPackages;

/*
 * A conveyor belt has packages that must be shipped from one port to another 
 * within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load 
the ship with packages on the conveyor belt (in the order given by weights). We 
may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the 
packages on the conveyor belt being shipped within days days.
 
 *
 *Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and 
splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 *
 *
 *
 *
 */

public class Solution {
	public int shipWithinDays(int[] weights, int days) {
		int max = weights[0];
        int sum = 0;
        // O(n)
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            if(weights[i] > max){
                max = weights[i];
            }
        }
        
        // binary search
        int left = 0;
        int right = sum;
        int lowest = sum;
        while(left <= right){
            int mid = (left + right) / 2;
            int current = 0;
            int days_ = 1;
            for(int weight: weights){
                if(current + weight > mid){
                    days_++;
                    current = 0;
                }
                current+= weight;
            }
            if(days_ <= days && mid >= max){
                lowest = mid;
                //search left side to see if lower val could exist
                right = mid - 1;
            }else{
                if(days_ > days || mid < max){
                    //go right
                    left = mid + 1;
                }else{
                    // go left
                    right = mid - 1;
                }
                
            }
                
        }
            
        return lowest;
    }
}
