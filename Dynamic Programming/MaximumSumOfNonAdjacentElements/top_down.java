/**
 * top_down
 * 
 * 1. Creation of array
 * 2. Analyse the base case. (dp[0] = nums[0]) --> see recursion base case
 * 3. Run a loop till end & make the changes from n to i
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class top_down {

    public static int solveTab(int nums[]){
        int n = nums.length;
        int [] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i=2; i<n; i++){
            int incl = dp[i-2] + nums[i];
            int excl = dp[i-1] + 0;
            dp[i] = Math.max(incl, excl);
        }
        return dp[n-1];
    }

    public static int maximumNonAdjacentSum(int[]nums){
        return solveTab(nums);
    }

    public static void main(String[] args) {
        int nums[] = {10,11,12,13,14};
        System.out.println(maximumNonAdjacentSum(nums));
    }
}