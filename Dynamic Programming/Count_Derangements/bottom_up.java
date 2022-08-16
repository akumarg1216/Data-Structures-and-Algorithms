import java.util.Arrays;
import java.util.Scanner;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int n){
        int dp [] = new int[n+1];
        Arrays.fill(dp, -1);

        dp[1] = 0;
        dp[2] = 1;

        //int ans = (n-1) * (solveMem(n-1,dp) + solveMem(n-2,dp)); // from recursion + memoization

        for(int i=3; i<=n; i++){
            int ans = (i-1) * (dp[i-1] + dp[i-2]);
            dp[i] = ans;
        }
        return dp[n];
    }

    public static int countDerangments(int n){
        return solveTab(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();

        int arr [] = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }

        System.out.println(countDerangments(n));
    }
}