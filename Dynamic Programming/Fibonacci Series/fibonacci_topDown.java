/*
 * There are 2 types of approach in Dynamic Programming
 * (1) Top - Down Approach
 * (2) Bottom - Up Approach
 * (3) Space Optimization
 * 
 * In top-down approach the process is to use recursion + memoization.
 * In this we declare a 1-D array of n+1 size & assign every value as -1 to it.
 * We calculate the f(2) & f(3) .... and assign the values in the 1-D array created.
 * Next time we encounter a value, we first search that in the array.
 * If the value != -1, then we instead of going deep in to recursion stack take the value from the array and use it for further calculations.
 * At a point of time we get the value needed.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n) + O(n) --> For going into recursion stack O(n) & traverse array --> O(n).
 * 
 * This space complexity is worse among the approaches used.
 */

import java.util.Scanner;

/**
 * fibonacci_topDown
 */
public class fibonacci_topDown {

    static int values [] = new int[1000];

    public static int fibo(int n){
        if(n==1){
            return values[0];
        }
        if(n==2){
            return values[1];
        }
        else{
            values[n-1] = fibo(n-1) + fibo(n-2);
            return values[n-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter term: ");
        int n = sc.nextInt();
        sc.close();
        values[0] = 0;
        values[1] = 1;
        System.out.println(fibo(n));
    }
}