public class RunnableLambda {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Lambda running");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Lambda is finished");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
