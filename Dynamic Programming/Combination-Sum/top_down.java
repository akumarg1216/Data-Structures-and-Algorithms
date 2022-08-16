import java.util.Arrays;

/**
 * top_down
 */
public class top_down {

    public static int solveMem(int num[], int target, int dp[]){

        // base case
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;

        if (dp[target] != -1)
            return dp[target];

        int ans = 0;

        for(int i=0; i<num.length; i++){
            ans += solveMem(num, target-num[i],dp);
        }
        dp[target] = ans;
        return dp[target];
    }

    public static int findWays(int num[], int target){

        int dp[] = new int[target+1];
        Arrays.fill(dp, -1);
        return solveMem(num, target,dp);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5};
        int target = 3;
        int arr1[] = {3,4,5,6};
        int target1 = 15;
        System.out.println(findWays(arr, target));
        System.out.println("=========================");
        System.out.println(findWays(arr1, target1));
    }
}