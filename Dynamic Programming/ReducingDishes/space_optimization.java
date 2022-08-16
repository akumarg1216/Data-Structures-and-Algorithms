import java.util.Arrays;

/**
 * space_optimization
 * 
 * Solution giving incorrect output in Java but in C++ it's working fine.
 */

public class space_optimization {

    public static int optimal(int[] satisfaction) {
        int n = satisfaction.length;

        int[] curr = new int[n + 1];
        Arrays.fill(curr, 0);

        int[] next = new int[n + 1];
        Arrays.fill(next, 0);

        for (int index = n - 1; index >= 0; index--) {
            for (int time = index; time >= 0; time--) {

                int include = satisfaction[index] * (time + 1) + next[time + 1];
                int exclude = 0 + next[time];

                curr[time] = Math.max(include, exclude);
            }
            next = curr;
        }
        return next[0];
    }

    public static int maxSatisfaction(int[] satisfaction){
        Arrays.sort(satisfaction);
        return optimal(satisfaction);
    }

    public static void main(String[] args) {
        int [] satisfaction = {-1,-8,0,5,-9};
        System.out.println(maxSatisfaction(satisfaction));
    }
}