public class ParallelPalindrom {
    static final int NUM_OF_THREAD = 10;

    public boolean isPalindrom(int n) {
        if (n < 0)
            return false;
        int original = n;
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return original == reversed;
    }

    // TODO: Lengkapi method ini untuk mencari bilangan palindrom dari [0, N]
    // WAJIB menggunakan concurrency dengan NUM_OF_THREAD threads!

    // Di dalam method run() dalam runnable WAJIB panggil ThreadTracker.mark();
    // Misal :
    // new Thread(() -> {
    //     ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //     //kode lainnya
    // });
    //
    // Atau
    //
    // run() {
    //     ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //     //kode lainnya
    // }

    public int hitungPalindrom(int N) throws InterruptedException {
        PalindromCounter[] counters = new PalindromCounter[NUM_OF_THREAD];
        Thread[] threads = new Thread[NUM_OF_THREAD];

        int range = (N + 1) / NUM_OF_THREAD + ((N + 1) % NUM_OF_THREAD != 0 ? 1 : 0);
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            int start = i * range;
            int end = Math.min(start + range, N + 1);
            if (start < end) {
                counters[i] = new PalindromCounter(start, end);
                threads[i] = new Thread(counters[i]);
            }
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalCount = 0;
        for (PalindromCounter counter : counters) {
            totalCount += counter.getCount();
        }
        return totalCount;
    }

    private class PalindromCounter implements Runnable {
        private final int start;
        private final int end;
        private int count;

        public PalindromCounter(int start, int end) {
            this.start = start;
            this.end = end;
            this.count = 0;
        }

        public int getCount() {
            return count;
        }

        @Override
        public void run() {
            ThreadTracker.mark();
            for (int i = start; i < end; i++) {
                if (isPalindrom(i)) {
                    count++;
                }
            }
        }
    }
}