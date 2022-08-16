import java.util.Arrays;
import java.util.Scanner;

/**
 * bottom_up
 */
public class space_optimization {

    public static int final_result(int n , int k){

        int dp [] = new int [n+1];
        Arrays.fill(dp, -1);

        // base case
        // if(n == 1)
        //     return k;
        // if(n == 2)
        //     return k + k*(k-1);

        int prev2 = k;
        int prev1 = k + k*(k-1);

        for (int i=3; i<=n; i++){
            int ans = prev2 * (k-1) + prev1 * (k-1);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    public static int numberOfWays(int n, int k){
        return final_result(n, k);
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