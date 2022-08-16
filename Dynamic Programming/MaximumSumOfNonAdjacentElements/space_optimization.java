/**
 * space_optimization
 * 
 * We can see the current element depends on 2 factor, i.e. dp[i-2] & dp[i-1]
 * Hence we can optimize this solution to O(1) by using 2 variables.
 * prev2 = 0 and prev1 = nums[0]
 * We will update the values after each calculation.
 */
public class space_optimization {

    public static int optimize(int nums[]){
        int n = nums.length;

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1; i<n; i++){
            int incl = prev2 + nums[i];
            int excl = prev1 + 0;

            int ans = Math.max(incl,excl);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    public static int maximumNonAdjacentSum(int[]nums){
        return optimize(nums);
    }

    public static void main(String[] args) {
        int nums[] = {10,11,12,13,14};
        System.out.println(maximumNonAdjacentSum(nums));
    }
}