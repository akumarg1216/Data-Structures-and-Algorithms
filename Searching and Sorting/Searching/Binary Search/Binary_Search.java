/**
 * Binary_Search
 * 
 * Time Complexity: O(log N)
 * 
 */
public class Binary_Search {

    public static int binarySearch(int arr[], int n, int key){
        int start = 0;
        int end = n-1;

        int mid = start + (end-start)/2;    
        // equivalent to (start+end)/2 --> did this to handle integer overflow. If max range start + max range int will combine then it will lead to integer overflow.

        while(start <= end){
            if(arr[mid] == key)
                return mid;
            
            if(key > arr[mid])
                start = mid + 1;
            
            else
                end = mid - 1;

            mid = start + (end - start)/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,3,10,19,28,89};
        System.out.println(binarySearch(arr, arr.length,89));
        System.out.println(binarySearch(arr, arr.length,95));
    }
}