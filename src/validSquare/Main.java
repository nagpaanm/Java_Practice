package validSquare;

public class Main {

	public static void main(String[] args) {
		int[] p1 = {1,0};
		int[] p2 = {-1,0};
		int[] p3 = {0,1};
		int[] p4 = {0,-1};
		
		Solution sol = new Solution();
		System.out.println(sol.validSquare(p1,p2,p3,p4));
	}

}
