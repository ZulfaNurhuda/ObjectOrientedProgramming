/**
 * VideoPost.java
 * 
 * Kelas VideoPost merupakan kelas turunan dari Post dan mengimplementasikan Engageable serta Shareable
 */
public class VideoPost {

    private int views;
    private int durationSec;
    private boolean useAI;
  
    /**
     * Membuat objek VideoPost baru.
     * Menginisialisasi author, caption, durasi video, dan status penggunaan AI.
     * Views awal bernilai 0.
     *
     * @param author     nama pembuat postingan
     * @param caption    teks caption
     * @param durationSec durasi video dalam detik
     * @param useAI      apakah menggunakan AI
     */
    public VideoPost(String author, String caption, int durationSec, boolean useAI) {
        
    }
  
    /**
     * Menambah jumlah views sebesar 1.
     */
    public void view() {
        
    }
  
    /**
     * Mengambil jumlah views pada video.
     *
     * @return jumlah views
     */
    public int getViews() {
        
    }
  
    /**
     * Mengambil durasi video dalam detik.
     *
     * @return durasi video
     */
    public int getDurationSec() {
        
    }
  
    /**
     * Mengecek apakah video menggunakan AI.
     *
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {
        
    }

    /**
     * Menghitung skor engagement total untuk postingan video.
     * Perhitungan: baseScore ditambah 0.5 kali views, ditambah durationSec / 30, dikurangi 10 jika useAI
     * HINT: Jangan lupa untuk menggunakan casting
     * 
     * @return skor total engagement
     */
    private int totalScore() {
        
    }
  
    /**
     * Membandingkan engagement (totalScore) antara postingan video ini dengan video lain.
     * 
     * @param other video lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {
        
    }
  
    /**
     * Membagikan video ke target tertentu.
     * Menampilkan pesan "Video by @[author] shared to [target]".
     * Setelah itu, share dari Post tersebut juga akan bertambah satu.
     *
     * @param target tujuan share (user tertentu)
     */
    @Override
    public void shareTo(String target) {
        
    }
  }
  