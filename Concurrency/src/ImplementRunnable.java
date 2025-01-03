public class ImplementRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "My Thread");
        thread.start();
    }
    public static class MyRunnable implements Runnable{
        public void run(){
            System.out.println("MyRunnable is running");
            // Note that Runnable isn't a subclass of Thread which is why we need instance of thread to call getName()
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Current thread is finished");
        }
    }
}
