package Test_10;


import java.io.*;

public class FileIO {

    public static String[] readAllLines(String fileName){
        try {
            String s;
            String str[] = new String[512];
            int i = 0;
            FileReader fin = new FileReader(fileName);
            BufferedReader bin = new BufferedReader(fin);
            while((s = bin.readLine()) != null){
                str[i++] = s;
            }
            bin.close();
            fin.close();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeLine(String fileName,String contents){
        try {
            FileWriter fout = new FileWriter(fileName,true);
            BufferedWriter bout = new BufferedWriter(fout);
            bout.write(contents);
            bout.newLine();
            bout.close();
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
