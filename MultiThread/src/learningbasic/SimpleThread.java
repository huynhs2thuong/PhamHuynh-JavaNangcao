package learningbasic;

public class SimpleThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +" started");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" - value i :" + i);

        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
