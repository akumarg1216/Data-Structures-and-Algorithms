import java.util.Arrays;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int[] obstacles){

        int n = obstacles.length - 1;

        int[][] dp = new int [4][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;

        for(int currpos = n-1; currpos >= 0; currpos--){
            for(int currlane = 1; currlane <= 3; currlane++){
                if(obstacles[currpos+1] != currlane)
                    dp[currlane][currpos] = dp[currlane][currpos+1];
                
                else{
                    int ans = Integer.MAX_VALUE;
                    for (int i = 1; i <= 3; i++) {
                        if(currlane != i && obstacles[currpos] != i){
                            ans = Math.min(ans, 1+dp[i][currpos+1]);
                        }
                    }
                    dp[currlane][currpos] = ans;
                }
            }
        }
        return Math.min(dp[2][0], Math.min(1+dp[1][0], 1+dp[3][0]));
    }

    public int minSideJumps(int[] obstacles) {
        return solveTab(obstacles);
    }
    
}