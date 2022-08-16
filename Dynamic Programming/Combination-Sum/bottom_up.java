import java.util.Arrays;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int num[], int target){

        int dp[] = new int [target+1];
        Arrays.fill(dp, 0);

        dp[0] = 1;
        
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < num.length; j++){
                if(i-num[j] >= 0){
                    dp[i] += dp[i-num[j]];
                }
            }
        }

        return dp[target];
    }


    public static int findWays(int num[], int target){
        return solveTab(num, target);
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