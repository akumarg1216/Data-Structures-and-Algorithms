/**
 * The problem states that we are given an array which denotes the coins we curently have.
 * Eg: int [] coins = {1,2,5} --> We have got coins of denomination 2,5 & 10 in infinite numbers.
 * 
 * We are given a target & we have to make the target sum using the minimum number of coins of denomination present with us.
 * 
 * Cases: Target = 11
 * Case I: 1*11 --> 11 coins
 * Case II: 2*5 + 1*1 --> 6 coins
 * Case III: 5*2 + 1*1 --> 3 coins
 * 
 * Moreover the cases like 
 * if target = 3 and coins = [2] then target is not possible; return -1
 * If target = 0; coins needed = 0
 * 
 * Time Complexity: O(2^n) // will result in TLE in competitive programming.
 * Space Complexity: O(n) + O(n)
 */ 
public class recursion {

    public static int minimumElements(int []num, int x){
        int ans = solveRec(num,x);
        if(ans==Integer.MAX_VALUE)
            return -1;
        return ans;
    }

    private static int solveRec(int[]num, int x){
        
        //base case
        if(x==0)
            return 0;
        if(x<0)
            return Integer.MAX_VALUE;
        
        int mincoins = Integer.MAX_VALUE;
        for (int i=0; i<num.length;i++){
            int ans = solveRec(num, x-num[i]);
            if(ans != Integer.MAX_VALUE)
                mincoins = Math.min(mincoins, 1+ans);
        }
        return mincoins;
    }

    public static void main(String[] args) {
        int [] num = {1,2,5};
        int x = 11;
        System.out.println(minimumElements(num, x));
    }
}