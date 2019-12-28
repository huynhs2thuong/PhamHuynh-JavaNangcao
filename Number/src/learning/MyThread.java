package learning;

public class MyThread {
    private int mSharedResource = 0;
    private Object mLock = new Object();
    public void startThreadA() {

        Thread thread = new Thread(new Runnable() {
           private Boolean running = true;
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (mLock) {
                        mSharedResource++;
                        if (mSharedResource >= 5) {
                            running = false;
                        }
                        System.out.println(Thread.currentThread().getName() + "mShareResource = " + mSharedResource);
                    }
                }
            }
        });
        thread.setName("[Thread A :]");
        thread.start();
    }
    public void startThreadB(){
        Thread thread = new Thread(new Runnable() {
            private Boolean running = true;
            @Override
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (mLock) {

                        if (mSharedResource >= 3) {
                            mSharedResource++;
                            System.out.println(Thread.currentThread().getName() + "mShareResource = " + mSharedResource);
                        }

                    }
                }
            }
        });
        thread.setName("[Thread B :]");
        thread.start();
    }
}
