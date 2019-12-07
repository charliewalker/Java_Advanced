package removeDuplicateFile;

import android.widget.ArrayAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class secondMain {

    public static  void  main(String [] args) throws IOException {
        String path ="/home/trungduc/Desktop/hoten/test";
       // listFiles(path);
        removeDuplicatedFiles(path,"caodao.txt");
    }
    public static ArrayList<String> listPaths = new ArrayList<>();
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
    public  static  int checkDuplicateFIle(String filePath, String filename) throws IOException {
        File file = new File(filePath);
        File [] listfile = file.listFiles();
        for (File f: listfile){
            if (f.isFile()){
                if (f.getName().equals(filename)){
                    listPaths.add(f.getCanonicalPath());
                }
            }
            else {
                checkDuplicateFIle(f.getPath(),filename);
            }

        }
        return listPaths.size();
    }
    public static void removeDuplicatedFiles(String folderPath, String filename) throws IOException {
        int success = checkDuplicateFIle(folderPath, filename);
        if (success >1){
           for (int i = 0 ; i < listPaths.size(); i++){
               File file = new File(listPaths.get(i));
               System.out.println(file.getName());
               System.out.println(file.length());
               for (int j = i+1 ; j < listPaths.size();j++){
                   File file1 = new File(listPaths.get(j));
                   System.out.println(file1.getName());
                   System.out.println(file1.length());
                   if (file.length() == file1.length()){
                       file.delete();
                       System.out.println("Mission success!");
                       System.out.println(file.getCanonicalPath());
                   }
               }

           }

        }
        else {
            System.out.println("Dont have Duplicate File!");
        }

    }


}
