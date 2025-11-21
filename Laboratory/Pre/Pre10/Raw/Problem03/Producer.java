/**
 * Producer thread yang bertugas memproduksi roti.
 * Thread ini akan terus memproduksi roti hingga di-interrupt.
 * 
 * Konsep yang harus diimplementasikan:
 * - Thread creation (implements Runnable)
 * - Infinite loop dengan interrupt checking
 * - Sleep untuk simulasi waktu produksi
 * - Exception handling untuk InterruptedException
 */
public class Producer ... {
  private BreadFactory factory;
  private int productionTime; // Waktu produksi dalam milidetik

  /**
   * Constructor Producer
   * 
   * @param factory        BreadFactory tempat memproduksi roti
   * @param productionTime waktu yang dibutuhkan untuk membuat 1 roti (ms)
   */
  public Producer(BreadFactory factory, int productionTime) {
  }

  /**
   * Method run() yang akan dijalankan ketika thread di-start
   * 
   * Langkah-langkah:
   * 1. Buat infinite loop (while true)
   * 2. Di dalam loop:
   * a. Cek apakah thread sudah di-interrupt menggunakan isInterrupted()
   * - Jika iya, tampilkan "[Producer] Interrupted, stopping production..."
   * - Break dari loop
   * b. Panggil factory.produceBread()
   * c. Sleep sesuai productionTime menggunakan Thread.sleep()
   * 3. Catch InterruptedException:
   * - Tampilkan "[Producer] Interrupted during sleep, stopping production..."
   * - Kembalikan interrupt status dengan Thread.currentThread().interrupt()
   * - Break dari loop (atau return)
   * 
   * Note: Penting untuk mengembalikan interrupt status agar thread bisa
   * di-handle dengan benar oleh caller (Main)
   */
  @Override
  public void run() {
  }
}
