import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicAccount merepresentasikan akun bank yang menggunakan AtomicLong
 * untuk operasi thread-safe tanpa lock (lock-free).
 *
 * KONSEP LOCK-FREE:
 * - AtomicLong menggunakan CPU-level atomic operations
 * - Lebih cepat dari lock untuk operasi sederhana
 * - TAPI: Hanya cocok untuk operasi atomik sederhana (increment, decrement, dll)
 * - TIDAK cocok untuk operasi kompleks (check-then-act seperti withdraw)
 */
public class AtomicAccount {
    private final AtomicLong balance;

    /**
     * Konstruktor untuk inisialisasi akun dengan saldo awal
     *
     * PIKIRKAN:
     * - Mengapa balance bertipe AtomicLong, bukan long biasa?
     * - Apa perbedaan antara AtomicLong dan long dalam konteks concurrency?
     *
     * @param initialBalance saldo awal
     */
    public AtomicAccount(long initialBalance) {
        // TODO: Inisialisasi balance dengan AtomicLong
        // Hint: AtomicLong punya constructor yang terima long value
    }

    /**
     * Menambah saldo dengan jumlah tertentu
     *
     * CATATAN PENTING:
     * - Method ini TIDAK bernama "deposit" tapi "increment"
     * - Ini karena AtomicLong cocok untuk operasi aritmatika sederhana
     * - Tidak ada validasi atau kondisi - pure increment
     *
     * PIKIRKAN:
     * - Method apa yang disediakan AtomicLong untuk increment?
     * - Mengapa operation ini thread-safe tanpa synchronized/lock?
     * - Bagaimana jika butuh operasi lebih kompleks (misal: cek kondisi dulu)?
     *
     * @param amount jumlah yang akan ditambahkan
     */
    public void increment(long amount) {
        // TODO: Tambahkan amount ke balance
        // Hint: AtomicLong punya method untuk add secara atomik
    }

    /**
     * Mendapatkan saldo saat ini
     *
     * PIKIRKAN:
     * - Bagaimana cara membaca nilai dari AtomicLong?
     * - Apakah operasi ini butuh lock? Mengapa/mengapa tidak?
     * - Apa bedanya get() atomic vs read variable biasa?
     *
     * @return saldo saat ini
     */
    public long getBalance() {
        // TODO: Kembalikan nilai balance
        // Hint: AtomicLong punya method untuk get value
    }
}
