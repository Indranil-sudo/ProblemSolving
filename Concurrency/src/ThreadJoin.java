//join is used so that the main thread waits for other threads to complete execution before terminating.
public class ThreadJoin {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for(int i = 0; i < 5; i++){
                sleep(1000);
                System.out.println("Running..");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        try{
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
