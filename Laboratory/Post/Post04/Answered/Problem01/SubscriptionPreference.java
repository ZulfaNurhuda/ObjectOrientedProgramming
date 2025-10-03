/**
 * Menyimpan preferensi satu subscriber terhadap agensi tertentu beserta metode
 * pengiriman dan daftar kategorinya.
 */
public class SubscriptionPreference {
    private final UserSubscriber subscriber;
    private final String agencyName;
    private DeliveryMethod deliveryMethod;

    /**
     * FUNGSI SubscriptionPreference
     *
     * Spesifikasi: Membuat preferensi baru dengan subscriber tertentu, nama agensi
     * target, dan metode pengiriman.
     */
    public SubscriptionPreference(UserSubscriber subscriber, String agencyName, DeliveryMethod deliveryMethod) {
        this.subscriber = subscriber;
        this.agencyName = agencyName;
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * FUNGSI getAgencyName
     *
     * Spesifikasi: Mengembalikan nama agensi yang diasosiasikan dengan preferensi
     * ini
     */
    public String getAgencyName() {
        return agencyName;
    }

    /**
     * FUNGSI getDeliveryMethod
     *
     * Spesifikasi: Mengembalikan metode pengiriman yang saat ini digunakan untuk
     * agensi ini.
     */
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * FUNGSI setDeliveryMethod
     *
     * Spesifikasi: Memperbarui metode pengiriman yang digunakan untuk agensi ini.
     */
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * FUNGSI addCategory
     *
     * Spesifikasi: Menambahkan kategori baru untuk subscriber pada agensi ini dan
     * mengembalikan true bila berhasil.
     */
    public boolean addCategory(String category) {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        if (agency == null) {
            return false;
        }
        return agency.assignCategoryToSubscriber(subscriber, category);
    }

    /**
     * FUNGSI removeCategory
     *
     * Spesifikasi: Menghapus kategori dari preferensi dan mengembalikan true bila
     * kategori tersebut ada dan berhasil dihapus.
     */
    public boolean removeCategory(String category) {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        if (agency == null) {
            return false;
        }
        return agency.removeCategoryFromSubscriber(subscriber, category);
    }

    /**
     * FUNGSI acceptsCategory
     *
     * Spesifikasi: Melakukan pengecekan apakah subscriber menerima kategori
     * tertentu untuk
     * agensi ini.
     */
    public boolean acceptsCategory(String category) {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        if (agency == null) {
            return false;
        }
        return agency.hasCategoryForSubscriber(subscriber, category);
    }

    /**
     * FUNGSI hasNoCategories
     *
     * Spesifikasi: Mengembalikan true bila subscriber belum memiliki kategori apa
     * pun pada agensi ini.
     */
    public boolean hasNoCategories() {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        return agency == null || !agency.hasCategoriesForSubscriber(subscriber);
    }
}
