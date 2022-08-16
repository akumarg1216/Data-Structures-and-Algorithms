/**
 * recursion
 * 
 * Given n items with their weght & values a thief with a bag of a certain capacity needs to rob items that will give him the maximum profit after selling the items.
 * 
 * Note: The weight of items cannot exceed the weight the bag can carry.
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n*w)
 * 
 */
public class recursion {

    public static int solveRec(int weight[], int value[], int index, int capacity){

        // base case
        // traversing from right to left

        if(index == 0){
            if(weight[0]<=capacity)
                return value[0];
            else
                return 0;
        }

        int include = 0;
        if(weight[index]<=capacity)
            include = value[index] + solveRec(weight, value, index-1, capacity-weight[index]);

        int exclude = 0 + solveRec(weight, value, index-1, capacity);

        int ans = Math.max(include, exclude);

        return ans;
    }

    public static int knapsack(int weight[], int value[], int n, int maxCapacity){
        return solveRec(weight, value, n-1, maxCapacity);
    }

    public static void main(String[] args) {
        int weight [] = {1,2,4,5};
        int value [] = {5,4,8,6};

        System.out.println(knapsack(weight, value, 4, 5));
    }
}