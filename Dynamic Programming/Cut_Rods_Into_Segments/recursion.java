/*
 * recursion
 * In this problem we are given a rod of length 'N' and 3 segments 'X' , 'Y' & 'Z'.
 * We have to make the maximum segments poosible using the whole length of the rod.
 * 
 * Example: N=7 , X=5, Y=2, Z=2
 * 
 * Now: first case is X+Y = 7; X+Z = 7; Z+X=7; Y+X=7;
 * Hence the otput = 2
 * 
 * Example: N=8, X=Y=Z = 3
 * 
 * No sum of X||Y||Z gives us 8
 * Hence, output = 0
 *
 * Time Complexity: O(2^n) // TLE in competitive programming.
 * Space Complexity: O(n) // for recursion stack
 * 
 */
public class recursion {

    public static int solveRec(int n, int x, int y, int z){

        // base case
        if(n == 0) // length of rod = 0
            return 0;

        if(n < 0) //suppose only 2 m of rod is left & value of x = 5. In that case the n will become -3 (negative).
            return Integer.MIN_VALUE;
        
        int a = solveRec(n-x, x, y, z) + 1; //implies that x length is used & n-x length is left and 1 because x is also a segment that is cut out at first.
        int b = solveRec(n-y, x, y, z) + 1; //implies that y length is used & n-x length is left and 1 because y is also a segment that is cut out at first.
        int c = solveRec(n-z, x, y, z) + 1; //implies that z length is used & n-x length is left and 1 because z is also a segment that is cut out at first.

        int ans =  Math.max(a, Math.max(b,c));
        return ans;
    }
    
    public static int cutSegments(int n, int x, int y, int z){
        int ans = solveRec(n, x, y, z);
        if(ans < 0)
            return 0;
        else
            return ans;
    }
    
    public static void main(String[] args) {
        int n = 7;
        int x = 5;
        int y = 2;
        int z = 5;
        System.out.println(cutSegments(n, x, y, z));
    }
}