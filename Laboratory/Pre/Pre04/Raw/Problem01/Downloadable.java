public interface Downloadable {
    /**
     * Memulai proses download konten
     * Menginisialisasi progress download dan menampilkan pesan konfirmasi
     * @return true jika download berhasil dimulai, false jika gagal
     */
    boolean startDownload();

    /**
     * Mendapatkan persentase progress download saat ini
     * Progress akan bertambah setiap kali method ini dipanggil (simulasi)
     * @return nilai progress antara 0-100 (persen)
     */
    int getDownloadProgress();

    /**
     * Membatalkan proses download yang sedang berjalan
     * Mereset progress ke 0 dan menampilkan pesan pembatalan
     */
    void cancelDownload();

    /**
     * Mendapatkan ukuran total file dalam bytes
     * Ukuran dapat bervariasi berdasarkan tipe konten dan kualitas
     * @return ukuran file dalam bytes
     */
    long getFileSize();

    /**
     * Mengecek apakah proses download sudah selesai
     * @return true jika progress sudah mencapai 100%, false jika belum
     */
    boolean isDownloadComplete();

    /**
     * Mendapatkan lokasi path tempat file akan disimpan
     * Format path disesuaikan dengan tipe konten (movie/podcast)
     * @return string path lokasi file download
     */
    String getDownloadPath();
}