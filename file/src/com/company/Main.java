package com.company;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
//       String data = Readfile("/home/trungduc/Desktop/hoten/file/src/com/company/cadao.txt");
//       // System.out.println(data);
//        String newData = ReadUTF8("/home/trungduc/Desktop/hoten/file/src/com/company/cadao.txt");
//        System.out.println(newData);
            String Url ="https://baotuoitre.net/wp-content/uploads/2019/08/bang-ky-tu-dac-biet-ascii-1.jpg";
           // String resut = ReadOnline("https://raw.githubusercontent.com/gemary/hoten/master/file/src/com/company/cadao.txt");
           // System.out.println(resut);
        String resut = ReadOnline(Url);
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
    public static String ReadOnline(String strurl) throws IOException {
        String str = null;
        URL url = new URL(strurl);
        HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
        int rscode = connection.getResponseCode();
        if (rscode == HttpsURLConnection.HTTP_OK){
            InputStream is = connection.getInputStream();
            BufferedInputStream buffer = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] bufferar = new byte[100];
            int count;
            while ((count = buffer.read(bufferar)) != -1) {
                baos.write(bufferar, 0, count);
            }
            str = new String(baos.toByteArray());
            SaveFile("test.png",baos.toByteArray());
            is.close();

        }
        return str;
    }
    public static void SaveFile(String FileName, byte[] data) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FileName);
       // byte[] datas =  data.getBytes();0..
        fileOutputStream.write(data);
        fileOutputStream.close();
    }
}
