public class QuickSort {

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int partition(int arr[], int start, int end){

        int pivot = arr[end];
        int i = start - 1;

        for(int j = start; j <= end; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr,i ,j);
            }
        }
        swap(arr,i+1,end);
        return (i+1);
    }

    public static void quickSort(int arr[], int start, int end){

        // base case
        if(start >= end)
            return;

        // partition karo
        int p = partition(arr, start, end);

        // left part ko sort karo
        quickSort(arr, start, p-1);

        // right part ko sort karo
        quickSort(arr, p+1, end);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{36, 54, 18, 72, 9};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
