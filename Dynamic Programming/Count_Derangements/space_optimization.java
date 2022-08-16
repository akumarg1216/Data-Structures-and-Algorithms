import java.util.Scanner;

/**
 * space_optimization
 */
public class space_optimization {

    public static int final_result(int n){
        int prev2 = 0;
        int prev1 = 1;

        for(int i=3; i<=n; i++){
            int ans = (i-1) * (prev1 + prev2);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    public static int countDerangments(int n){
        return final_result(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        sc.close();

        int arr [] = new int [n];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }

        System.out.println(countDerangments(n));
    }
}