import Model.StudentModelIPL;
import View.StudenListView;

public class Main {
    public static void main(String [] args){
        StudenListView view = new StudenListView(new StudentModelIPL());
    }
}
