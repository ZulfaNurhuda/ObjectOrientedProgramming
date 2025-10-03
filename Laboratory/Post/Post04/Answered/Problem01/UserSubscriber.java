import java.util.ArrayList;
import java.util.List;

/**
 * Merepresentasikan pengguna yang dapat berlangganan pada berbagai agensi dan
 * menerima pesan sesuai preferensi.
 *
 * TODO: Kelas ini harus mengimplementasikan interface Subscriber
 */
public class UserSubscriber implements Subscriber {
    // TODO:
    // Buat variabel userCount yang bersifat private static dengan tipe int
    // dan name yang bersifat private dengan tipe String

    private static int userCount;
    private String name;

    private final List<SubscriptionPreference> preferences = new ArrayList<>();

    /**
     * FUNGSI UserSubscriber
     *
     * Spesifikasi: Menyimpan nama pengguna, menambah jumlah pengguna
     */
    public UserSubscriber(String name) {
        // TODO:
        // Simpan parameter name ke atribut, tambah userCount
        this.name = name;
        userCount++;
    }

    /**
     * FUNGSI getUserCount
     *
     * Spesifikasi: Mengembalikan jumlah pengguna yang pernah dibuat.
     */
    public static int getUserCount() {
        // TODO: Kembalikan jumlah pengguna yang disimpan
        return userCount;
    }

    /**
     * FUNGSI getName
     *
     * Spesifikasi: Mengembalikan nama pengguna yang terdaftar.
     */
    public String getName() {
        // TODO: Kembalikan nilai atribut name milik objek ini.
        return name;
    }

    /**
     * FUNGSI addCategoryPreference
     *
     * Spesifikasi: Menambahkan atau memperbarui preferensi kategori pada agensi
     * tertentu.
     */
    public void addCategoryPreference(String agencyName, String category, DeliveryMethod method) {
        AbstractAgency agency = AbstractAgency.findByName(agencyName);
        if (agency == null) {
            System.out.printf(
                    "Pengguna %s tidak menemukan agensi bernama %s.%n",
                    this.name,
                    agencyName);
            return;
        }

        if (!agency.getSubscribers().contains(this)) {
            System.out.printf(
                    "Pengguna %s belum terdaftar sebagai pelanggan agensi %s, kategori '%s' tidak ditambahkan.%n",
                    this.name,
                    agencyName,
                    category);
            return;
        }

        // TODO:
        // 1. Jika kategori berhasil ditambahkan dan belum ada di preferensi, keluarkan:
        // "Pengguna %s menambahkan kategori '%s' untuk agensi %s dengan metode %s."
        // 2. Jika kategori gagal ditambahkan, keluarkan: "Pengguna %s
        // tidak dapat menambahkan kategori '%s' ke agensi %s."

        // KETERANGAN:
        // 1. Gunakan findOrCreatePreference atau findPreference dari
        // SubscriptionPreference
        // 2. Gunakan method .add(preferenceBaru) untuk menambahkan preference baru ke
        // list of preference

        SubscriptionPreference preference = findOrCreatePreference(agencyName);
        preference.setDeliveryMethod(method);
        boolean added = preference.addCategory(category);
        if (added) {
            System.out.printf("Pengguna %s menambahkan kategori '%s' untuk agensi %s dengan metode %s.%n", this.name,
                    category, agencyName, method);
        }
    }

    /**
     * FUNGSI removeCategoryPreference
     *
     * Spesifikasi: Menghapus kategori tertentu dari preferensi pengguna pada
     * agensi.
     */
    public void removeCategoryPreference(String agencyName, String category) {
        // TODO:
        // 1. Gunakan findPreference untuk memperoleh preferensi agensi
        // 2. Jika preferensi tidak ditemukan, keluarkan: "Pengguna %s belum memiliki
        // preferensi untuk agensi %s, kategori '%s' diabaikan."
        // 3. Jika kategori tidak ditemukan dipreferensi, keluarkan: "Pengguna %s tidak
        // menemukan kategori '%s' pada agensi %s."
        // 4. Jika penghapusan gagal, keluarkan: "Pengguna %s tidak dapat menghapus
        // kategori '%s' dari agensi %s."
        // 5. Jika berhasil, keluarkan: "Pengguna %s menghapus kategori '%s' dari agensi
        // %s."

        // KETERANGAN:
        // 1. Manfaatkan fungsi yang tersedia dari SubscriptionPreference untuk
        // melengkapi fungsi ini

        SubscriptionPreference preference = findPreference(agencyName);
        if (preference == null) {
            System.out.printf("Pengguna %s belum memiliki preferensi untuk agensi %s, kategori '%s' diabaikan.%n", name,
                    agencyName, category);
            return;
        }
        boolean removed = preference.removeCategory(category);
        if (removed) {
            System.out.printf("Pengguna %s menghapus kategori '%s' dari agensi %s.%n", name, category, agencyName);
        } else {
            System.out.printf("Pengguna %s tidak menemukan kategori '%s' pada agensi %s.%n", name, category,
                    agencyName);
        }
    }

