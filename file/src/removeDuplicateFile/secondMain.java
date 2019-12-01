package removeDuplicateFile;

import android.widget.ArrayAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class secondMain {

    public static  void  main(String [] args) throws IOException {
        String path ="/home/trungduc/Desktop/hoten/file";
       // listFiles(path);
        removeDuplicatedFiles(path,"caodao.txt");
    }
    public static ArrayList<String> listPaths = new ArrayList<>();
    public static ArrayList<Long> flag= new ArrayList<>();
    public static void listFiles(String folderPath) throws IOException {

        File folder = new File(folderPath);

        File[] files = folder.listFiles();
        if (files.length == 0) {
            listPaths.add(folder.getCanonicalPath());
            System.out.println(folder.getCanonicalPath());

        }

        for (File f : files) {
            if (f.isFile()) {

                listPaths.add(f.getCanonicalPath());

               // System.out.println(f.getCanonicalPath());
                System.out.println( f.getName());
            } else {
                listFiles(f.getPath());
            }
        }
    }

    public static void removeDuplicatedFiles(String folderPath, String filename) throws IOException {
        File folder = new File(folderPath);
        File [] listFile =folder.listFiles();

        for(File f: listFile){
            System.out.println(f.getName());
            System.out.println(f.length());
            if (f.isFile()){
                    if (f.getName().equals(filename)){
                        System.out.println(filename);
                       if ( flag.size() <= 0){
                           flag.add(f.length());
                       }
                       else {
                           if (flag.get(0) == f.length()){
                               f.delete();
                               System.out.println("Mission Success!");
                               System.out.println("Delete at:"+ f.getCanonicalPath());
                           }

                       }

                    }
                    else {
                        System.out.println("Mission fail!");
                    }
            }
            else {
                System.out.println(f.getPath());
                removeDuplicatedFiles(f.getPath(),filename);
            }
        }



    }


}
