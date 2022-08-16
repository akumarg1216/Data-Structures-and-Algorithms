import java.util.Arrays;

/**
 * bottom_up
 */
public class top_down {

    public static int solveMem(int n, int dp[]){

        // base case
        if(n == 0)
            return 0;

        if(dp[n]!=-1)
            return dp[n];
        
        int ans = n;
        for (int i=1;  i*i <= n; i++) {
            int temp = i*i;
            ans = Math.min(ans, 1+solveMem(n-temp,dp));
        }
        
        dp[n] = ans;
        return dp[n];
    }

    public static int minSquares(int n){
        int dp[] = new int [n+1];
        Arrays.fill(dp, -1);
        return solveMem(n,dp);
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(minSquares(n));
    }
}