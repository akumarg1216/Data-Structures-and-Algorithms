import java.util.Arrays;

/**
 * top_down
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class bottom_up {

    public static int solveTab(int n, int days[], int cost[]){

        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        dp[n] = 0;

        for(int k = n-1; k>=0; k--){
            // 1 day pass
            int cost1 = cost[0] + dp[k+1];

            // 7 days pass
            int i;
            for(i = k; i<n && days[i] < days[k]+7; i++);    // used to just keep the track of k after 7 days.
            
            int cost2 = cost[1] + dp[i];       // note this is not inside for loop.

            // 30 days pass
            for(i = k; i<n && days[i] < days[k]+30; i++);

            int cost3 = cost[2] + dp[i];

            dp[k] = Math.min(cost1, Math.min(cost2, cost3));
        }

            return dp[0];
    }

    public static int minimumCoins(int n, int days[], int[] cost){
        return solveTab(n, days, cost);
    }

    public static void main(String[] args) {
        int days[] = {1,3,4,5,7,8,10};
        int cost[] = {2,7,20};

        System.out.println(minimumCoins(days.length, days, cost));
    }
}