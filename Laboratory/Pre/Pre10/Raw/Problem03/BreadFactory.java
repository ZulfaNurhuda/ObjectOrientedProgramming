import java.util.LinkedList;
import java.util.Queue;

/**
 * BreadFactory adalah shared resource yang digunakan oleh Producer dan
 * Consumer.
 * Class ini merepresentasikan buffer penyimpanan roti dengan kapasitas
 * maksimal.
 * 
 * Konsep yang harus diimplementasikan:
 * - Synchronization untuk menghindari race condition
 * - wait() dan notify() untuk blocking ketika buffer penuh/kosong
 * - Thread-safe operations
 */
public class BreadFactory {
  private Queue<Integer> buffer; // Queue untuk menyimpan nomor roti
  private int maxCapacity; // Kapasitas maksimal buffer
  private int breadCounter; // Counter untuk nomor roti yang diproduksi
  private int totalProduced; // Total roti yang sudah diproduksi
  private int totalConsumed; // Total roti yang sudah dikonsumsi

  /**
   * Constructor BreadFactory
   * 
   * Langkah-langkah:
   * 1. Inisialisasi buffer sebagai LinkedList<Integer>
   * 2. Set maxCapacity sesuai parameter
   * 3. Set breadCounter = 0
   * 4. Set totalProduced = 0
   * 5. Set totalConsumed = 0
   * 
   * @param maxCapacity kapasitas maksimal buffer
   */
  public BreadFactory(int maxCapacity) {
  }

  /**
   * Menambahkan roti ke buffer (dipanggil oleh Producer)
   * Method ini harus synchronized!
   * 
   * Langkah-langkah:
   * 1. Cek apakah buffer penuh (size == maxCapacity)
   * - Jika penuh, tampilkan "[Producer] Buffer full, waiting..."
   * - Panggil wait() untuk menunggu hingga ada slot kosong
   * - Setelah wait() selesai, tampilkan "[Producer] Resumed production"
   * 2. Increment breadCounter
   * 3. Tambahkan breadCounter ke buffer menggunakan offer()
   * 4. Increment totalProduced
   * 5. Tampilkan "[Producer] Produced bread #" + breadCounter + " (Buffer: " +
   * buffer.size() + "/" + maxCapacity + ")"
   * 6. Panggil notify() untuk membangunkan Consumer yang sedang waiting
   * 
   * Note: Method ini bisa throw InterruptedException dari wait()
   * 
   * @throws InterruptedException jika thread di-interrupt saat waiting
   */
  public synchronized void produceBread() throws InterruptedException {
  }

  /**
   * Mengambil roti dari buffer (dipanggil oleh Consumer)
   * Method ini harus synchronized!
   * 
   * Langkah-langkah:
   * 1. Cek apakah buffer kosong (size == 0)
   * - Jika kosong, tampilkan "[Consumer] Buffer empty, waiting..."
   * - Panggil wait() untuk menunggu hingga ada roti
   * - Setelah wait() selesai, tampilkan "[Consumer] Resumed consumption"
   * 2. Ambil roti dari buffer menggunakan poll()
   * 3. Increment totalConsumed
   * 4. Tampilkan "[Consumer] Consumed bread #" + breadNumber + " (Buffer: " +
   * buffer.size() + "/" + maxCapacity + ")"
   * 5. Panggil notify() untuk membangunkan Producer yang sedang waiting
   * 
   * Note: Method ini bisa throw InterruptedException dari wait()
   * 
   * @throws InterruptedException jika thread di-interrupt saat waiting
   */
  public synchronized void consumeBread() throws InterruptedException {
  }

  /**
   * Cek apakah buffer kosong
   * Method ini harus synchronized untuk thread-safety!
   * 
   * @return true jika buffer kosong, false jika tidak
   */
  public synchronized boolean isEmpty() {
  }

  /**
   * Menampilkan status akhir factory
   * Method ini harus synchronized untuk thread-safety!
   * 
   * Tampilkan:
   * "\n=== FACTORY STATISTICS ==="
   * "Total Produced: " + totalProduced + " breads"
   * "Total Consumed: " + totalConsumed + " breads"
   * "Remaining in Buffer: " + buffer.size() + " breads"
   */
  public synchronized void displayStatus() {
  }
}
