/**
 * recursion
 * The problem statement is we have to find the maximum sum from an array without taking the adjacent elements.
 * Example: arr = [9,6,8,2]
 * Sum1 = 9+8 = 17; Sum2 = 9+2 = 11; Sum3 = 6+2 = 8; Sum4 = 2+9 = 11
 * 
 * In this we can observe that each element has 2 choices.
 * (1) If they want to contribute, the adjacent element cannot take part.
 * Hence, in include i=i+2 and sum = sum + nums[i]
 * (2) If they don't want to get included
 * Hence, in exclude i=i+1 and sum = sum+0
 * 
 * The base case can be that:
 * if(n<0) ; return 0 --> the index is less than 0 (traversing from right to left)
 * if(n==0); return nums[0] --> only a single element in the list
 * 
 * Time Complexity: O(2^n) --> exponential time complexity --> Will result in TLE.
 * Space Complexity: O(n) + O(n) --> Requires recursion stack
 */
public class recursion {

    public static int solveRec(int nums[],int n){

        // base case
        if(n < 0)
            return 0;
        if(n == 0)
            return nums[0];

        int incl = solveRec(nums,n-2) + nums[n];
        int excl = solveRec(nums, n-1) + 0;

        return Math.max(incl, excl);
    }

    public static int maximumNonAdjacentSum(int[]nums){
        int n = nums.length;
        int ans = solveRec(nums,n-1);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {9,9,8,2};
        System.out.println(maximumNonAdjacentSum(nums));
    }
}