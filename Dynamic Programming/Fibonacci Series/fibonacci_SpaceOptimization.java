import java.util.Scanner;

/*
 * If we observe clearly we see that the fibonacci number is always the sum of previous 2 numbers.
 * Hence we don't need to maintain an array of size n.
 * We can declare 2 variables that stores the previous 2 elements and summing up them we can find the next element needed.
 * We update the prev2 to prev1 & prev1 to currrent element to find  the next one.
 * Hence we can solve this without using any extra spaces.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * This space complexity is the best than the Top_Down approach used which had the worst space complexity and also from the Bottom-Up which had better time complexity than the top-down approach.
 */

public class fibonacci_SpaceOptimization {
    
    public static int result(int n) {
        int prev1 = 1;
        int prev2 = 0;
        if(n==0)
            return prev2;
        for (int i=2;i<=n;i++){
            int currrent = prev1 + prev2;
            prev2 = prev1;
            prev1 = currrent;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter terms: ");
        int n = sc.nextInt();
        sc.close();
        System.out.println(result(n));
    }
}
