/**
 * SelectionSort
 *
 */
public class SelectionSort {

    public static void selectionSort(int arr[], int n){
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;

            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            int smallerNumber = arr[minIndex];   
            arr[minIndex] = arr[i];  
            arr[i] = smallerNumber;           
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,6,8,10,4};
        int arr2[] = {2,0,7,19,97,99};
        selectionSort(arr, arr.length);
        selectionSort(arr2, arr2.length);

        for(int i: arr)
            System.out.print(i+ " ");

        System.out.println();
        System.out.println("*************************************************************");

        for(int i: arr2)
            System.out.print(i + " ");
    }
}