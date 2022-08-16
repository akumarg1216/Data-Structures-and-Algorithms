import java.util.Arrays;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveMem(int n, int days[], int cost[], int index, int dp[]){
        if(index >= n)
            return 0;

        if(dp[n]!=-1)
            return dp[n];
        
        // 1 day pass
        int cost1 = cost[0] + solveMem(n, days, cost, index+1, dp);

        // 7 days pass
        int i;
        for(i = index; i<n && days[i] < days[index]+7; i++);    // used to just keep the track of index after 7 days.
        
        int cost2 = cost[1] + solveMem(n, days, cost, i, dp);       // note this is not inside for loop.

        // 30 days pass
        for(i = index; i<n && days[i] < days[index]+30; i++);

        int cost3 = cost[2] + solveMem(n, days, cost, i, dp);

        dp[n] = Math.min(cost1, Math.min(cost2, cost3));

        return dp[n];
    }

    public static int minimumCoins(int n, int days[], int[] cost){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solveMem(n, days, cost,0, dp);
    }

    public static void main(String[] args) {
        int days[] = {1,3,4,5,7,8,10};
        int cost[] = {2,7,20};

        System.out.println(minimumCoins(days.length, days, cost));
    }
}