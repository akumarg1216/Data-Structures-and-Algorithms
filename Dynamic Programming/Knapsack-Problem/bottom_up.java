import java.util.Arrays;

/**
 * bottom_up
 * 
 * Time Complexity: O(n*capacity)
 * Space Complexity: O(n*capacity)
 */
public class bottom_up {

    public static int solveTab(int weight[], int value[], int n, int capacity){

        // step-1: Create dp array
        int dp[][] = new int[n][capacity+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        
        // step-2: analyse base case

        for(int w = weight[0]; w<=capacity; w++){
            if(weight[0]<=capacity)
                dp[0][w] = value[0];
            else
                dp[0][w] = 0;
        }

        for(int index=1; index<n; index++){
            for(int w=0; w<=capacity; w++){
                
                int include = 0;

                if(weight[index]<=w)
                    include = value[index] + dp[index-1][w-weight[index]];
        
                int exclude = 0 + dp[index-1][w];
        
                dp[index][w] = Math.max(include, exclude);
            }
        }
        
        return dp[n-1][capacity];
    }

    public static int knapsack(int weight[], int value[], int n, int maxCapacity){
        
        return solveTab(weight, value, n-1, maxCapacity);
    }

    public static void main(String[] args) {
        int weight [] = {1,2,4,5};
        int value [] = {5,4,8,6};

        System.out.println(knapsack(weight, value, 4, 5));
    }
}