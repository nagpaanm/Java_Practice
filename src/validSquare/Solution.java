package validSquare;

import java.util.ArrayList;

public class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		ArrayList<int[]> points = new ArrayList<int[]>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
        // 2 max points that are equal, or 1 max point
		ArrayList<ArrayList<int[]>> arr = getMinAndMaxPoints(points);
		// [yMax, yMin, rest]
        if(arr.get(0).size() == 1 && arr.get(1).size() == 1) {
        	p1 = arr.get(0).get(0); // max
        	p2 = arr.get(1).get(0); // min
        	p3 = arr.get(2).get(0);
        	p4 = arr.get(2).get(1);
        	if(distance(p1, p3) == distance(p1, p4) && 
        			distance(p2, p3) == distance(p2, p4) && 
        			distance(p1, p3) == distance(p2, p3) &&
        			distance(p1, p4) == distance(p2, p4)){
        		return true;
        	}else {
        		return false;
        	}
        }else if(arr.get(0).size() == 2 && arr.get(1).size() == 2) {
        	p1 = arr.get(0).get(0); // max1
        	p2 = arr.get(0).get(1); // max2
        	p3 = arr.get(1).get(0); // max3
        	p4 = arr.get(1).get(1); // max4
        	// x cors must match up here
        	if(p1[0] == p3[0]) {
        		if(p2[0] == p4[0]) {
        			
        		}
        	}else if(p1[0] == p4[0]) {
        		
        	}
        	// else
        	return false;
        }
        // else
        return false;
	}
	
	public double distance(int[] p1, int[] p2) {
		return (p2[0] - p1[0])*(p2[0] - p1[0]) + (p2[1] - p1[1])*(p2[1] - p1[1]);
	}
	
	public ArrayList<ArrayList<int[]>> getMinAndMaxPoints(ArrayList<int[]> points) {
		ArrayList<ArrayList<int[]>> arr = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> yMax = new ArrayList<int[]>();
		ArrayList<int[]> yMin = new ArrayList<int[]>();
		ArrayList<int[]> rest = new ArrayList<int[]>();
		int maxY = points.get(0)[1];
		int minY = points.get(0)[1];
		for(int i = 1; i < points.size(); i++) {
			if(points.get(i)[1] > maxY) {
				maxY = points.get(i)[1];
			}
			if(points.get(i)[1] < minY) {
				minY = points.get(i)[1];
			}
		}
		
		for(int i = 1; i < points.size(); i++) {
			if(points.get(i)[1] == maxY) {
				yMax.add(points.get(i));
			}
			else if(points.get(i)[1] == minY) {
				yMin.add(points.get(i));
			}
			else {
				rest.add(points.get(i));
			}
		}
		
		arr.add(yMax);
		arr.add(yMin);
		arr.add(rest);
		return arr;
	}
	
}
