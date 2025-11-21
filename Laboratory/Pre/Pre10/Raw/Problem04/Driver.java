public class Driver {
    public static void main(String[] args) throws Exception {
        RequestQueue queue = new RequestQueue();
        Thread producer = new Thread(new RequestProducer(queue));
        WorkerThread w1 = new WorkerThread(queue, 1);
        WorkerThread w2 = new WorkerThread(queue, 2);

        System.out.println("=== Producer & Worker ===");
        producer.start();
        w1.start();
        w2.start();
        Thread.sleep(600);
        producer.interrupt();
        w1.interrupt();
        w2.interrupt();
        producer.join();
        w1.join();
        w2.join();

        System.out.println("=== Deadlock Simulator ===");
        new DeadlockSimulator().start();

        Thread.sleep(500);
        System.out.println("Program selesai");
    }
}
