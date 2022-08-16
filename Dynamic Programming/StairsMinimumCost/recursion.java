/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
 * Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * The array given will be (n-1) because the top floor will not have any cost since we have nowhere to go from there.
 * 
 * This is the recursion based approach of the given problem.
 * 
 * Time Complexity: O(2^n) // may result in TLE in competitive programming
 */
public class recursion {

    public static int minCostClimbingStairs(int [] cost){
        int n = cost.length;
        return Math.min(minCost(cost,n-1), minCost(cost,n-2));
    }

    private static int minCost(int[]cost, int n){
        if(n<0)
            return 0;
        if(n==0 || n==1)
            return cost[n];
        return cost[n] + Math.min(minCost(cost, n-1), minCost(cost, n-2));        
    }

    public static void main(String[] args) {
        int [] cost = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}