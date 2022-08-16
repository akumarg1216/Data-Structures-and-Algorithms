import java.util.Arrays;

/**
 * top_down
 */
public class top_down {

    public static int solveMem(int[] satisfaction, int index, int time, int dp[][]){
        
        // base case
        if(index == satisfaction.length)
            return 0;

        if(dp[index][time] != -1)
            return dp[index][time];
        
        int include = satisfaction[index] * (time+1) + solveMem(satisfaction, index+1, time+1, dp);
        int exclude = 0 + solveMem(satisfaction, index+1, time, dp);
            
        dp[index][time] = Math.max(include, exclude);

        return dp[index][time];
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);

        int n = satisfaction.length;

        int [][]dp = new int [n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solveMem(satisfaction, 0, 0, dp);
        
    }
}