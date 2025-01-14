public class AnonymousRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                System.out.println("MyRunnable is running");
                System.out.println(Thread.currentThread().getName());
                System.out.println("Current thread is finished");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
