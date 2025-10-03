
public class LiveStream implements Playable {
    // TODO: Buat field-field yang diperlukan:
    // - String title (judul live stream)
    // - String streamerName (nama streamer)
    // - int viewerCount (jumlah penonton)
    // - boolean isLive (status apakah sedang live)
    // - boolean isPlaying (status pemutaran)
    // - int updateCounter (counter untuk update viewer count)
    private String title;
    private String streamerName;
    private int viewerCount;
    private boolean isLive;
    private boolean isPlaying;
    private int updateCounter;

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
        this.title = title;
        this.streamerName = streamerName;
        this.viewerCount = viewerCount;
        this.isLive = isLive;
        isPlaying = false;
        updateCounter = 0;
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
        if (isLive) {
            updateViewerCount();
            System.out.printf("Menonton live stream: %s by %s - %d viewers\n", title, streamerName, viewerCount);
            isPlaying = true;
        } else {
            System.out.println("Stream sudah berakhir");
            isPlaying = false;
        }
    }

    /**
     * Tidak bisa pause live stream
     * Tampilkan: "Live stream tidak bisa dijeda, gunakan stop() untuk keluar"
     */
    @Override
    public void pause() {
        System.out.println("Live stream tidak bisa dijeda, gunakan stop() untuk keluar");
    }

    /**
     * Keluar dari live stream
     * Tampilkan: "Keluar dari live stream [title]"
     * Ubah isPlaying menjadi false
     * Panggil updateViewerCount()
     */
    @Override
    public void stop() {
        System.out.printf("Keluar dari live stream %s\n", title);
        isPlaying = false;
        updateViewerCount();
    }

    /**
     * Mendapatkan durasi live stream
     * 
     * @return -1 (live stream tidak memiliki durasi tetap)
     */
    @Override
    public int getDuration() {
        return -1;
    }

    /**
     * Mendapatkan judul live stream
     * 
     * @return judul live stream
     */
    @Override
    public String getTitle() {
        return new String(title);
    }

    /**
     * Mengecek apakah live stream sedang diputar
     * 
     * @return true jika sedang diputar, false jika tidak
     */
    @Override
    public boolean isPlaying() {
        return isPlaying;
    }

    // TODO: Implementasikan method tambahan khusus untuk LiveStream

    /**
     * Mengecek apakah live stream masih live
     * 
     * @return true jika masih live, false jika sudah berakhir
     */
    public boolean isLive() {
        return isLive;
    }

    /**
     * Mendapatkan nama streamer
     * 
     * @return nama streamer
     */
    public String getStreamerName() {
        return new String(streamerName);
    }

    /**
     * Mendapatkan jumlah penonton saat ini
     * 
     * @return jumlah penonton
     */
    public int getViewerCount() {
        return viewerCount;
    }

    /**
     * Update jumlah penonton
     * Increment updateCounter
     * Hitung perubahan: (updateCounter % 11) - 5 (range: -5 sampai +5)
     * Update viewerCount: Math.max(0, viewerCount + change)
     */
    public void updateViewerCount() {
        updateCounter++;
        int change = (updateCounter % 11) - 5;
        viewerCount = Math.max(0, viewerCount + change);
    }

    /**
     * Mengakhiri live stream
     * Ubah isLive menjadi false dan isPlaying menjadi false
     * Tampilkan: "Live stream [title] telah berakhir"
     */
    public void endStream() {
        isLive = false;
        isPlaying = false;
        System.out.printf("Live stream %s telah berakhir\n", title);
    }
}