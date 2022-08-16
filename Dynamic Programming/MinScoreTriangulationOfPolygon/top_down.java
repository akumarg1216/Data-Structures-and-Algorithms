import java.util.Arrays;

/**
 * top_down
 */
public class top_down {

    public static int solveMem(int v[], int i, int j, int[][] dp){

        // base case
        // i is the first node & j is the last. i+1=j indicates that only 2 nodes are present and a triangle cannot be created using only 2 nodes.
        if(i+1 == j)
            return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int ans = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++){
            ans = Math.min(ans, v[i]*v[j]*v[k] + solveMem(v, i, k, dp) + solveMem(v, k, j, dp));
        }
        dp[i][j] = ans;
        return dp[i][j];        
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int [][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solveMem(values,0,n-1,dp);
    }
}