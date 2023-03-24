import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int arr[],int start,int end){ // [1,7,10,5,9,10,45,11]

        int pivot = arr[end];
        int i = (start - 1);
        for(int j = start;j<end;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,end);
        return(i+1);

    }
    public static void quickSort(int arr[],int start,int end){
        if(start<end){
            int pi = partition(arr, start, end);
            quickSort(arr, start, pi-1);
            quickSort(arr, pi+1, end);
        }
    }
    public static void main(String[] arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of array ");
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n-1);
        System.out.println("\n "+ Arrays.toString(arr));
    }
}
