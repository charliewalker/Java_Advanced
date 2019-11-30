package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       String data = Readfile("/home/trungduc/Desktop/hoten/file/src/com/company/cadao.txt");
        System.out.println(data);
    }

    public static String Readfile(String fileName){
        File file = new File(fileName);
        String data ="";
        try {
            Reader scanner = new FileReader(file);
            int c;
            while ( (c = scanner.read() ) !=-1){
                data+= (char)c;
                System.out.println(c);
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
