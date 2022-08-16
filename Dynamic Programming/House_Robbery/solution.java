import java.util.ArrayList;

/**
 * solution
 */
public class solution {

    public static int solve(ArrayList<Integer> nums){
        int n = nums.size();

        int prev2 = 0;
        int prev1 = nums.get(0);

        for(int i=1; i<n; i++){
            int incl = prev2 + nums.get(i);
            int excl = prev1 + 0;

            int ans = Math.max(incl, excl);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    public static int houseRobber(int [] valueInHouse){

        int n = valueInHouse.length;

        if(n==1)
            return valueInHouse[0];

        ArrayList <Integer> first = new ArrayList<>();
        ArrayList <Integer> second = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(i != n-1)
                first.add(valueInHouse[i]);

            if(n!=0)
                second.add(valueInHouse[i]);
        }

        return Math.max(solve(first), solve(second));
    }

    public static void main(String[] args) {
        int [] valueInHouse = {1,2,3,4,5,6};
        System.out.println(houseRobber(valueInHouse));
    }
}