package Mergesort;

/*
 * Runtime of O(nlogn) (worst-case);
 * 
 */
public class Mergesort {
	
	public static void mergesort(int[] arr) {
		/*
		 * Merge sort algorithm.
		 */
		int n = arr.length;
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		// populate left and right
		for(int i = 0; i < n; i++) {
			if(i < mid) {
				left[i] = arr[i];
			}else {
				right[i - mid] = arr[i];
			}
		}
		mergesort(left);
		mergesort(right);
		merge(left, right, arr);
	}
	
	public static void merge(int[] L, int[] R, int[] A){
		/*
		 * Merge algorithm
		 */
		int nL = L.length;
		int nR = R.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < nL && j < nR) {
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}else {
				A[k] = R[j];
				j++;
			}
			k++;
		}
		// after the first while loop, only 1 of the while loops below
		// will be true
		while(i < nL) {
			A[k] = L[i];
			i++;
			k++;
		}
		while(j < nR) {
			A[k] = R[j];
			j++;
			k++;
		}
	}
}