    /**
     * FUNGSI setDeliveryMethod
     *
     * Spesifikasi: Mengubah metode pengiriman untuk suatu agensi bila berbeda dari
     * sebelumnya.
     */
    public void setDeliveryMethod(String agencyName, DeliveryMethod method) {
        // TODO:
        // 1. Ambil preferensi agensi menggunakan findPreference dan bandingkan metode
        // saat ini dengan parameter.
        // 2. Apabila agensi tidak ditemukan, keluarkan: "Preferensi untuk agensi %s
        // tidak ditemukan sehingga perubahan metode tidak bisa dilakukan.%n"
        // 3. Apabila metode saat ini sama dengan metode baru, keluarkan: "Pengguna %s
        // tetap menggunakan metode %s untuk agensi %s."
        // 4. Apabila berhail dan metode berbeda dari yang sebelumnya, keluarkan:
        // "Pengguna %s mengubah metode agensi %s dari %s menjadi %s."

        // KETERANGAN:
        // 1. Pengecekan kesamaan metode pengiriman dapat dilakukan dengan menggunakan
        // '=='

        SubscriptionPreference preference = findPreference(agencyName);
        if (preference == null) {
            System.out.printf(
                    "Preferensi untuk agensi %s tidak ditemukan sehingga perubahan metode tidak bisa dilakukan.%n",
                    agencyName);
            return;
        }
        DeliveryMethod current = preference.getDeliveryMethod();
        if (current == method) {
            System.out.printf("Pengguna %s tetap menggunakan metode %s untuk agensi %s.%n", name, method, agencyName);
        } else {
            preference.setDeliveryMethod(method);
            System.out.printf("Pengguna %s mengubah metode agensi %s dari %s menjadi %s.%n", name, agencyName, current,
                    method);
        }
    }

    /**
     * FUNGSI receive
     *
     * Spesifikasi: User menerima pesan dari agensi
     */
    @Override
    public void receive(String agencyName, String message, String category) {
        // TODO:
        // 1. Ambil preferensi berdasarkan nama agensi dan pastikan kategori dimiliki
        // oleh user
        // 2. Bila valid, cetak "[%s] dari %s melalui %s - %s: %s" menggunakan nama
        // pengguna, nama agensi, metode, kategori, dan pesan.
        // 3. Jika tidak valid, jangan tampilkan apa pun.

        // KETERANGAN:
        // 1. Manfaatkan fungsi - fungsi yang tersedia untuk melengkapi fungsi ini

        SubscriptionPreference preference = findPreference(agencyName);
        if (preference != null && preference.acceptsCategory(category)) {
            System.out.printf("[%s] dari %s melalui %s - %s: %s%n", getName(), agencyName,
                    preference.getDeliveryMethod(), category, message);
        }
    }

    /**
     * FUNGSI findOrCreatePreference
     *
     * Spesifikasi: Mengembalikan preferensi yang cocok dengan agensi atau membuat
     * baru dengan metode delivery default yaitu APP.
     */
    private SubscriptionPreference findOrCreatePreference(String agencyName) {
        SubscriptionPreference preference = findPreference(agencyName);
        if (preference == null) {
            preference = new SubscriptionPreference(this, agencyName, DeliveryMethod.APP);
            preferences.add(preference);
        }
        return preference;
    }

    /**
     * FUNGSI findPreference
     *
     * Spesifikasi: Mengembalikan preferensi berdasarkan nama agensi atau null jika
     * belum ada.
     */
    private SubscriptionPreference findPreference(String agencyName) {
        for (SubscriptionPreference preference : preferences) {
            if (preference.getAgencyName().equals(agencyName)) {
                return preference;
            }
        }
        return null;
    }
}
