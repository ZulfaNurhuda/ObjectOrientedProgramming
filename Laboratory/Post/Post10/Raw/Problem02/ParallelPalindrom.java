public class ParallelPalindrom {
    static final int NUM_OF_THREAD = 10;
    
    public boolean isPalindrom(int n) {
        if (n < 0) return false;
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
    // run(){
    //   ThreadTracker.mark(); <- tambahkan ini ketika ingin submit jawaban
    //   //kode lainnya
    // }

    public int hitungPalindrom(int N) throws InterruptedException {
        
    }
}