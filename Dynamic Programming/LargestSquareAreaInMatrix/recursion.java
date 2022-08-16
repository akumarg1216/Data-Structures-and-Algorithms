/**
 * recursion
 * 
 * Given a 2D matrix, our job is to find the largest square possible from the matrix.
 * The matrix only contains 1 & 0.
 * The square is formed only from 1's and not zeros.
 *
 * Time Complexity: O(2^n) // exponential
 * Space Complexity: 
 */
public class recursion {

    public static int solveRec(int [][] mat, int i, int j, int maxi){
        if(i>=mat.length || j >= mat[0].length){
            return 0;
        }

        int right = solveRec(mat, i, j+1, maxi);
        int diagnol = solveRec(mat, i+1, j+1, maxi);
        int down = solveRec(mat, i+1, j, maxi);

        if(mat[i][j]=='1'){
            int ans = 1 + Math.min(right, Math.min(diagnol, down));
            maxi = Math.max(maxi, ans);
            return ans;
        }
        else{
            return 0;
        }
    }

    public static int maxSquare(int n, int m, int [][] mat){
        int maxi = 0;
        solveRec(mat, 0, 0, maxi);
        return maxi;
    }

    public static void main(String[] args) {
        int dp[][] = new int[4][4];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;

        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;

        dp[2][0] = 0;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[2][3] = 1;

        dp[3][0] = 0;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        System.out.println(maxSquare(4,4, dp));
    }
}