package dowloadresouce;

import java.io.*;
import java.net.URL;

public class dowloadfile {
    public static  void main(String [] args) throws IOException {
        String imgUrl ="https://baotuoitre.net/wp-content/uploads/2019/08/bang-ky-tu-dac-biet-ascii-1.jpg";
        String texturl ="https://raw.githubusercontent.com/gemary/hoten/master/file/src/com/company/cadao.txt";


       // DowloadResouce(texturl,"/home/trungduc/Desktop/hoten/file/src/dowloadresouce/test/text.txt");
      File file = new File("/home/trungduc/Desktop/hoten");
       File []  listChildren =  file.listFiles();
       for (File files:listChildren ){
                System.out.println(files);
       }
    }
public  static void DowloadResouce(String StrUrl,String FileName) throws IOException {
    URL url = new URL(StrUrl);
    InputStream inputStream = url.openStream();
    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte [] buffer = new byte[128];
    int count;
    while ((count = bufferedInputStream.read(buffer))!=-1){
        baos.write(buffer,0,count);
        File file = new File(FileName);
        if (file.exists()){
            FileOutputStream outputStream = new FileOutputStream(FileName);
            outputStream.write(baos.toByteArray());
            outputStream.close();
        }
        else {
            file.getParentFile().mkdirs();
            FileOutputStream outputStream = new FileOutputStream(FileName);
            outputStream.write(baos.toByteArray());
            outputStream.close();
        }


    }
    inputStream.close();
}

}
