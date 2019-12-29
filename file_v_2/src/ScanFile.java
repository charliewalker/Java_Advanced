import java.io.File;

public class ScanFile {
    private Thread mThread;
    private String mThreadName;

    private File mFolder;

    private File mFile;

    private int mCount;

    private ConsumerProducer mConsumerProducer;

    private static boolean mIsFinished = false;

    public ScanFile(String threadName, String folder, String filename, ConsumerProducer cp) {
        mFolder = new File(folder);
        mFile = new File(filename);
        mConsumerProducer = cp;
        mThreadName = threadName;
    }
    public static boolean isFinished() {
        return mIsFinished;
    }

    public void execute() {

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                scan(mFolder);
                mIsFinished = true;
                mConsumerProducer.unlockAll();
                System.out.println(Thread.currentThread().getName() + " FINISHED. Files found: " + mCount);
            }
        }, mThreadName);
        mThread.start();
    }
    private void scan(File folder) {

        File[] files = folder.listFiles();
        for (File f: files) {
            if (f.isDirectory()) {
                scan(f);
            } else {
                if (f.length() == mFile.length()
                        && f.getName().equalsIgnoreCase(mFile.getName())
                        && !f.equals(mFile)) {
                    mConsumerProducer.produce(f);
                    mCount++;
                    System.out.println(Thread.currentThread().getName() + " found: " + f.getAbsolutePath());
                }
            }
        }
    }
}
