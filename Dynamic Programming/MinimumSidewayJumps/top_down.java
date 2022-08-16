import java.util.Arrays;

/**
 * top_dowm
 */
public class top_down {

    public static int solveMem(int[] obstacles, int currlane, int currpos, int[][] dp){
        
        // base case
        int n = obstacles.length -1;
        
        if(currpos == n)
            return 0;
        
        if(dp[currlane][currpos] != -1)
            return dp[currlane][currpos];
        
        if(obstacles[currpos+1] != currlane){
            return solveMem(obstacles, currlane, currpos+1, dp);
        }
        
        else{
            int ans = Integer.MAX_VALUE;
            for(int i = 1; i <= 3; i++){
                if(currlane != i && obstacles[currpos] != i)
                    ans = Math.min(ans, 1 + solveMem(obstacles, i, currpos, dp));
            }
            dp[currlane][currpos] = ans;
            return dp[currlane][currpos];
        }
    }
    
    // ---------------------------------------------------------------------------------------
    
    public int minSideJumps(int[] obstacles) {
        
        int n = obstacles.length;
        
        // return solveRec(obstacles, 2, 0);
        
        int[][] dp = new int[4][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solveMem(obstacles, 2, 0, dp);
    }
}