/**
 * bottom_up approach for the given problem.
 * Here we use the tabulation method.
 * We use here for loop or while loop to handle the cases from 2 to n-1 since the cases 0 & 1 are handled as the base cases for the give problem.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)  //better than top-down approach
 */
public class bottom_up {

    //static int[] dp;
    public static int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        return minCost(cost, n);
    }

    private static int minCost(int []cost, int n){
        int [] dp = new int [1000];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i=2;i<n;i++){
            dp[i] = cost[i] + Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }

    public static void main(String[] args) {
        int cost [] = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}