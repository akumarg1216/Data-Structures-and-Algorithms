/*
 * Time Complexity: O(n)
 * Space Complexity: O(n) + O(n) // for recursion stack & 1-D array.
 */


import java.util.Arrays;

public class top_down {

    public static int solveMem(int n, int x, int y, int z, int [] dp){

        // base case
        if(n == 0) // length of rod = 0
            return 0;

        if(n < 0) //suppose only 2 m of rod is left & value of x = 5. In that case the n will become -3 (negative).
            return Integer.MIN_VALUE;

        if(dp[n]!= -1)
            return dp[n];
        
        int a = solveMem(n-x, x, y, z, dp) + 1; //implies that x length is used & n-x length is left and 1 because x is also a segment that is cut out at first.
        int b = solveMem(n-y, x, y, z, dp) + 1; //implies that y length is used & n-x length is left and 1 because y is also a segment that is cut out at first.
        int c = solveMem(n-z, x, y, z, dp) + 1; //implies that z length is used & n-x length is left and 1 because z is also a segment that is cut out at first.

        dp[n] =  Math.max(a, Math.max(b,c));
        return dp[n];
    }
    
    public static int cutSegments(int n, int x, int y, int z){

        int [] dp = new int[n+1];
        Arrays.fill(dp,0, dp.length, -1);
        int ans = solveMem(n, x, y, z, dp);
        if(ans < 0)
            return 0;
        else
            return ans;
    }
    
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 5;
        System.out.println(cutSegments(n, x, y, z));
    }
}