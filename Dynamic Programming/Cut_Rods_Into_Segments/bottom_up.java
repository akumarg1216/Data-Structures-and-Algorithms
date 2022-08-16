/*
 * Time Complexity: O(n)
 * Space Complexity: O(n)   // for dp array
 */

import java.util.Arrays;

public class bottom_up {

    public static int solveTab(int n, int x, int y, int z){

        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;

        for(int i=1; i<=n; i++){
            if(i-x >=0 && dp[i-x]!= -1) // dp[i-x] != -1 because if it is -1 then -1 + 1 will become dp[0]
                dp[i] = Math.max(dp[i], dp[i-x] + 1);

            if(i-y >=0 && dp[i-y]!= -1)
                dp[i] = Math.max(dp[i], dp[i-y] + 1);

            if(i-z >=0 && dp[i-z]!= -1)
                dp[i] = Math.max(dp[i], dp[i-z] + 1);
        }

        if(dp[n] < 0)
            return 0;
        else
            return dp[n];
    }
    
    public static int cutSegments(int n, int x, int y, int z){

        return solveTab(n, x, y, z);
    }
    
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 5;
        System.out.println(cutSegments(n, x, y, z));
    }
}