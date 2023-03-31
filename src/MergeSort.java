import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void merge(int arr[],int beg,int mid,int end){
        int leftSubArrayLength = (mid-beg)+1;
        int rightSubArrayLength = (end-mid);
        int i,j,k;
        int leftSubArray[] = new int[leftSubArrayLength];
        int rightSubArray[] = new int[rightSubArrayLength];
        // copy the elements from main array to the left and right sub arrays
        for(i = 0;i<leftSubArrayLength;i++){
            leftSubArray[i] = arr[beg+i];
        }
        for(j = 0;j<rightSubArrayLength;j++){
            rightSubArray[j] = arr[mid+1+j];
        }
        i=0;j=0;
        k=beg;
        while (i<leftSubArrayLength && j<rightSubArrayLength){
            if(leftSubArray[i]<=rightSubArray[j]){
                arr[k] = leftSubArray[i];
                i++;
            }else{
                arr[k] = rightSubArray[j];
                j++;
            }
            k++;
        }
        while(i<leftSubArrayLength){
            arr[k]=leftSubArray[i];
            k++;i++;
        }
        while(j<rightSubArrayLength){
            arr[k] = rightSubArray[j];
            k++;j++;
        }
    }
    public static void mergerSort(int arr[],int beg,int end){
        if(beg<end){
            int mid = (beg+end)/2;
            mergerSort(arr,beg,mid);
            mergerSort(arr,mid+1,end);
            merge(arr,beg,mid,end);
        }
    }
    public static void display(int arr[]){
        System.out.println("");
        System.out.print("[ ");
        for(int element:arr){
            System.out.print(element + " , ");
        }
        System.out.print(" ]");
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
    public static void fileWrite(int arr[],String message) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDateTime = currentDateTime.format(formatter);
        try{
            File file = new File("arrays.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.append("\n");
            fileWriter.append("Generated on : "+formattedDateTime+"  ");
            fileWriter.append(message+" : ");
            fileWriter.append((Arrays.toString(arr)));
            fileWriter.close();
        }catch(IOException e){
            System.out.print("And Error Occurred during execution of the program : ");
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        String data[] = new String[3];
        fileInput(data);
        int start = data[0].indexOf("[");
        int end = data[0].indexOf("]");
        String stringInputArray[] = (data[0].substring(start+1,end)).split(",");
        int arr[] = new int[stringInputArray.length],index =0;
        for (String s:stringInputArray){
            arr[index++] = Integer.parseInt(s);
        }

        System.out.print("Initial Array :  ");
        display(arr);
        mergerSort(arr,0, arr.length-1);
        System.out.print("Final Array :  ");
        display(arr);

        fileWrite(arr,"Merge Sort");
    }
}
