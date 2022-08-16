public class squareRootUsingBinarySearch {
    
    public static int root(int target){
        int start = 0;
        int end = target;
        int ans = -1;
        int mid = start + (end - start)/2;

        while(start <= end){
            int square = mid * mid;
            if(square == target)
                return mid;
            
            else if(square < target){
                ans = mid;
                start = mid + 1;
            }
            
            else
                end = mid - 1;

            mid = start + (end - start)/2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(root(144));
    }
}
