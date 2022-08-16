import java.util.Arrays;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int[] v, int i, int j){
        int n = v.length;
        int[][] dp = new int [n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));
        
        for(i = n-1; i >= 0; i--){
            for(j = i+2; j < n; j++){
                int ans = Integer.MAX_VALUE;
                
                for(int k = i+1; k < j; k++){
                    ans = Math.min(ans, v[i]*v[j]*v[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n-1];
    }
    
    public int minScoreTriangulation(int[] values) {
        int n = values.length;      
        return solveTab(values, 0, n-1);
    }
}