import java.util.Arrays;

/**
 * top_down approach of the minimum cost for climbing stairs
 * The method uses recursion + memoization --> to reduce the time complexity.
 * 
 * Time Complexity: O(n)
 * Space: O(n) + O(n) ~ O(n)
 */
class top_down {
        
    public static int solveMem(int[] cost, int n, int[] dp){
        
        // base case
        if(n < 0)
            return 0;
        
        if(n == 0 || n == 1)
            return cost[n];
        
        if(dp[n] != 0)
            return dp[n];
        
        dp[n] = cost[n] + Math.min(solveMem(cost, n-1, dp), solveMem(cost, n-2, dp));
        
       return dp[n];
            
            
    }
    
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []dp = new int[n];
        Arrays.fill(dp,0);
        
        return Math.min(solveMem(cost, n-1, dp), solveMem(cost, n-2, dp));
    }

    public static void main(String[] args) {
        int cost [] = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}