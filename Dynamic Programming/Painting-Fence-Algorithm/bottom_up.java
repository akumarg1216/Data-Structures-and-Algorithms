import java.util.Arrays;
import java.util.Scanner;

/**
 * bottom_up
 */
public class bottom_up {

    public static int solveTab(int n , int k){

        int dp [] = new int [n+1];
        Arrays.fill(dp, -1);

        // base case
        // if(n == 1)
        //     return k;
        // if(n == 2)
        //     return k + k*(k-1);

        dp[1] = k;
        dp[2] = k + k*(k-1);

        for (int i=3; i<=n; i++){
            dp[i] = dp[i-2] * (k-1) + dp[i-1] * (k-1);
        }

        return dp[n];
    }

    public static int numberOfWays(int n, int k){
        return solveTab(n, k);
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