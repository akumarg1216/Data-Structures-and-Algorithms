import java.util.Arrays;

/**
 * space_optimization
 * 
 * Time Complexity: O(n*capacity)
 * Space Complexity: O(2*capacity)
 */
public class space_optimization {

    public static int optimum(int[] weight, int[] value, int n, int capacity){

        int [] prev = new int[capacity+1];
        int [] curr = new int[capacity+1];
        Arrays.fill(prev, 0);
        Arrays.fill(curr, 0);

        for(int w = weight[0]; w <= capacity; w++){
            if(weight[0] <= capacity)
                prev[w] = value[0];
            else
                prev[w] = 0;
        }

        for(int index=1; index<n; index++){
            for(int w=0; w<=capacity; w++){
                int include = 0;

                if(weight[index]<=w)
                    include = value[index] + prev[w-weight[index]];

                int exclude = 0 + prev[w];

                curr[w] = Math.max(include, exclude);
            }
            prev = curr;
        }
        return prev[capacity];
    }

    public static int knapsack(int weight[], int value[], int n, int maxCapacity){
        return optimum(weight, value, n, maxCapacity);
    }

    public static void main(String[] args) {
        int weight [] = {1,2,4,5};
        int value [] = {5,4,8,6};

        System.out.println(knapsack(weight, value, 4, 5));
    }
}