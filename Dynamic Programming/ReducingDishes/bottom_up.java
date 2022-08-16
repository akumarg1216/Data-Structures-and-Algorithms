import java.util.Arrays;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int[] satisfaction){
        int n = satisfaction.length;
        
        int [][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, 0));
        
        for(int index = n-1; index >= 0; index--){
            for(int time = n-1; time >=0; time --){
                        
                int include = satisfaction[index] * (time+1) + dp[index+1][time+1];
                int exclude = 0 + dp[index+1][time];
            
                dp[index][time] =  Math.max(include, exclude);
            } 
        }
        return dp[0][0];
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
    
        //return solveRec(satisfaction, 0, 0);
    
        // int n = satisfaction.length;
    
        // int [][]dp = new int [n+1][n+1];
        // Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        // return solveMem(satisfaction, 0, 0, dp);

        return solveTab(satisfaction);
        
    }
}