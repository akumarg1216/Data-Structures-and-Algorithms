import java.util.*;

public class hi {
    static int[] dp;

    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return recursion(valueInHouse, n - 1);
    }

    public static int recursion(int[] array, int n) {
        if (n <= 1) {
            return array[n];
        }

        if (dp[n] != -1)
            return dp[n];

        int take = array[n];

        if (n - 2 > 0) {
            take += recursion(array, n - 2);
        }

        int not_take = recursion(array, n - 1);
        return dp[n] = Math.max(take, not_take);
    }
}