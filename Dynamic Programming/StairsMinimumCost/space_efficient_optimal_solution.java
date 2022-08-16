/**
 * space_efficient_optimal_solution
 * 
 * In this no extra space is required as the current element depends only on previous 2 values.
 * Hence we make 2 variables and update that as and when required to keep the track.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) // since no array is required to store the values. Only variables are storing hence there is no need of extra space & the space complexity comes down to O(n), which is the best among all the solutions of the given problem.
 */
public class space_efficient_optimal_solution {

    public static int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        return minCost(cost, n);
    }

    private static int minCost(int []cost, int n){
        
        int prev2 = cost[0];
        int prev1 = cost[1];

        for(int i=2;i<n;i++){
            int curr = cost[i] + Math.min(prev1,prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int cost [] = {10,15,20};
        System.out.println(minCostClimbingStairs(cost));
    }
}