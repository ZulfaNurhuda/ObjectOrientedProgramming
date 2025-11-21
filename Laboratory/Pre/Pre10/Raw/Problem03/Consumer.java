/**
 * Consumer thread yang bertugas mengonsumsi/mengemas roti.
 * Thread ini akan terus mengonsumsi roti hingga buffer kosong dan producer
 * selesai.
 * 
 * Konsep yang harus diimplementasikan:
 * - Thread creation (extends Thread)
 * - Loop dengan kondisi (tidak infinite)
 * - Sleep untuk simulasi waktu konsumsi
 * - Exception handling untuk InterruptedException
 * - Koordinasi dengan Producer thread
 */
public class Consumer ... {
  private BreadFactory factory;
  private int consumptionTime; // Waktu konsumsi dalam milidetik

  /**
   * Constructor Consumer
   * 
   * @param factory         BreadFactory tempat mengonsumsi roti
   * @param consumptionTime waktu yang dibutuhkan untuk mengemas 1 roti (ms)
   */
  public Consumer(BreadFactory factory, int consumptionTime) {
  }

  /**
   * Method run() yang akan dijalankan ketika thread di-start
   * 
   * Langkah-langkah:
   * 1. Buat loop yang berjalan selama:
   * - Producer masih running (!Thread.currentThread().isInterrupted()), ATAU
   * - Buffer tidak kosong (!factory.isEmpty())
   * 
   * Tips: gunakan while (true) dan break dengan kondisi tertentu
   * 
   * 2. Di dalam loop:
   * a. Cek apakah buffer kosong menggunakan factory.isEmpty()
   * - Jika kosong DAN thread di-interrupt, break dari loop
   * - Jika kosong tapi belum di-interrupt, skip iterasi ini dan lanjut loop
   * (gunakan continue setelah sleep kecil ~100ms untuk menghindari busy waiting)
   * 
   * b. Jika buffer tidak kosong:
   * - Panggil factory.consumeBread()
   * - Sleep sesuai consumptionTime menggunakan Thread.sleep()
   * 
   * 3. Catch InterruptedException:
   * - Tampilkan "[Consumer] Interrupted, finishing remaining breads..."
   * - Kembalikan interrupt status dengan Thread.currentThread().interrupt()
   * - Continue loop untuk menghabiskan sisa buffer
   * 
   * Note: Consumer harus tetap menghabiskan sisa roti di buffer meskipun
   * sudah di-interrupt. Ini penting untuk memastikan semua roti terproses.
   */
  @Override
  public void run() {
  }
}
