public class VirtualThreadExample {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread vThread1 = Thread.ofVirtual().name("vThread1").start(runnable);
        Thread vUnstarted = Thread.ofVirtual().unstarted(runnable);
        vUnstarted.start();
        // Unlike platform threads, virtual threads are just scheduled to run when started. To ensure the run, we should
        // explicitly use run() call. Other way is to join threads
//        vThread1.run();
        try{
            vThread1.join();
            vUnstarted.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public static class MyRunnable implements Runnable{
        public void run(){
            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "- Index: " + i);
            }
        }
    }
}
