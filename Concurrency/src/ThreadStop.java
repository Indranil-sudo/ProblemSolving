import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ThreadStop {
    public static void main(String[] args) {
        StoppableRunnable curr = new StoppableRunnable();
        Thread thread = new Thread(curr, "The thread");
        thread.start();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("requesting stop");
        curr.requestStop();
        System.out.println("stop requested");
    }
    public static class StoppableRunnable implements Runnable{
        private boolean stopRequested = false;
        private synchronized void requestStop(){
            this.stopRequested = true;
        }

        public synchronized boolean isStopRequested(){
            return this.stopRequested;
        }

        private void sleep(long millis){
            try{
                Thread.sleep(millis);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        public void run(){
            System.out.println("StoppableRunnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable stopped");
        }
    }
}
