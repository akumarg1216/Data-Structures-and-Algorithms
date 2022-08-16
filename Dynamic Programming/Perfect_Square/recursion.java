/**
 * recursion
 * 
 * The problem states that the minimum number of elements required to make a perfect square.
 * 
 * Example: 100 --> 10*10 --> o/p = 1
 * Example: 20 --> 1*1 (20 times) --> 20 || 2*2 (5 times) --> 5 || 4*4 + 2*2 --> 2 hence, min = 2 --> o/p = 2
 * 
 * Time Complexity: O(2^n) //TLE
 * Space Complexity: O(n) // Recursion Depth
 */
public class recursion {

    public static int solveRec(int n){

        // base case
        if(n == 0)
            return 0;
        
        int ans = n;
        for (int i=1;  i*i <= n; i++) {
            int temp = i*i;
            ans = Math.min(ans, 1+solveRec(n-temp));
        }
        return ans;
    }

    public static int minSquares(int n){
        return solveRec(n);
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(minSquares(n));
    }
}