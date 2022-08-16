import java.util.Scanner;

/**
 * recursion
 * 
 * We are given --> n & k. 
 * n denotes the number of fences
 * k denotes the number of colors.
 * 
 * we have to return the number of ways the fences can be painted considering that no two adjacent fences have the same color.
 * 
 * Colors = R,G,B // let us assume
 * 
 * If n=1; k = 3; no of ways = k; // base case 1
 * 
 * If n=2; k = 3; no of ways = RR, GG, BB, RG, RB, BR, BG, GR, GB ==> 9 ==> k + k(k-1) ==> k^2
 * 
 * The fences can be painted considering the last 2 fences are of same color: 
 *            solve(n-2) * (k-1)
 * 
 * The fences can be painted considering the last 2 fences are of different colors:
 *            solve(n-1) * (k-1)
 */
public class recursion {

    public static int solveRec(int n, int k){

        // base case
        if(n == 1)
            return k;

        if(n == 2)
            return k + (k*(k-1));

        int ans = solveRec(n-2, k) * (k-1) + solveRec(n-1, k) * (k-1);
        return ans;
    }
    
    public static int numberOfWays(int n, int k){
        return solveRec(n, k);
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