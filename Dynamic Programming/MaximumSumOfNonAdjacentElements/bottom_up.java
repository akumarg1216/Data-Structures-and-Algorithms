import java.util.Arrays;

/**
 * bottom_up
 * The method used is Recursion + Memoization.
 * 
 * 1. Initialize a dp array
 * 2. Store the recursive caLL in the array
 * 3. Initialize the base case
 * 4. Check after base case that dp[n] != -1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) + O(n)
 */
public class bottom_up {

    public static int solveMem(int nums[],int n, int dp[]){

        // base case
        if(n < 0)
            return 0;
        if(n == 0)
            return nums[0];

        if(dp[n]!=-1)
            return dp[n];

        int incl = solveMem(nums,n-2,dp) + nums[n];
        int excl = solveMem(nums, n-1,dp) + 0;

        dp[n] = Math.max(incl, excl);
        return dp[n];
    }

    public static int maximumNonAdjacentSum(int[]nums){
        int n = nums.length;
        int [] dp = new int[n];
        Arrays.fill(dp,0,dp.length,-1);

        int ans = solveMem(nums,n-1,dp);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {9,9,8,2};
        System.out.println(maximumNonAdjacentSum(nums));
    }
}