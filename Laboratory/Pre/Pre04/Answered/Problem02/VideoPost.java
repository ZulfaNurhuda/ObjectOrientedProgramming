/**
 * VideoPost.java
 * 
 * Kelas VideoPost merupakan kelas turunan dari Post dan mengimplementasikan
 * Engageable serta Shareable
 */
public class VideoPost extends Post implements Engageable, Shareable {

    private int views;
    private int durationSec;
    private boolean useAI;

    /**
     * Membuat objek VideoPost baru.
     * Menginisialisasi author, caption, durasi video, dan status penggunaan AI.
     * Views awal bernilai 0.
     *
     * @param author      nama pembuat postingan
     * @param caption     teks caption
     * @param durationSec durasi video dalam detik
     * @param useAI       apakah menggunakan AI
     */
    public VideoPost(String author, String caption, int durationSec, boolean useAI) {
        super(author, caption);
        this.durationSec = durationSec;
        this.useAI = useAI;
        this.views = 0;
    }

    /**
     * Menambah jumlah views sebesar 1.
     */
    public void view() {
        views += 1;
    }

    /**
     * Mengambil jumlah views pada video.
     *
     * @return jumlah views
     */
    public int getViews() {
        return views;
    }

    /**
     * Mengambil durasi video dalam detik.
     *
     * @return durasi video
     */
    public int getDurationSec() {
        return durationSec;
    }

    /**
     * Mengecek apakah video menggunakan AI.
     *
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {
        return useAI;
    }

    /**
     * Menghitung skor engagement total untuk postingan video.
     * Perhitungan: baseScore ditambah 0.5 kali views, ditambah durationSec / 30,
     * dikurangi 10 jika useAI
     * HINT: Jangan lupa untuk menggunakan casting
     * 
     * @return skor total engagement
     */
    private int totalScore() {
        double engagementScore = (double) super.baseScore() + 0.5 * views + (double) durationSec / 30 - (useAI ? 10.0 : 0.0);
        return (int) Math.round(engagementScore);
    }

    /**
     * Membandingkan engagement (totalScore) antara postingan video ini dengan video
     * lain.
     * 
     * @param other video lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {
        VideoPost otherVideoPost = (VideoPost) other;

        int result;
        if (totalScore() > otherVideoPost.totalScore()) {
            result = 1;
        } else if (totalScore() < otherVideoPost.totalScore()) {
            result = -1;
        } else {
            result = 0;
        }

        return result;
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
        System.out.printf("Video by @%s shared to %s\n", super.getAuthor(), target);
        super.share();
    }
}
