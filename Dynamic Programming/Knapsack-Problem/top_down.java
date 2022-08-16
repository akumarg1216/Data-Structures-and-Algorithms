import java.util.Arrays;

/**
 * top_down
 * 
 * Time Complexity: O(n*capacity)
 * Space Complexity: O(n*capacity)
 */
public class top_down {

    public static int solveMem(int weight[], int value[], int index, int capacity, int [][]dp){

        // base case
        // traversing from right to left

        if(index == 0){
            if(weight[0]<=capacity)
                return value[0];
            else
                return 0;
        }

        if(dp[index][capacity] != -1)
            return dp[index][capacity];

        int include = 0;
        if(weight[index]<=capacity)
            include = value[index] + solveMem(weight, value, index-1, capacity-weight[index],dp);

        int exclude = 0 + solveMem(weight, value, index-1, capacity, dp);

        dp[index][capacity] = Math.max(include, exclude);

        return dp[index][capacity];
    }

    public static int knapsack(int weight[], int value[], int n, int maxCapacity){
        int dp[][] = new int[n][maxCapacity+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return solveMem(weight, value, n-1, maxCapacity, dp);
    }

    public static void main(String[] args) {
        int weight [] = {1,2,4,5};
        int value [] = {5,4,8,6};

        System.out.println(knapsack(weight, value, 4, 5));
    }
}