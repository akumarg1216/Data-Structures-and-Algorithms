/**
 * recursion
 * 
 * Given an array with the number of days as in a calender year i.e., 1-365.
 * The days array represents the days the person wants to travel.
 * There is a cost array which has 3 values. cost[0] for 1 day pass, cost[1] for 7 day pass, cost[2] for 30 day pass.
 * 
 * We have to find the minimum cost at which the person can travel all the days.
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) + O(n).
 */

public class recursion {

    public static int solveRec(int n, int days[], int cost[], int index){
        if(index >= n)
            return 0;
        
        // 1 day pass
        int cost1 = cost[0] + solveRec(n, days, cost, index+1);

        // 7 days pass
        int i;
        for(i = index; i<n && days[i] < days[index]+7; i++);    // used to just keep the track of index after 7 days.
        
        int cost2 = cost[1] + solveRec(n, days, cost, i);       // note this is not inside for loop.

        // 30 days pass
        for(i = index; i<n && days[i] < days[index]+30; i++);

        int cost3 = cost[2] + solveRec(n, days, cost, i);

        int ans = Math.min(cost1, Math.min(cost2, cost3));

        return ans;
    }

    public static int minimumCoins(int n, int days[], int[] cost){
        return solveRec(n, days, cost,0);
    }

    public static void main(String[] args) {
        int days[] = {1,3,4,5,7,8,10};
        int cost[] = {2,7,20};

        System.out.println(minimumCoins(days.length, days, cost));
    }
}