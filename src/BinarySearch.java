import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class BinarySearch {
    public static int binarySearchIterative(int arr[],int key){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    public static int binarySearchRecursive(int arr[],int key,int start,int end){
        if(start<=end){
            int mid = (start + end) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                return binarySearchRecursive(arr,key,mid+1,end);
            } else {
                return binarySearchRecursive(arr,key,start,mid-1);
            }
        }
        return -1;
    }
    public static void fileInput(String data[]){
        try {
            // file read
            File file = new File("arrays.txt");
            Scanner sc = new Scanner(file);
            int count = 0;
            while (sc.hasNextLine()) {
                String tempData = sc.nextLine();
                // have a line which states 'end of input' to signify the end of input
                if (tempData.equals("end of input")) {
                    break;
                } else {
                    data[count] = tempData;
                    count++;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        //input filtering section
        String data[] = new String[3];
        fileInput(data);
        int start = data[1].indexOf("[");
        int end = data[1].indexOf("]");
        String stringInputArray[] = (data[1].substring(start+1,end)).split(",");
        int arr[] = new int[stringInputArray.length],index =0;
        for (String s:stringInputArray){
            arr[index++] = Integer.parseInt(s);
        }
        int key = Integer.parseInt(data[2].substring(data[2].indexOf("=")+1, data[2].length()));
        //end of input section

        //binary search
        int result = binarySearchRecursive(arr,key,0,arr.length-1);
        if(result > 0 ) {
            System.out.println("Search Found at index: " + result);
        }else{
            System.out.println("Search not found");
        }
    }
}
