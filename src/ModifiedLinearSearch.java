import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ModifiedLinearSearch {
    public static int modifiedLinearSearch(int arr[],int key){
        int start = 0;
        int end = arr.length - 1;
        int index = 0;
        while((index<arr.length)&&(arr[index]<key))
        {
            index++;
        }
        if((index<arr.length)&&(arr[index]==key)){
            return index;
        }
        else{
            return -1;
        }
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
        int result = modifiedLinearSearch(arr,key);
        if(result > 0 ) {
            System.out.println("Search Found at index: " + result);
        }else{
            System.out.println("Search not found");
        }
    }
}
