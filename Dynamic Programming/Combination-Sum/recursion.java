/**
 * recursion
 * 
 * Given an array of n elements and a target value. Find the number of ways in which the target can be achieved by summing the elements in array.
 * 
 * Time Complexity: 
 * Space Complexity: 
 */
public class recursion {

    public static int solveRec(int num[], int target){

        // base case
        if(target < 0)
            return 0;
        if(target == 0)
            return 1;

        int ans = 0;
        for(int i=0; i<num.length; i++){
            ans = ans + solveRec(num, target-num[i]);
        }
        return ans;
    }

    public static int findWays(int num[], int target){
        return solveRec(num, target);
    }

    public static void main(String[] args) {
        int arr[] = {1,2,5};
        int target = 3;
        int arr1[] = {3,4,5,6};
        int target1 = 15;
        System.out.println(findWays(arr, target));
        System.out.println("=========================");
        System.out.println(findWays(arr1, target1));
    }
}