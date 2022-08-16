public class getPivot {
    
    public static int pivotElement(int arr[], int n){
        int start = 0;
        int end = n-1;

        int mid = start + (end - start)/2;

        while(start < end){
            if(arr[mid] >= arr[0]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
            mid = start + (end - start)/2;
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = {8,10,17,1,3};
        System.out.println(pivotElement(arr, 5));
    }
}
