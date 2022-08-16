/**
 * MergeSort
 */
public class MergeSort {

    public static void merge(int arr[], int start, int end) {

        int mid = start + (end - start) / 2;

        int len1 = mid - start + 1;
        int len2 = end - mid;

        int first[] = new int[len1];
        int second[] = new int[len2];

        // copy values

        int mainArrayIndex = start;
        for (int i = 0; i < len1; i++) {
            first[i] = arr[start + i];
        }

        for (int i = 0; i < len2; i++) {
            second[i] = arr[mid + 1 + i];
        }

        // merge 2 sorted arrays
        int index1 = 0;
        int index2 = 0;

        mainArrayIndex = start;

        while (index1 < len1 && index2 < len2) {
            if (first[index1] <= second[index2]) {
                arr[mainArrayIndex] = first[index1];
                index1++;
            }

            else {
                arr[mainArrayIndex] = second[index2];
                index2++;
            }
            mainArrayIndex++;
        }

        while (index1 < len1) {
            arr[mainArrayIndex++] = first[index1++];
        }

        while (index2 < len2) {
            arr[mainArrayIndex++] = second[index2++];
        }
    }

    public static void mergeSort(int arr[], int start, int end) {

        // base case
        if (start >= end)
            return;

        int mid = start + (end - start) / 2;

        // sort left part ko
        mergeSort(arr, start, mid);

        // right ko sort karo
        mergeSort(arr, mid + 1, end);

        // merge right & left sorted arrays
        merge(arr, start, end);

    }

    public static void main(String[] args) {
        int arr[] = new int[]{ 3, 5, 66, 99, 23, 12, 13, 66, 5, 3, 3, 25, 32, 89, 2 };
        int n = arr.length;

        System.out.println("Array Length: "+n);

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}