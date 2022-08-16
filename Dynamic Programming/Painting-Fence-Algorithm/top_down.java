import java.util.Arrays;
import java.util.Scanner;

/**
 * top_down
 */
public class top_down {

    public static int solveMem(int n , int k, int dp[]){

        // base case
        if(n == 1)
            return k;
        if(n == 2)
            return k + k*(k-1);

        if(dp[n]!= -1)
            return dp[n];

        dp[n] = solveMem(n-2, k, dp) * (k-1) + solveMem(n-1, k, dp) * (k-1);

        return dp[n];
    }

    public static int numberOfWays(int n, int k){
        int dp [] = new int [n+1];
        Arrays.fill(dp, -1);
        
        return solveMem(n, k, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        sc.close();

        System.out.println(numberOfWays(n, k));
    }
}