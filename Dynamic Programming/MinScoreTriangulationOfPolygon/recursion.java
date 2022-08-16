/**
 * recursion
 * 
 * Question Description: https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 * 
 * Time Complexity: O(2^n) // TLE
 * Space Complexity: 
 */
public class recursion {

    public static int solveRec(int v[], int i, int j){

        // base case
        // i is the first node & j is the last. i+1=j indicates that only 2 nodes are present and a triangle cannot be created using only 2 nodes.
        if(i+1 == j)
            return 0;
        
        int ans = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++){
            ans = Math.min(ans, v[i]*v[j]*v[k] + solveRec(v, i, k) + solveRec(v, k, j));
        }
        return ans;        
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        return solveRec(values,0,n-1);
    }
}