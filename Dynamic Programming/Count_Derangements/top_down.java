import java.util.Arrays;
import java.util.Scanner;

/**
 * top_dowm
 */
public class top_down {

    public static int solveMem(int n, int dp[]){
        // base case
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;

        if(dp[n]!= -1)
            return dp[n];

        dp[n] = (n-1) * (solveMem(n-1,dp) + solveMem(n-2,dp));
        return dp[n];
    }

    public static int countDerangments(int n){
        int dp [] = new int[n+1];
        Arrays.fill(dp, -1);
        return solveMem(n,dp);
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