package validSquare;

import java.util.ArrayList;

public class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		ArrayList<int[]> points = new ArrayList<int[]>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		
		// STEP 1) AND STEP 2)
		ArrayList<ArrayList<int[]>> arr = getMinAndMaxPoints(points);
		// arr will take the form of: [[yMax], [yMin], [rest]]
	   
	   // STEP 3)
	    //1 max, 1 min: a)
        if(arr.get(0).size() == 1 && arr.get(1).size() == 1) {
        	p1 = arr.get(0).get(0); // max
        	p2 = arr.get(1).get(0); // min
        	p3 = arr.get(2).get(0);
        	p4 = arr.get(2).get(1);
        	if(distance(p1, p3) == distance(p1, p4) && 
        			distance(p2, p3) == distance(p2, p4) && 
        			distance(p1, p3) == distance(p2, p3) &&
        			distance(p1, p4) == distance(p2, p4) &&
        			Math.abs(pythagoreanTheorem(distance(p1,p3), distance(p3,p2)) - distance(p1, p2)) < 0.1 &&
        			Math.abs(pythagoreanTheorem(distance(p1,p4), distance(p4,p2)) - distance(p1, p2)) < 0.1) {
        		return true;
        	}else {
        		return false;
        	}
        // 2 max, 2 min: b)
        }else if(arr.get(0).size() == 2 && arr.get(1).size() == 2) {
        	p1 = arr.get(0).get(0); // max1
        	p2 = arr.get(0).get(1); // max2
        	p3 = arr.get(1).get(0); // min1
        	p4 = arr.get(1).get(1); // min2
        	// x cors must match up here
        	if(p1[0] == p3[0]) {
        		if(p2[0] == p4[0]) {
        			if(distance(p1, p2) == distance(p3, p4) &&
        					distance(p1, p3) == distance(p2, p4) &&
        					distance(p1, p3) == distance(p1, p2)) {
        				return true;
        			}
        		}
        	}else if(p1[0] == p4[0]) {
        		if(p2[0] == p3[0]) {
        			if(distance(p1, p2) == distance(p3, p4) &&
        					distance(p1, p4) == distance(p2, p3) &&
        					distance(p1, p4) == distance(p1, p2)) {
        				return true;
        			}
        		}
        	}
        }
        // else
        return false;
	}
	
    // calculate a^2 + b^2
	public double pythagoreanTheorem(double d1, double d2) {
		return Math.sqrt(d1*d1 + d2*d2);
	}
	
    // calculate the distance between 2 points
	public double distance(int[] p1, int[] p2) {
		return Math.sqrt((p2[0] - p1[0])*(p2[0] - p1[0]) + (p2[1] - p1[1])*(p2[1] - p1[1]));
	}
	
	// STEP 1) & STEP 2
    // get an arraylist containing 3 arraylists - first arrayList containing points with a 'maximum'
    // y value, second arrayList containing points with a 'minimum' y value,
    //and last arrayList containing points with neither a max nor a min y value
	public ArrayList<ArrayList<int[]>> getMinAndMaxPoints(ArrayList<int[]> points) {
		ArrayList<ArrayList<int[]>> arr = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> yMax = new ArrayList<int[]>();
		ArrayList<int[]> yMin = new ArrayList<int[]>();
		ArrayList<int[]> rest = new ArrayList<int[]>();
		int maxY = points.get(0)[1];
		int minY = points.get(0)[1];
		for(int i = 0; i < points.size(); i++) {
			if(points.get(i)[1] > maxY) {
				maxY = points.get(i)[1];
			}
			if(points.get(i)[1] < minY) {
				minY = points.get(i)[1];
			}
		}
		
		for(int i = 0; i < points.size(); i++) {
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
