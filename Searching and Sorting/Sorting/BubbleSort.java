/**
 * BubbleSort
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){

        int n = arr.length;
        int temp;
        boolean swapped = false;
        for(int i = 1; i < n; i++){         // for round 1 to n-1
            
            for(int j = 0; j < n-i; j++){   
                // we need to go only until n-i th index; since all elements are sorted after that index.
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;       // indicates that if the array elements gets sorted in between no need for further rounds.
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 7, 6, 14, 9};
        bubbleSort(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }
}