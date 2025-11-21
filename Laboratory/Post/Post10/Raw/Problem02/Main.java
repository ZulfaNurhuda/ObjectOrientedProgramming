public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParallelPalindrom hp = new ParallelPalindrom();
        
        // Test 1: Palindrom [0-100]
        ThreadTracker.reset();
        System.out.println("=== Test 1: Palindrom [0-100] ===");
        int hasil1 = hp.hitungPalindrom(100);
        ThreadTracker.verifyUsedMultipleThreads();
        System.out.println("Palindrom [0-100]: " + hasil1); // Expected: 19
        
        
        // Test 2: Palindrom [0-1000]
        ThreadTracker.reset();
        System.out.println("=== Test 2: Palindrom [0-1000] ===");
        int hasil2 = hp.hitungPalindrom(1000);
        ThreadTracker.verifyUsedMultipleThreads();
        System.out.println("Palindrom [0-1000]: " + hasil2); // Expected: 109
        
    }
}
