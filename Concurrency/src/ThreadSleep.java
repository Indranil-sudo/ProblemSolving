public class ThreadSleep {
    public static void main(String[] args) {
        Runnable myRunnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " is running.");
            try{
                Thread.sleep(4000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Thread is finished running");
        };
        Thread thread = new Thread(myRunnable, "testThread");
        thread.start();
    }
}
