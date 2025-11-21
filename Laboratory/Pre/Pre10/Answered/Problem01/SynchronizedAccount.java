/**
 * SynchronizedAccount merepresentasikan akun bank yang menggunakan synchronized methods
 * untuk memastikan operasi yang thread-safe.
 *
 * PERHATIAN: Ketika banyak thread mengakses object yang sama secara bersamaan,
 * bisa terjadi race condition. Synchronized methods memastikan hanya satu thread
 * yang bisa mengakses method tersebut pada satu waktu.
 */
public class SynchronizedAccount {
    private long balance;

    /**
     * Konstruktor untuk inisialisasi akun dengan saldo awal
     *
     * @param initialBalance saldo awal
     */
    public SynchronizedAccount(long initialBalance) {
        // TODO: Simpan saldo awal ke instance variable
        balance = initialBalance;
    }

    /**
     * Menyetor uang ke dalam akun
     *
     * PIKIRKAN:
     * - Apa yang terjadi jika 2 thread melakukan deposit bersamaan tanpa synchronized?
     * - Bagaimana cara memastikan operasi ini thread-safe?
     *
     * @param amount jumlah yang akan disetor
     */
    public synchronized void deposit(long amount) {
        // TODO: Bagaimana cara menambah saldo dengan jumlah yang disetor?
        balance += amount;
    }

    /**
     * Menarik uang dari akun
     *
     * PIKIRKAN:
     * - Apa kondisi yang harus dipenuhi agar penarikan bisa dilakukan?
     * - Apa yang harus dilakukan jika kondisi terpenuhi vs tidak terpenuhi?
     * - Mengapa method ini perlu synchronized?
     *
     * @param amount jumlah yang akan ditarik
     * @return true jika penarikan berhasil, false jika tidak
     */
    public synchronized boolean withdraw(long amount) {
        // TODO: Implementasikan logika penarikan uang
        // Hint: Cek saldo terlebih dahulu sebelum menarik
        boolean success;
        if (balance >= amount) {
            balance -= amount;
            success = true;
        } else {
            success = false;
        }
        return success;
    }

    /**
     * Mendapatkan saldo saat ini
     *
     * PIKIRKAN:
     * - Apakah operasi READ juga perlu synchronized? Mengapa?
     * - Apa yang bisa terjadi jika getBalance() tidak synchronized sementara
     *   thread lain sedang melakukan deposit/withdraw?
     *
     * @return saldo saat ini
     */
    public synchronized long getBalance() {
        // TODO: Kembalikan nilai saldo
        return balance;
    }
}
