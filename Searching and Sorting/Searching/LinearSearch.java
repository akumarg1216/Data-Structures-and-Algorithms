/**
 * LinearSearch
 */
public class LinearSearch {

    public static void search(int arr[], int key){
        
        int start = 0;
        int n = arr.length;
        int end = n-1;
        int position = -1;

        for(start = 0; start <= end;){
            if(arr[start] == key){
                position = start;
                System.out.println("Element at position " + (position+1));
                break;
            }

            if(arr[end] == key){
                position = end;
                System.out.println("Element at position: " + (position+1));
                break;
            }
            start++;
            end--;
        }

        if(position == -1){
            System.out.println("Element " + key + " not found");
        }
    }

    public static void main(String[] args) {
        int dp[] = new int[] {32,48,79,90,29};
        search(dp, 90);
        search(dp, 110);
        search(dp, 29);
    }
}