import java.util.Arrays;

/**
 * aggressiveCows
 */
public class aggressiveCows {

    public static boolean isPossible(int stalls[], int k, int mid){
        
        int cowCount = 1;
        int lastPos = stalls[0];

        for(int i=0; i<stalls.length; i++){
            if(stalls[i]-lastPos >= mid){
                cowCount++;
                if(cowCount == k){
                    return true;
                }
                lastPos = stalls[i];
            }
        }
        return false;
    }

    public static int solution(int []stalls, int k){
        Arrays.sort(stalls);

        int start = 0;
        int maxi = -1;
        for(int i=0; i<stalls.length; i++){
            maxi = Math.max(maxi,stalls[i]);
        }
        int end = maxi;
        int ans = -1;
        int mid = start + (end - start)/2;

        while(start <= end){
            if(isPossible(stalls, k, mid)){
                ans = mid;
                start = mid+1;
            }
            else{
                end = mid - 1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int stalls[] = {1,2,4,3,6};
        int k = 2;
        System.out.println(solution(stalls, k));
    }
}