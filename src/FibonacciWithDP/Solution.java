package FibonacciWithDP;


//dynamic programming approach

public class Solution {
	public int fib(int n) {
        Integer[] arr = new Integer[n + 1];
        return fibSub(n, arr);
    }
    
    public int fibSub(int n, Integer[] arr) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(arr[n] == null){
            int val = fibSub(n - 1, arr) + fibSub(n - 2, arr);
            arr[n] = val;
            return val;
        }
        return arr[n];
    }
}
