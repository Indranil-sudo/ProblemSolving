public class ExtendsThread {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }

    public static class MyThread extends Thread{
        public void run(){
            System.out.println("My thread is running");
        }
    }
}