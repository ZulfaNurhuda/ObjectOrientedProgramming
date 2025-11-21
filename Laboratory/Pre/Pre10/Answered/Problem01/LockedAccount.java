import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockedAccount merepresentasikan akun bank yang menggunakan ReentrantLock
 * untuk operasi thread-safe dengan kontrol yang lebih eksplisit.
 *
 * KONSEP PENTING:
 * - Lock memberikan kontrol lebih dibanding synchronized (bisa tryLock, timeout, dll)
 * - Lock HARUS di-unlock secara eksplisit (tidak otomatis seperti synchronized)
 * - Jika lupa unlock, thread lain akan BLOCKED SELAMANYA (deadlock!)
 */
public class LockedAccount {
    private long balance;
    private final Lock lock;

    /**
     * Konstruktor untuk inisialisasi akun dengan saldo awal
     *
     * @param initialBalance saldo awal
     */
    public LockedAccount(long initialBalance) {
        // TODO: Inisialisasi balance
        balance = initialBalance;

        // TODO: Inisialisasi lock dengan ReentrantLock
        // PIKIRKAN: Mengapa lock harus final? Apa yang terjadi jika bisa di-reassign?
        lock = new ReentrantLock();
    }

    /**
     * Menyetor uang ke dalam akun
     *
     * PATTERN PENTING:
     * 1. Acquire lock dulu
     * 2. Operasi critical section (akses shared data)
     * 3. Release lock (WAJIB di finally!)
     *
     * PIKIRKAN:
     * - Mengapa unlock harus di finally block?
     * - Apa yang terjadi jika exception muncul di tengah operasi?
     *
     * @param amount jumlah yang akan disetor
     */
    public void deposit(long amount) {
        // TODO: Implementasikan deposit dengan lock pattern
        // Hint: lock.lock(), try-finally, lock.unlock()
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Menarik uang dari akun
     *
     * PIKIRKAN:
     * - Bagaimana cara memastikan check-then-act (cek saldo -> tarik) atomik?
     * - Di mana posisi yang tepat untuk lock dan unlock?
     * - Bagaimana cara return value dengan benar sambil tetap unlock?
     *
     * @param amount jumlah yang akan ditarik
     * @return true jika berhasil, false jika tidak
     */
    public boolean withdraw(long amount) {
        // TODO: Implementasikan withdraw dengan lock pattern
        // Hint: Perhatikan alur return value - unlock tetap harus dipanggil!
        lock.lock();
        try {
            boolean success;
            if (balance >= amount) {
                balance -= amount;
                success = true;
            } else {
                success = false;
            }
            return success;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Mendapatkan saldo saat ini
     *
     * PERTANYAAN KRITIS:
     * - Apakah READ operation perlu di-lock?
     * - Apa konsekuensinya jika tidak di-lock sementara thread lain sedang deposit?
     * - Bagaimana menjamin consistency antara operasi read dan write?
     *
     * @return saldo saat ini
     */
    public long getBalance() {
        // TODO: Implementasikan getBalance dengan lock pattern
        // Hint: Meskipun hanya read, tetap perlu lock untuk consistency!
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
