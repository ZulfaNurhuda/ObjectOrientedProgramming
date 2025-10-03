
public class LiveStream implements Playable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul live stream)
    // - String streamerName (nama streamer)
    // - int viewerCount (jumlah penonton)
    // - boolean isLive (status apakah sedang live)
    // - boolean isPlaying (status pemutaran)
    // - int updateCounter (counter untuk update viewer count)

    // TODO: Buat constructor yang menerima title, streamerName, viewerCount, dan
    // isLive
    /**
     * Constructor untuk membuat objek LiveStream
     * Inisialisasi semua field dan atur isPlaying = false, updateCounter = 0
     * 
     * @param title        judul live stream
     * @param streamerName nama streamer
     * @param viewerCount  jumlah penonton saat ini
     * @param isLive       status apakah sedang live
     */
    public LiveStream(String title, String streamerName, int viewerCount, boolean isLive) {
    }

    // TODO: Implementasikan semua method dari interface Playable

    /**
     * Memulai menonton live stream
     * Jika isLive = true:
     * - Panggil updateViewerCount()
     * - Tampilkan: "Menonton live stream: [title] by [streamerName] - [viewerCount]
     * viewers"
     * - Ubah isPlaying menjadi true
     * Jika isLive = false:
     * - Tampilkan: "Stream sudah berakhir"
     * - Ubah isPlaying menjadi false
     */
    @Override
    public void play() {
    }

    /**
     * Tidak bisa pause live stream
     * Tampilkan: "Live stream tidak bisa dijeda, gunakan stop() untuk keluar"
     */
    @Override
    public void pause() {
    }

    /**
     * Keluar dari live stream
     * Tampilkan: "Keluar dari live stream [title]"
     * Ubah isPlaying menjadi false
     * Panggil updateViewerCount()
     */
    @Override
    public void stop() {
    }

    /**
     * Mendapatkan durasi live stream
     * 
     * @return -1 (live stream tidak memiliki durasi tetap)
     */
    @Override
    public int getDuration() {
    }

    /**
     * Mendapatkan judul live stream
     * 
     * @return judul live stream
     */
    @Override
    public String getTitle() {
    }

    /**
     * Mengecek apakah live stream sedang diputar
     * 
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
    }

    // TODO: Implementasikan method tambahan khusus untuk LiveStream

    /**
     * Mengecek apakah live stream masih live
     * 
     * @return true jika masih live, false jika sudah berakhir
     */
    public boolean isLive() {
    }

    /**
     * Mendapatkan nama streamer
     * 
     * @return nama streamer
     */
    public String getStreamerName() {
    }

    /**
     * Mendapatkan jumlah penonton saat ini
     * 
     * @return jumlah penonton
     */
    public int getViewerCount() {
    }

    /**
     * Update jumlah penonton
     * Increment updateCounter
     * Hitung perubahan: (updateCounter % 11) - 5 (range: -5 sampai +5)
     * Update viewerCount: Math.max(0, viewerCount + change)
     */
    public void updateViewerCount() {
    }

    /**
     * Mengakhiri live stream
     * Ubah isLive menjadi false dan isPlaying menjadi false
     * Tampilkan: "Live stream [title] telah berakhir"
     */
    public void endStream() {
    }
}