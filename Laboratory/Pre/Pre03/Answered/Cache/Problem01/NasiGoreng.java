import java.util.ArrayList;

/**
 * NasiGoreng.java
 *
 * Subclass dari MenuItem untuk makanan Nasi Goreng.
 */
public class NasiGoreng extends MenuItem {
    /**
     * PAHAMI CARA MEMBUAT ArrayList<String>, biar terbiasa.
     */
    private ArrayList<String> topping;
    private boolean pedas;

    /**
     * Constructor NasiGoreng.
     * 
     * For your exploration:
     * - Untuk enum, jangan lupa gunakan EnumName.VALUE
     * - Pastikan porsiGram tidak negatif, jika negatif, set porsiGram menjadi 100
     *
     * @param porsiGram jumlah porsi dalam gram (akan disimpan sebagai quantity
     *                  dengan unit GRAM)
     * @param pedas     true jika nasi goreng pedas
     */
    public NasiGoreng(int porsiGram, boolean pedas) {
        super("Nasi Goreng", porsiGram, Unit.GRAM, Kategori.MAKANAN);
        this.pedas = pedas;
        this.topping = new ArrayList<>();
    }

    /**
     * Menambahkan satu topping (diabaikan jika null/kosong setelah trim).
     *
     * For your exploration:
     * - Pelajari method pada ArrayList, misalnya add(), remove(), clear(), dll.
     *
     * @param t nama topping (contoh: "Telur", "Ayam", "Sosis")
     */
    public void addTopping(String t) {
        if (t != null && !t.trim().isEmpty()) {
            this.topping.add(t.trim());
        }
    }

    /**
     * Menghapus satu topping (hanya menghapus satu kemunculan).
     *
     * For your exploration:
     * - Pelajari method pada ArrayList, misalnya add(), remove(), clear(), dll.
     * - Pastikan input topping bersih dengan menggunakan .trim()
     *
     * @param t nama topping yang ingin dihapus
     * @return true jika ada yang terhapus, false jika tidak ditemukan/invalid
     */
    public boolean removeTopping(String t) {
        t = (t != null) ? t.trim() : "";
        return this.topping.remove(t);
    }

    /**
     * Mengosongkan seluruh topping.
     */
    public void clearTopping() {
        this.topping.clear();
    }

    /**
     * Mengembalikan daftar topping (read-only view).
     *
     * @return ArrayList<String> dari topping
     */
    public ArrayList<String> getTopping() {
        return this.topping;
    }

    /**
     * Mengecek apakah nasi goreng pedas.
     *
     * @return true jika pedas
     */
    public boolean isPedas() {
        return this.pedas;
    }

    /**
     * Mengatur level pedas.
     *
     * @param pedas true untuk pedas, false untuk tidak pedas
     */
    public void setPedas(boolean pedas) {
        this.pedas = pedas;
    }

    /**
     * Harga dasar Nasi Goreng.
     * 
     * Aturan contoh (WAJIB diikuti di implementasi):
     * - base = 15000
     * - +3000 untuk setiap topping
     * - +2000 jika pedas = true
     *
     * @return harga dasar (>= 0)
     */
    @Override
    public int basePrice() {
        int price = 15000;
        price += this.topping.size() * 3000;
        if (this.pedas) {
            price += 2000;
        }
        return price;
    }

    /**
     * Label khusus Nasi Goreng.
     *
     * Format:
     * - Jika topping kosong -> "Nasi Goreng Original <Pedas/Tidak Pedas>
     * <quantity>g"
     * - Jika ada topping -> "Nasi Goreng <topping1> <topping2> ... <Pedas/Tidak
     * Pedas> <quantity>g"
     *
     * Contoh:
     * - "Nasi Goreng Original Pedas 500g"
     * - "Nasi Goreng Ayam Telur Tidak Pedas 300g"
     *
     * Tips:
     * - Gunakan loop for-each untuk menambahkan semua nama topping, dipisah spasi.
     * - Akhiri dengan status pedas dan jumlah gram.
     *
     * @return label string
     */
    @Override
    public String label() {
        StringBuilder labelBuilder = new StringBuilder(getNamaMenu());
        if (topping.isEmpty()) {
            labelBuilder.append(" Original");
        } else {
            for (String t : topping) {
                labelBuilder.append(" ").append(t);
            }
        }
        labelBuilder.append(isPedas() ? " Pedas" : " Tidak Pedas");
        labelBuilder.append(String.format(" %dg", getQuantity()));
        return labelBuilder.toString();
    }
}
