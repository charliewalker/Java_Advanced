package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
       String data = Readfile("/home/trungduc/Desktop/hoten/file/src/com/company/cadao.txt");
       // System.out.println(data);
        String newData = ReadUTF8("/home/trungduc/Desktop/hoten/file/src/com/company/cadao.txt");
        System.out.println(newData);
    }
    public  static  String ReadUTF8(String FileName) throws IOException {
        String Data ="";
        Reader reader = new FileReader(FileName);
        BufferedReader buffer =new BufferedReader(reader);
        int c,i =1 ;
        String Line;

        while ((Line = buffer.readLine()) !=null){
            Data+= i +"-"+ Line + "\n";
            i++;
        }
        return Data;
    }
    public static String Readfile(String fileName){
        File file = new File(fileName);
        String data ="";
        try {
            Reader scanner = new FileReader(file);
            int c;
            while ( (c = scanner.read() ) !=-1){
                data+= (char)c;
                //System.out.println(c);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            data ="Error";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  data;
    }
}
