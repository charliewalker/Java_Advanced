public class ReadFile {



    public ReadFile(){

    }
    private  ReadPdfFile readPdfFile;
    private  ReadTextFile readTextFile;



    public ReadPdfFile getReadPdfFile() {
        return readPdfFile;
    }

    public ReadTextFile getReadTextFile() {
        return readTextFile;
    }

    public void setReadPdfFile(ReadPdfFile readPdfFile) {
        this.readPdfFile = readPdfFile;
    }

    public void setReadTextFile(ReadTextFile readTextFile) {
        this.readTextFile = readTextFile;
    }
}
