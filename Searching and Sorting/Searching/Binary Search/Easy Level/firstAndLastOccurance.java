public class firstAndLastOccurance {
    
    public static int firstOccurance(int arr[], int n, int key){
        int start = 0, end = n-1;
        int mid = start + (end-start)/2;
        int ans = -1;

        while(start <= end){
            if(arr[mid]==key){
                ans = mid;
                end = mid - 1;
            }

            else if(key > arr[mid]){
                start = mid + 1;        // move to right of mid.
            }

            else if(key < arr[mid])
                end = mid - 1;          // move to left of mid in array.

        mid = start + (end - start)/2;
        }
        return ans;
    }

    public static int lastOccurance(int arr[], int n , int key){
        int start = 0, end = n-1, ans = -1;
        int mid = start + (end-start)/2;

        while(start <= end){
            if(arr[mid] == key){
                ans = mid;
                start = mid + 1;
            }
            else if(key > arr[mid])
                start = mid + 1;          //right me jaao

            else if(key < arr[mid])
                end = mid -1;              // left me jaao
        mid = start + (end - start)/2;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int arr [] = {1,3,3,4,5,5,5,5,8,10};
        int n = arr.length;
        int key = 5;
        int a = firstOccurance(arr, n, key);
        int b = lastOccurance(arr, n, key);

        System.out.println("First Occurance: " + a + " Last Occurance: " + b);
    }
}
