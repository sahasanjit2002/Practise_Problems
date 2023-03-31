import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
public class BubbleSort {
    public static void swap(int arr[],int i,int j){
        int t = arr[j];
        arr[j] = arr[i];
        arr[i]=t;
    }
    public static void bubbleSort(int arr[]){
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j+1,j);
                }
            }
        }
    }
    public static void display(int arr[]){
        System.out.println("");
        System.out.print("[ ");
        for(int element:arr){
            System.out.print(element + " , ");
        }
        System.out.println(" ]");
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
    public static void main(String[] args){

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
        bubbleSort(arr);
        System.out.print("Final Array :  ");
        display(arr);
        fileWrite(arr,"Bubble Sort");

    }
}
