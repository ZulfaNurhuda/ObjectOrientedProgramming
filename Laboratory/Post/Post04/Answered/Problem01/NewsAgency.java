public class NewsAgency extends AbstractAgency {
    public NewsAgency(String agencyName) {
        super(agencyName);
    }

    /**
     * FUNGSI publishNews
     *
     * Spesifikasi: Menyebarkan pesan berita dan meneruskannya ke mekanisme
     * publikasi
     * agensi menggunakan kategori yang sama.
     */
    public void publishNews(String message, String category) {
        // TODO: Panggil publishUpdate
        publishUpdate(message, category);
    }
}
