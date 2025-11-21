import java.util.Scanner;

public class Driver {
  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    int testCase = sc.nextInt();
    sc.close();

    int[][] configs = {
        { 5, 1000, 1500, 5000 }, // TC1: Basic (buffer, prodTime, consTime, duration)
        { 5, 500, 2000, 3000 }, // TC2: Fast producer
        { 5, 2000, 500, 4000 }, // TC3: Fast consumer
        { 5, 800, 1200, 2000 }, // TC4: Short production
        { 5, 1000, 1500, 7000 }, // TC5: Extended production
        { 3, 300, 3000, 4000 }, // TC6: Buffer full
        { 5, 3000, 300, 4000 }, // TC7: Buffer empty
        { 5, 1200, 1200, 6000 } // TC8: Balanced
    };

    String[] names = {
        "Basic Production (5 seconds)",
        "Fast Producer (3 seconds)",
        "Fast Consumer (4 seconds)",
        "Short Production (2 seconds)",
        "Extended Production (7 seconds)",
        "Buffer Full Scenario",
        "Buffer Empty Scenario",
        "Balanced Operations (6 seconds)"
    };

    if (testCase < 1 || testCase > 8) {
      System.out.println("Invalid test case");
      return;
    }

    int[] config = configs[testCase - 1];
    System.out.println("=== Test Case " + testCase + ": " + names[testCase - 1] + " ===\n");

    BreadFactory factory = new BreadFactory(config[0]);
    Thread producer = new Thread((Runnable) new Producer(factory, config[1]));
    Consumer consumer = new Consumer(factory, config[2]);

    producer.start();
    consumer.start();
    Thread.sleep(config[3]);

    System.out.println("\n[Main] Stopping production after " + (config[3] / 1000) + " seconds...");
    producer.interrupt();
    producer.join();
    System.out.println("[Main] Producer finished");

    consumer.interrupt();
    consumer.join();
    System.out.println("[Main] Consumer finished");

    factory.displayStatus();
  }
}
