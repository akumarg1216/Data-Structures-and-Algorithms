import java.util.Arrays;

/**
 * recursion
 * 
 * Question Description: https://leetcode.com/problems/reducing-dishes/
 */
public class recursion {

    public static int solveRec(int[] satisfaction, int index, int time){
        
        // base case
        if(index == satisfaction.length)
            return 0;
        
        int include = satisfaction[index] * (time+1) + solveRec(satisfaction, index+1, time+1);
        int exclude = 0 + solveRec(satisfaction, index+1, time);
            
        return Math.max(include, exclude);
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return solveRec(satisfaction, 0, 0);
    }
}