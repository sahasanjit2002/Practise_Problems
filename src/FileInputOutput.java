import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class FileInputOutput {
    public static void main(String[] args){
        try {
            // file read
            File file = new File("arrays.txt");
            Scanner sc = new Scanner(file);
            String data[] = new String[3];
            int count  = 0;
            while(sc.hasNextLine()){
                String tempData = sc.nextLine();
                // have a line which states 'end of input' to signify the end of input
                if(tempData.equals("end of input")){
                    break;
                }else{
                    data[count] = tempData;
                    count++;
                }
            }
            sc.close();
            /////////////////////////////////////////////////////////




            // file write
            char a = '\u2386';
            FileWriter fr = new FileWriter(file, true);
//            fr.append('\n');
//            fr.append("message ");
            fr.close();

            // file read
        }catch(FileNotFoundException e){
            System.out.print("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.print("IO exception");
            throw new RuntimeException(e);
        }
    }
}
