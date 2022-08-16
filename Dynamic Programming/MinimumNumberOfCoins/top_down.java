import java.util.Arrays;

/**
 * top_down approach of the given problem.
 * Here we use recursion + memoization to avoid the overlapping sum problems.
 * 
 * Hence it will not result in TLE.
 * 
 * Time Complexity: O(x*n)
 * Space Complexity: O(x)
 * 
 */
public class top_down {

    public static int solveMem(int[]num, int x, int[] dp){
        //base case
        if(x==0)
            return 0;
        if(x<0)
            return Integer.MAX_VALUE;
        if(dp[x]!=-1)
            return dp[x];
        
        int mincoins = Integer.MAX_VALUE;

        for(int i=0;i<num.length;i++){
            int ans = solveMem(num, x-num[i],dp);
            if(ans!=Integer.MAX_VALUE)
                mincoins = Math.min(mincoins, 1+ans);
        }
        dp[x] = mincoins;
        return dp[x];
    }

    public static int minimumElements(int []num, int x){
        int dp [] = new int[x+1];
        Arrays.fill(dp,0,dp.length,-1);
        int ans = solveMem(num, x, dp);

        if(ans == Integer.MAX_VALUE)
            return -1;
        else
            return ans;
    }
    
    public static void main(String[] args) {
        int num[] = {1,2,5};
        int x = 11;
        System.out.println(minimumElements(num, x));
    }
}