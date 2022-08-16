/**
 * hi
 */
public class searchInRotatedSortedArray {

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

    public static int binarySearch(int arr[], int s, int e, int key){
        int start = s;
        int end = e;

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

    public static int findPosition(int arr[], int n, int k){
        int pivot = pivotElement(arr, n);
        int key = k;

        if(k >= arr[pivot] && k <= arr[n-1])
            return binarySearch(arr, pivot, n-1, key);          // Binary Search on 2nd line
        else
            return binarySearch(arr, 0, pivot-1, key);      // Binary Search on 1st line
    }

    public static void main(String[] args) {
        int arr[] = {7,8,1,3,5};
        System.out.println(findPosition(arr, arr.length, 5));
    }
}