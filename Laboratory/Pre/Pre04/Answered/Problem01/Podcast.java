/**
 * Class Podcast - Template
 *
 * Kelas ini merepresentasikan podcast yang dapat diputar dan diunduh.
 */

public class Podcast implements Playable, Downloadable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul podcast)
    // - int duration (durasi dalam detik)
    // - String host (nama host podcast)
    // - int episodeNumber (nomor episode)
    // - boolean isPlaying (status pemutaran)
    // - int downloadProgress (progress download 0-100)
    // - long fileSize (ukuran file dalam bytes)
    private String title;
    private int duration;
    private String host;
    private int episodeNumber;
    private boolean isPlaying;
    private int downloadProgress;
    private long fileSize;

    // TODO: Buat constructor yang menerima title, duration, host, dan episodeNumber
    /**
     * Constructor untuk membuat objek Podcast
     * Inisialisasi semua field dan atur isPlaying = false, downloadProgress = 0
     * Hitung fileSize: (duration/60) * 1024 * 1024 bytes (1MB per menit)
     * Jika episodeNumber > 100, kalikan fileSize dengan 1.5
     * 
     * @param title         judul podcast
     * @param duration      durasi podcast dalam detik
     * @param host          nama host podcast
     * @param episodeNumber nomor episode
     */
    public Podcast(String title, int duration, String host, int episodeNumber) {
        this.title = title;
        this.duration = duration;
        this.host = host;
        this.episodeNumber = episodeNumber;
        isPlaying = false;
        downloadProgress = 0;
        fileSize = (long) ((episodeNumber > 100 ? 1.5 : 1) * (duration / 60) * 1024 * 1024);
    }

    // TODO: Implementasikan semua method dari interface Playable

    /**
     * Memulai pemutaran podcast
     * Tampilkan: "Memutar podcast: [title] - Episode [episodeNumber] by [host]"
     * Ubah isPlaying menjadi true
     */
    @Override
    public void play() {
        System.out.printf("Memutar podcast: %s - Episode %d by %s\n", title, episodeNumber, host);
        isPlaying = true;
    }

    /**
     * Menghentikan sementara pemutaran podcast
     * Tampilkan: "Podcast [title] dijeda"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void pause() {
        System.out.printf("Podcast %s dijeda\n", title);
        isPlaying = false;
    }

    /**
     * Menghentikan sepenuhnya pemutaran podcast
     * Tampilkan: "Podcast [title] dihentikan"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void stop() {
        System.out.printf("Podcast %s dihentikan\n", title);
        isPlaying = false;
    }

    /**
     * Mendapatkan durasi podcast dalam detik
     * 
     * @return durasi podcast
     */
    @Override
    public int getDuration() {
        return duration;
    }

    /**
     * Mendapatkan judul podcast
     * 
     * @return judul podcast
     */
    @Override
    public String getTitle() {
        return new String(title);
    }

    /**
     * Mengecek apakah podcast sedang diputar
     * 
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    // TODO: Implementasikan semua method dari interface Downloadable

    /**
     * Memulai proses download podcast
     * Tampilkan: "Memulai download podcast: [title] Episode [episodeNumber]"
     * Set downloadProgress = 0
     * 
     * @return selalu return true
     */
    @Override
    public boolean startDownload() {
        System.out.printf("Memulai download podcast: %s Episode %d\n", title, episodeNumber);
        downloadProgress = 0;
        return true;
    }

    /**
     * Mendapatkan progress download podcast
     * Progress akan bertambah 10% setiap kali method dipanggil (lebih cepat dari
     * movie)
     * 
     * @return persentase progress (0-100)
     */
    @Override
    public int getDownloadProgress() {
        downloadProgress += 10;
        return downloadProgress;
    }

    /**
     * Membatalkan proses download podcast
     * Set downloadProgress = 0
     * Tampilkan: "Download podcast [title] dibatalkan"
     */
    @Override
    public void cancelDownload() {
        downloadProgress = 0;
        System.out.printf("Download podcast %s dibatalkan\n", title);
    }

    /**
     * Mendapatkan ukuran file podcast
     * Dihitung berdasarkan durasi (1MB per menit), 1.5x lebih besar jika episode >
     * 100
     * 
     * @return ukuran file dalam bytes
     */
    @Override
    public long getFileSize() {
        return fileSize;
    }

    /**
     * Mengecek apakah download podcast sudah selesai
     * 
     * @return true jika progress >= 100%, false jika belum
     */
    @Override
    public boolean isDownloadComplete() {
        boolean downloadCompletedStatus = false;
        if (downloadProgress >= 100) {
            downloadCompletedStatus = true;
        }
        return downloadCompletedStatus;
    }

    /**
     * Mendapatkan path lokasi download podcast
     * Ganti spasi dalam title dengan underscore
     * 
     * @return path dengan format
     *         "/downloads/podcasts/[title_tanpa_spasi]_ep[episodeNumber].mp3"
     */
    @Override
    public String getDownloadPath() {
        String sanitizedTitle = String.join("_", title.split(" "));
        return String.format("/downloads/podcasts/%s_ep%d.mp3", sanitizedTitle, episodeNumber);
    }

    // TODO: Buat method tambahan getHost() dan getEpisodeNumber()
    /**
     * Mendapatkan nama host podcast
     * 
     * @return nama host
     */
    public String getHost() {
        return new String(host);
    }

    /**
     * Mendapatkan nomor episode podcast
     * 
     * @return nomor episode
     */
    public int getEpisodeNumber() {
        return episodeNumber;
    }
}