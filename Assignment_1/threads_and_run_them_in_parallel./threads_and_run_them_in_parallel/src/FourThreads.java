public class FourThreads {

    Thread t1 = new Thread(new MyRunnable(), "Thread 1");
    Thread t2 = new Thread(new MyRunnable(), "Thread 2");
    Thread t3 = new Thread(new MyRunnable(), "Thread 3");
    Thread t4 = new Thread(new MyRunnable(), "Thread 4");

    public FourThreads(){
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
