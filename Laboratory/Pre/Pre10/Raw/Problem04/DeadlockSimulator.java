public class DeadlockSimulator {
    private final Object A = new Object();
    private final Object B = new Object();

    public void start() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (B) {
                    System.out.println("Thread1 selesai");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (A) {
                    System.out.println("Thread2 selesai");
                }
            }
        });

        t1.setDaemon(true);
        t2.setDaemon(true);

        t1.start();
        t2.start();

        int totalWait = 0;
        while (totalWait < 100) {
            Thread.sleep(20);
            totalWait += 20;
            System.out.println("Menunggu deadlock " + totalWait + "ms");
        }

        System.out.println("deadlock!");
    }
}
