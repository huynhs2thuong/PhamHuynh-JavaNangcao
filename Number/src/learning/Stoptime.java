package learning;

public class Stoptime  {
public static void main(String[] args) throws InterruptedException {
    InterruptedThread interruptedThread = new InterruptedThread();
    interruptedThread.start();
    Thread.sleep(5000);
    interruptedThread.interrupt();
}
}
class InterruptedThread extends Thread{
    private int mValue = 0;
    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
                interrupt();
            }
            mValue++;
            System.out.println("Value : " +mValue);
        }
    }
}
