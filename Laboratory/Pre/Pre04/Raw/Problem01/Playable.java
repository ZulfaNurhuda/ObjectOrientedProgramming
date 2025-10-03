public interface Playable {
    /**
     * Memulai pemutaran konten media
     * Mengubah status playing menjadi true dan menampilkan pesan yang sesuai
     */
    void play();

    /**
     * Menghentikan sementara pemutaran konten
     * Mengubah status playing menjadi false tanpa mereset posisi
     */
    void pause();

    /**
     * Menghentikan sepenuhnya pemutaran konten
     * Mengubah status playing menjadi false dan mereset ke posisi awal
     */
    void stop();

    /**
     * Mendapatkan durasi total konten dalam detik
     * @return durasi konten dalam detik, atau -1 jika tidak terbatas (live stream)
     */
    int getDuration();

    /**
     * Mendapatkan judul konten media
     * @return string yang berisi judul konten
     */
    String getTitle();

    /**
     * Mengecek apakah konten sedang dalam status diputar
     * @return true jika konten sedang diputar, false jika tidak
     */
    boolean isPlaying();
}