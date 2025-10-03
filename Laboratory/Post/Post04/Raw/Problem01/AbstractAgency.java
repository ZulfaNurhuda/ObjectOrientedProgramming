import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAgency implements Publisher {
    // TODO:
    // Buat variabel agencyCount yang bersifat private static dengan tipe int
    // dan agencyName yang bersifat private dengan tipe String

    private static final List<AbstractAgency> REGISTRY = new ArrayList<>();
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final List<List<String>> subscriberCategories = new ArrayList<>();

    protected AbstractAgency(String agencyName) {
        // TODO:
        // 1. Simpan nama agensi,
        // 2. Tambahkan jumlah agensi yang pernah dibuat, dan
        // 3. Daftarkan objek ini ke REGISTRY.
        //
        // KETERANGAN:
        // Gunakan method .add() untuk menambahkan objek ini ke dalam REGISTRY
        // Gunakan keyword `this` untuk mengakses objek ini
    }

    /**
     * FUNGSI getAgencyCount
     *
     * Spesifikasi: Mengembalikan jumlah objek agensi yang sudah dibuat selama
     * aplikasi berjalan.
     */
    public static int getAgencyCount() {
        // TODO: Lengkapi fungsi ini
        return 0;
    }

    /**
     * FUNGSI findByName
     *
     * Spesifikasi: Mengembalikan objek agensi yang namanya sama dengan
     * parameter, atau null bila tidak ditemukan.
     */
    public static AbstractAgency findByName(String name) {
        for (AbstractAgency agency : REGISTRY) {
            if (agency.getAgencyName().equals(name)) {
                return agency;
            }
        }
        return null;
    }

    /**
     * FUNGSI getAgencyName
     *
     * Spesifikasi: Mengembalikan nama agensi
     */
    public String getAgencyName() {
        // TODO: Lengkapi fungsi ini
        return "";
    }

    /**
     * FUNGSI getSubscribers
     *
     * Spesifikasi: Mengembalikan daftar seluruh pelanggan yang terdaftar.
     */
    public List<Subscriber> getSubscribers() {
        return Collections.unmodifiableList(subscribers);
    }

    @Override
    public void addSubscriber(Subscriber s) {
        // TODO:
        // 1. Tolak penambahan apabila subscriber sudah terdaftar dan tampilkan
        // "Agensi %s melewatkan penambahan pelanggan karena sudah terdaftar.".
        // 2. Jika belum ada, tambahkan subscriber, buat daftar kategori kosong, dan
        // tampilkan "Agensi %s menambahkan pelanggan baru.".
        // Contoh: subscribers.add(s); subscriberCategories.add(new ArrayList<>());
        // 3. Seluruh output diakhiri newline dan gunakan nama agensi saat ini untuk
        // placeholder %s.
        //
        // KETERANGAN:
        // 1. Index subscriber berkorelasi dengan index subscriberCategories,
        // subscriber ke-i akan memiliki kategori di subscriberCategories ke-i
        // 2. Gunakan method .contains(s) dari list subscriber untuk melakukan
        // pengecekan apakah subscriber sudah terdaftar atau belum
        // 3. Gunakan nama agensi untuk setiap placeholder %s dan akhiri setiap
        // output dengan newline.

    }

    @Override
    public void removeSubscriber(Subscriber s) {
        // TODO:
        // 1. Jika subscriber tidak ditemukan, tampilkan "Agensi %s tidak menemukan
        // pelanggan untuk dihapus.".
        // 2. Jika ditemukan, hapus subscriber beserta daftar kategorinya dan
        // tampilkan "Agensi %s menghapus pelanggan.".
        //
        //
        // KETERANGAN:
        // 1. Index subscriber berkorelasi dengan index subscriberCategories,
        // subscriber ke-i akan memiliki kategori di subscriberCategories ke-i
        // 2. Gunakan method .remove(index) untuk menghilangkan elemen ke-index dari
        // suatu list
        // 3. Gunakan method .indexOf(s) untuk mendapatkan index subscriber dari daftar
        // subscriber
        // 4. Gunakan nama agensi untuk setiap placeholder %s dan akhiri setiap
        // output dengan newline.
    }

    @Override
    public void broadcast(String message, String category) {
        // TODO:
        // 1. Iterasi setiap subscriber yang tersimpan.
        // 2. Hanya kirimkan pesan ke subscriber yang memiliki kategori sesuai
        //
        // KETERANGAN:
        // 1. Loop bisa dilakukan dengan: for (Subscriber subscriber : subscribers) {
        // ... }
        // 2. index subscriber berkorelasi dengan index subscriberCategories,
        // subscriber ke-i akan memiliki kategori di subscriberCategories ke-i
        // 3. Panggil receive pada subscriber yang memenuhi syarat dengan parameter

    }

    public void publishUpdate(String message, String category) {
        // TODO:
        // 1. Tampilkan "Agensi %s menyiarkan pembaruan kategori '%s': %s" sebelum
        // melakukan broadcast.
        // 2. Setelah mencetak pesan, panggil broadcast
    }

    /**
     * FUNGSI assignCategoryToSubscriber
     *
     * Spesifikasi: Menambahkan kategori baru ke subscriber yang sudah terdaftar dan
     * mengembalikan true bila berhasil.
     */
    public boolean assignCategoryToSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null || category.isEmpty()) {
            return false;
        }

        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }

        List<String> categories = subscriberCategories.get(index);
        if (categories.contains(category)) {
            return false;
        }
        categories.add(category);
        return true;
    }

    /**
     * FUNGSI removeCategoryFromSubscriber
     *
     * Spesifikasi: Menghapus kategori pada subscriber dan mengembalikan true hanya
     * jika kategori tersebut ada.
     */
    public boolean removeCategoryFromSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null) {
            return false;
        }
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        boolean removed = categories.remove(category);
        if (!removed) {
            return false;
        }
        return true;
    }

    /**
     * FUNGSI hasCategoryForSubscriber
     *
     * Spesifikasi: Mengembalikan true jika subscriber memiliki kategori yang
     * tertentu pada agensi ini.
     */
    public boolean hasCategoryForSubscriber(Subscriber subscriber, String category) {
        if (subscriber == null || category == null) {
            return false;
        }
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        return categories.contains(category);
    }

    /**
     * FUNGSI hasCategoriesForSubscriber
     *
     * Spesifikasi: Mengembalikan true apabila subscriber memiliki setidaknya satu
     * kategori aktif pada agensi ini.
     */
    public boolean hasCategoriesForSubscriber(Subscriber subscriber) {
        int index = subscribers.indexOf(subscriber);
        if (index < 0) {
            return false;
        }
        List<String> categories = subscriberCategories.get(index);
        return !categories.isEmpty();
    }
}
