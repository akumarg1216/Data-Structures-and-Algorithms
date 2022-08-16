import java.util.Scanner;

/**
 * recursion
 * 
 * The problem states that we have an array and we have to place elements in such a way that none of them exists at their own index.
 * 
 * For example : {1,2,3,4} --> D1: {4,3,2,1} --> D2: {2,1,4,3} .....
 * 
 * We have to count the number of derangements possible for a given array.
 * 
 * If element is 1: derangments = 0; if elements are 2 in number: derangemensts = 1 // base cases
 * 
 * Also following above array: 1 can be placed at 4's position & vice versa ---> swapped --> (n-2) numbers left & (n-2) indexes left
 * 
 * But if 1 is placed in 4's position but 4 is not in 1's then there are (n-1) indexes left & (n-1) numbers left to be arranged.
 * 
 * The input is N => if N=2 ; array = {0,1} & if N=7 => array: {0,1,2,3,4,5,6}.
 * 
 * Time Complexity: O(2^n) // TLE
 * Space Complexity: O(n) + O(n)
 */
public class recursion {

    public static int solveRec(int n){
        
        // base case
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        
        int ans = (n-1) * (solveRec(n-1) + solveRec(n-2));

        return ans;
    }

    public static int countDerangments(int n){
        return solveRec(n);
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