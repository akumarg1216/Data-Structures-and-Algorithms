import java.util.Arrays;

/*
 * best_optimal
 * 
 * Time Complexity: O(n*capacity)
 * Space Complexity: O(w)
 */

public class best_optimal {
    
    public static int bestSoln(int weight[], int[] value, int n, int capacity){

        int [] curr = new int[capacity+1];
        Arrays.fill(curr, 0);
        Arrays.fill(curr, 0);

        for(int w = capacity; w >= 0; w--){
            if(weight[0] <= capacity)
                curr[w] = value[0];
            else
                curr[w] = 0;
        }

        for(int index=1; index<n; index++){
            for(int w=0; w<=capacity; w++){
                int include = 0;

                if(weight[index]<=w)
                    include = value[index] + curr[w-weight[index]];

                int exclude = 0 + curr[w];

                curr[w] = Math.max(include, exclude);
            }
            //curr = curr;
        }
        return curr[capacity];
    }

    public static int knapsack(int weight[], int value[], int n, int maxCapacity){
        return bestSoln(weight, value, n, maxCapacity);
    }

    public static void main(String[] args) {
        int weight [] = {1,2,4,5};
        int value [] = {5,4,8,6};

        System.out.println(knapsack(weight, value, 4, 5));
    }
}
