/**
 * recursion
 * 
 * Question Description:  https://leetcode.com/problems/minimum-sideway-jumps/
 */
public class recursion {

    public static int solveRec(int[] obstacles, int currlane, int currpos){
        
        // base case
        int n = obstacles.length - 1;
        if(currpos == n)
            return 0;
        
        if(obstacles[currpos+1] != currlane){
            // forward movement
            return solveRec(obstacles, currlane, currpos+1);
        }
        
        else{
            // sideway jump
            int ans = Integer.MAX_VALUE;
            for(int i=1; i<=3; i++){
                if(currlane != i && obstacles[currpos] != i)
                    ans = Math.min(ans, 1+solveRec(obstacles, i, currpos));
            }
            return ans;
        }
    }
    
    public int minSideJumps(int[] obstacles) {
        return solveRec(obstacles, 2, 0);
    }
}