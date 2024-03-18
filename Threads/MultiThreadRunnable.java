package Threads;

public class MultiThreadRunnable implements Runnable{
    private int thread_number;
    public MultiThreadRunnable (int t) {
        this.thread_number = t;
    }
    @Override
    public void run() {
        for(int i = 1;i<=5;i++) {
            System.out.println(i+" from Thread: "+thread_number);

//            if(thread_number==2){
//                throw new RuntimeException();
//            }
            try {
                Thread.sleep(200);

            }catch(InterruptedException e){

            }
        }
    }
}
