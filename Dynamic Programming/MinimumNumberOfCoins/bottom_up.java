import java.util.Arrays;

/*
 * bottom_up
 * This approach is based on the for & while loops
 * This the tabulation method.
 * 
 * Time Complexity: O(x*n)
 * Space Complexity: O(x)
 */

public class bottom_up {

    public static int solveTab(int num[], int x){
        int dp[] = new int [x+1];
        Arrays.fill(dp, 0, dp.length, Integer.MAX_VALUE);
        
        dp[0] = 0;
        for(int i=1; i<=x; i++){
            for (int j=0; j<num.length;j++){
                if(i-num[j]>=0 && dp[i-num[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],1+dp[i-num[j]]);
                }
            }
        }
        
        if(dp[x] == Integer.MAX_VALUE)
            return -1;
        return dp[x];
    }
    public static int minimumElements(int num[],int x){
        return solveTab(num, x);
    }

    public static void main(String[] args) {
        int num[] = {1,2,3};
        int x = 7;
        System.out.println(minimumElements(num, x));
    }
}