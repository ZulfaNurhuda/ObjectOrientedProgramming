/**
 * Class Movie - Template
 *
 * Kelas ini merepresentasikan film yang tersedia di platform streaming.
 * Film dapat diputar dan juga dapat diunduh untuk ditonton offline.
 */

public class Movie implements Playable, Downloadable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul film)
    // - int duration (durasi dalam detik)
    // - long fileSize (ukuran file dalam bytes)
    // - String genre (genre film)
    // - boolean isPlaying (status pemutaran)
    // - int downloadProgress (progress download 0-100)

    // TODO: Buat constructor yang menerima title, duration, fileSize, dan genre
    /**
     * Constructor untuk membuat objek Movie
     * Inisialisasi semua field dan atur isPlaying = false, downloadProgress = 0
     * Jika genre adalah "Premium", kalikan fileSize dengan 2
     * @param title judul film
     * @param duration durasi film dalam detik
     * @param fileSize ukuran file dasar dalam bytes
     * @param genre genre film ("Premium" akan menggandakan ukuran file)
     */

    // TODO: Implementasikan semua method dari interface Playable

    /**
     * Memulai pemutaran film
     * Tampilkan: "Memutar film: [title]"
     * Ubah isPlaying menjadi true
     */
    @Override
    public void play() {
    }

    /**
     * Menghentikan sementara pemutaran film
     * Tampilkan: "Film [title] dijeda"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void pause() {
    }

    /**
     * Menghentikan sepenuhnya pemutaran film
     * Tampilkan: "Film [title] dihentikan"
     * Ubah isPlaying menjadi false
     */
    @Override
    public void stop() {
    }

    /**
     * Mendapatkan durasi film dalam detik
     * @return durasi film
     */
    @Override
    public int getDuration() {
    }

    /**
     * Mendapatkan judul film
     * @return judul film
     */
    @Override
    public String getTitle() {
    }

    /**
     * Mengecek apakah film sedang diputar
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
    }

    // TODO: Implementasikan semua method dari interface Downloadable

    /**
     * Memulai proses download film
     * Tampilkan: "Memulai download film: [title]"
     * Set downloadProgress = 0
     * @return selalu return true
     */
    @Override
    public boolean startDownload() {
    }

    /**
     * Mendapatkan progress download film
     * Progress akan bertambah 5% setiap kali method dipanggil
     * @return persentase progress (0-100)
     */
    @Override
    public int getDownloadProgress() {
    }

    /**
     * Membatalkan proses download film
     * Set downloadProgress = 0
     * Tampilkan: "Download film [title] dibatalkan"
     */
    @Override
    public void cancelDownload() {
    }

    /**
     * Mendapatkan ukuran file film
     * Ukuran akan 2x lebih besar jika genre adalah "Premium"
     * @return ukuran file dalam bytes
     */
    @Override
    public long getFileSize() {
    }

    /**
     * Mengecek apakah download film sudah selesai
     * @return true jika progress >= 100%, false jika belum
     */
    @Override
    public boolean isDownloadComplete() {
    }

    /**
     * Mendapatkan path lokasi download film
     * Ganti spasi dalam title dengan underscore
     * @return path dengan format "/downloads/movies/[title_tanpa_spasi].mp4"
     */
    @Override
    public String getDownloadPath() {
    }

    // TODO: Buat method tambahan getGenre() untuk mendapatkan genre film
    /**
     * Mendapatkan genre film
     * @return genre film
     */
    public String getGenre() {
    }
}