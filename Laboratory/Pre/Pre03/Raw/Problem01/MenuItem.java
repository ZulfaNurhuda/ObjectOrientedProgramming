/**
 * MenuItem.java
 */

 public abstract class MenuItem {
    public enum Kategori { MAKANAN, MINUMAN };
    public enum Unit { ML, GRAM };
    
    private String namaMenu;

    /** jumlah mililiter atau gram, tergantung unit */
    private int quantity;
    private Unit unit;
    private Kategori kategori;

    /** Pajak tetap untuk semua menu (10%). */
    private static final double TAX_RATE = 0.10;
    
    /** Counter total objek yang pernah dibuat. */
    private static int totalCreated;

    /** Persentase promo global (0-90). */
    private static int promoPercent;
    
    /**
     * Status happy hour (diskon ekstra 20% SETELAH promo diterapkan).
     * - true  => aktif, harga setelah promo dikalikan 0.8
     * - false => nonaktif
     */
    private static boolean happyHour;

    /**
     * Constructor untuk membuat MenuItem baru.
     * totalCreated akan bertambah setiap kali objek dibuat.
     * Validasi quantity lebih dari sama dengan 0. Jika quantity negatif, quantity akan bernilai defaultnya yaitu 100
     * 
     * For your exploration: 
     * 1) Carilah cara agar string yang dimasukkan ke objek lebih bersih
     * 2) Cobalah belajar cara menggunakan ternary operation
     * 
     * @param namaMenu  Nama menu
     * @param quantity  Volume saji 
     * @param unit      ML atau GRAM
     * @param kategori  kategori menu (MAKANAN atau MINUMAN)
     */
    public MenuItem(String namaMenu, int quantity, Unit unit, Kategori kategori) {

    }

    /**
     * Getter untuk nama menu.
     * 
     * @return nama menu
     */
    public String getNamaMenu() {

    }

    /**
     * Mendapatkan quantity menu dalam ml/gram.
     * 
     * @return quantity
     */
    public int getQuantity() {

    }

    /**
     * Mengembalikan unit menu ini.
     * Nilainya berupa enum Unit (bukan String).
     * 
     * @return unit menu (ML atau GRAM)
     */
    public Unit getUnit() {
        
    }

    /**
     * Mengembalikan kategori menu ini.
     * Nilainya berupa enum Kategori (bukan String).
     *
     * @return kategori menu (MAKANAN atau MINUMAN)
     */
    public Kategori getKategori() {
        
    }

    /**
     * Mendapatkan total menu yang sudah dibuat (static).
     * 
     * @return totalCreated
     */
    public static int getTotalCreated() {

    }

    /**
     * Mengatur persentase promo global (0 - 90).
     * Aturan: hanya menerima 0 - 90. Jika di luar rentang, abaikan.
     * 
     * @param percent persentase promo
     */
    public static void setPromo(int percent) {

    }

    /**
     * Mengatur status happy hour (diskon ekstra 20%).
     * 
     * @param active true jika happy hour aktif
     */
    public static void setHappyHour(boolean active) {

    }

    /**
     * Menghasilkan harga dasar (sebelum promo & pajak) untuk menu ini.
     * Method abstrak WAJIB dioverride oleh subclass.
     * 
     * @return harga dasar menu
     */
    public abstract int basePrice();

    /**
     * Menghitung harga final setelah promo, happy hour, dan pajak.
     * 
     * Aturan perhitungan (WAJIB diikuti):
     * 1) Ambil harga dasarnya (paling minimum harga dasar dibikin 0)
     * 2) Terapkan promoPercent
     * 3) Jika happyHour aktif, dapat diskon tambahan 20% (ingat misalnya 50% + 20% bukan berarti 70% ya)
     * 4) Tambahkan pajak (berdasarkan harga sebelum diskon)
     * 5) Selalu bulatkan hasil tiap proses ke integer
     * 
     * For your exploration:
     * 1) Coba pelajari tentang penggunaan method pada Math, misalnya (Math.round, Math.min, Math.max, dsb.)
     * 2) Pelajari tentang casting casting tipe data, misalnya double jadi integer, dan sebagainya
     * 
     * @return harga final
     */
    public int price() {

    }

    /**
     * Mengembalikan simbol satuan dari unit yang dipakai.
     * Format:
     * - Jika unit = ML   -> "ml"
     * - Jika unit = GRAM -> "g"
     *
     * @return string simbol unit ("ml" atau "g")
     */
    private String unitSymbol() { 
        
    }

    /**
     * Label default menu.
     * Format: "<namaMenu> <quantity><unitSymbol>".
     * 
     * @return label string default
     */
    public String label() {

    }

    /**
     * Overloading label:
     * Jika showPrice = true, kembalikan "<namaMenu> <quantity><unit> | Rp<hargaFinal>"
     * Jika showPrice = false, kembalikan label() saja
     * 
     * @param showPrice tampilkan harga atau tidak
     * @return label menu (dengan atau tanpa harga)
     */
    public String label(boolean showPrice) {

    }

    /**
     * Final method (tidak boleh dioverride): Mengembalikan brand tetap untuk semua MenuItem.
     * 
     * @return string brand
     */
    public final String brand() {
        return "Kantin Kampus";
    }

    /**
     * Representasi string dari MenuItem dengan format:
     * "<kategori> <namaMenu> <quantity><unit> | Rp<harga final> dari <brand>"
     * 
     * @return string representasi menu
     */
    @Override
    public String toString() {
        
    }
}
