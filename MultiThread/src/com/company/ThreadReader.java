package com.company;

import java.io.*;

public class ThreadReader {

    public static void main(String[] args) throws InterruptedException {

        ThreadReader t = new ThreadReader("E:\\Javanangcao\\MultiThread\\src\\com\\company\\BasicThread.java");
        CompletionListener completionListener = new CompletionListener() {
            @Override
            public void onComplete() {
                System.out.println("File content \n" + t.getmFileContent().toString());
            }
        };
        t.setMlistener(completionListener);
        t.read();
       /* while (t.getmFileContent().isEmpty()) {
            Thread.sleep(50);
        }
*/
        System.out.println("Finished");
    }

    interface CompletionListener {
        void onComplete();
    }

    public StringBuilder getmFileContent() {
        return mFileContent;
    }

    private String mFilename;
    private StringBuilder mFileContent = new StringBuilder();

    public void setMlistener(CompletionListener listener) {
        this.mlistener = listener;
    }

    private CompletionListener mlistener;

    public ThreadReader(String filename) {
        mFilename = filename;
    }

    public void read() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    readFile();
                    if(mlistener != null){
                    mlistener.onComplete();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

    private void readFile() throws IOException {
        FileReader fileReader = new FileReader(mFilename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            mFileContent.append(line);

        }
        bufferedReader.close();
    }

}
