/**
 * peakIndexInMountainArray
 */
public class peakIndexInMountainArray {

    public static int peakIndex(int arr[]){
        int start = 0;
        int end = arr.length -1;

        int mid = start + (end - start)/2;

        while(start < end){
            System.out.println("Mid: "+mid);
            System.out.println("Start: "+start);
            if(arr[mid] < arr[mid+1])
                start = mid + 1;
            else
                end = mid;

            mid  = start + (end - start)/2;
        }
        return start;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,4,8,9,10,6,3,2,0};
        System.out.println(peakIndex(arr));
    }
}