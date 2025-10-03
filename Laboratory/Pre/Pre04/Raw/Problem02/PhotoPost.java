/**
 * PhotoPost.java
 * 
 * Kelas PhotoPost merupakan kelas turunan dari Post dan mengimplementasikan Engageable serta Shareable
 */
public class PhotoPost {

    private int hashtagCount;
    private boolean useAI;
    private boolean useMusic;
  
    /**
     * Membuat objek PhotoPost baru.
     * Menginisialisasi author, caption, jumlah hashtag, dan status penggunaan AI/musik.
     *
     * @param author      nama pembuat postingan
     * @param caption     teks caption
     * @param hashtagCount jumlah hashtag yang digunakan
     * @param useAI       apakah menggunakan AI
     * @param useMusic    apakah menggunakan musik
     */
    public PhotoPost(String author, String caption, int hashtagCount, boolean useAI, boolean useMusic) {

    }
  
    /**
     * Mengembalikan jumlah hashtag pada postingan.
     * 
     * @return jumlah hashtag
     */
    public int getHashtagCount() {

    }
  
    /**
     * Mengecek apakah postingan menggunakan AI.
     * 
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {

    }
  
    /**
     * Mengecek apakah postingan menggunakan musik.
     * 
     * @return true jika menggunakan musik, false jika tidak
     */
    public boolean isUseMusic() {

    }

    /**
   * Menghitung skor engagement total untuk postingan foto.
   * Perhitungan: baseScore ditambah 2 kali hashtagCount, dikurangi 10 jika useAI, ditambah 5 jika useMusic
   *
   * @return skor total engagement
   */
    private int totalScore() {

    }
  
    /**
     * Membandingkan engagement (totalScore) antara postingan ini dengan postingan lain.
     * 
     * @param other postingan lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {

    }
  
    /**
     * Membagikan postingan ke target tertentu.
     * Menampilkan pesan "Photo by @[author] shared to [target]".
     * Setelah itu, share dari Post tersebut juga akan bertambah satu.
     *
     * @param target tujuan share (user tertentu)
     */
    @Override
    public void shareTo(String target) {

    }
  }
  