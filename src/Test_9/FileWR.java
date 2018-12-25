package Test_9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWR {

    int value;
    String filename;

    public FileWR(int value,String filename){
        this.value = value;
        this.filename = filename;
    }

    public void writeToText(String filename){
        try {
            FileOutputStream fout = new FileOutputStream(filename);
            fout.write(value >>> 24);
            fout.write(value >> 18);
            fout.write(value >> 8);
            fout.write(value);
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToText(){
        writeToText(this.filename);
    }

    public int readFromText(String filename){
        try {
            FileInputStream fin = new FileInputStream(filename);
            int tmp;
            value = fin.read();
            for(int i = 0;i < 3 && ((tmp =fin.read()) != -1);i++){
                value = value << 8 | tmp;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public int readFromText(){
        return readFromText(this.filename);
    }

    public static void main(String[] args) {
        FileWR a = new FileWR(-128,"./src/Test_9/value.txt");
        a.writeToText();
        System.out.println(a.readFromText());
    }

}
