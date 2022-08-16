/*
 * This is the bottom up approach for the fibonacci number series.
 * In this we calculate the values without going into recursion.
 * This is called the tabulation method in DP.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * This space complexity is better than the Top_Down approach used.
 */

import java.util.Scanner;

public class fibonacci_bottomUp {
    
    public static void main(String[] args) {
        int n,i;
        Scanner sc = new Scanner(System.in);
        System.out.print("Term: ");
        n = sc.nextInt();
        sc.close();
        int values [] = new int[n];
        values[0] = 0;
        values[1] = 1;

        for(i=2;i<n;i++){
            values[i] = values[i-1] + values[i-2];
        }
        System.out.println("The " + n + "th fibonacci number is " + values[n-1]);
    }
}
