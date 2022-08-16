public class squareRootInPrecison {

    public static int integerRoot(int target) {
        int start = 0;
        int end = target;
        int ans = -1;
        int mid = start + (end - start) / 2;

        while (start <= end) {
            int square = mid * mid;
            if (square == target)
                return mid;

            else if (square < target) {
                ans = mid;
                start = mid + 1;
            }

            else
                end = mid - 1;

            mid = start + (end - start) / 2;
        }
        return ans;
    }

    public static double afterDecimal(int n, int precision, int tempSol) {
        double factor = 1;
        double ans = tempSol;

        for (int i = 0; i < precision; i++) {
            factor = factor / 10;

            for (double j = 0; j * j < n; j = j + factor) {
                ans = j;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(afterDecimal(37, 3, integerRoot(37)));
    }

}
