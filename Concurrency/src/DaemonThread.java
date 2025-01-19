//JVM keeps running even after the main thread is completed as the created thread is in an infinite while loop.
public class DaemonThread {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            while(true){
                sleep(1000);
                System.out.println("Running..");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3100);
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
