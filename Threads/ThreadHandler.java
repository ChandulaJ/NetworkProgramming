package Threads;

public class ThreadHandler {
public static void main(String[] args) {
    //Using multithread
	/*
	MultiThread t1 = new MultiThread(1);
	MultiThread t2= new MultiThread(2);
	MultiThread t3 = new MultiThread(3);
	t1.start();
	t2.start();
	t3.start();
	*/

    //Using Runnable
/*
    MultiThreadRunnable mtr1 = new MultiThreadRunnable(1);
    MultiThreadRunnable mtr2 = new MultiThreadRunnable(2);
    MultiThreadRunnable mtr3 = new MultiThreadRunnable(3);
    Thread t1 = new Thread(mtr1);
    Thread t2 = new Thread(mtr2);
    Thread t3 = new Thread(mtr3);
    t1.start();
    t2.start();
    t3.start();
*/


for(int i = 1;i<=3;i++) {
    MultiThreadRunnable mtr4 = new MultiThreadRunnable(i);
    Thread t4 = new Thread(mtr4);
    t4.start();

    //to wait until the thread dies, we can use .join() method
    try {
        t4.join();

    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

    /*
    when we use threads, we cannot extend that to another class,
    but when we use runnable, we can extend that to another class

    when we use threads, the number of code lines are lower than of runnable
     */

}
}
