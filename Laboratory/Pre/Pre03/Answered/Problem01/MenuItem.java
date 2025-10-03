/**
 * MenuItem.java
 */

public abstract class MenuItem {
    public enum Kategori {
        MAKANAN, MINUMAN
    };

    public enum Unit {
        ML, GRAM
    };

    private String namaMenu;

    /** jumlah mililiter atau gram, tergantung unit */
    private int quantity;
    private Unit unit;
    private Kategori kategori;

    /** Pajak tetap untuk semua menu (10%). */
    private static final double TAX_RATE = 0.10;

    /** Counter total objek yang pernah dibuat. */
    private static int totalCreated = 0;

    /** Persentase promo global (0-90). */
    private static int promoPercent = 0;

    /**
     * Status happy hour (diskon ekstra 20% SETELAH promo diterapkan).
     * - true => aktif, harga setelah promo dikalikan 0.8
     * - false => nonaktif
     */
    private static boolean happyHour = false;

    /**
     * Constructor untuk membuat MenuItem baru.
     * totalCreated akan bertambah setiap kali objek dibuat.
     * Validasi quantity lebih dari sama dengan 0. Jika quantity negatif, quantity
     * akan bernilai defaultnya yaitu 100
     * 
     * For your exploration:
     * 1) Carilah cara agar string yang dimasukkan ke objek lebih bersih
     * 2) Cobalah belajar cara menggunakan ternary operation
     * 
     * @param namaMenu Nama menu
     * @param quantity Volume saji
     * @param unit     ML atau GRAM
     * @param kategori kategori menu (MAKANAN atau MINUMAN)
     */
    public MenuItem(String namaMenu, int quantity, Unit unit, Kategori kategori) {
        this.namaMenu = namaMenu.trim();
        this.quantity = (quantity >= 0) ? quantity : 100;
        this.unit = unit;
        this.kategori = kategori;
        totalCreated++;
    }

    /**
     * Getter untuk nama menu.
     * 
     * @return nama menu
     */
    public String getNamaMenu() {
        return namaMenu;
    }

    /**
     * Mendapatkan quantity menu dalam ml/gram.
     * 
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Mengembalikan unit menu ini.
     * Nilainya berupa enum Unit (bukan String).
     * 
     * @return unit menu (ML atau GRAM)
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Mengembalikan kategori menu ini.
     * Nilainya berupa enum Kategori (bukan String).
     *
     * @return kategori menu (MAKANAN atau MINUMAN)
     */
    public Kategori getKategori() {
        return kategori;
    }

    /**
     * Mendapatkan total menu yang sudah dibuat (static).
     * 
     * @return totalCreated
     */
    public static int getTotalCreated() {
        return totalCreated;
    }

    /**
     * Mengatur persentase promo global (0 - 90).
     * Aturan: hanya menerima 0 - 90. Jika di luar rentang, abaikan.
     * 
     * @param percent persentase promo
     */
    public static void setPromo(int percent) {
        if (percent >= 0 && percent <= 90) {
            promoPercent = percent;
        }
    }

    /**
     * Mengatur status happy hour (diskon ekstra 20%).
     * 
     * @param active true jika happy hour aktif
     */
    public static void setHappyHour(boolean active) {
        happyHour = active;
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
     * 3) Jika happyHour aktif, dapat diskon tambahan 20% (ingat misalnya 50% + 20%
     * bukan berarti 70% ya)
     * 4) Tambahkan pajak (berdasarkan harga sebelum diskon)
     * 5) Selalu bulatkan hasil tiap proses ke integer
     * 
     * For your exploration:
     * 1) Coba pelajari tentang penggunaan method pada Math, misalnya (Math.round,
     * Math.min, Math.max, dsb.)
     * 2) Pelajari tentang casting casting tipe data, misalnya double jadi integer,
     * dan sebagainya
     * 
     * @return harga final
     */
    public int price() {
        int base = Math.max(0, basePrice());
        double afterPromo = base * (1 - (promoPercent / 100.0));
        if (happyHour) {
            afterPromo *= 0.8;
        }
        double finalPrice = afterPromo + (base * TAX_RATE);
        return (int) Math.round(finalPrice);
    }

    /**
     * Mengembalikan simbol satuan dari unit yang dipakai.
     * Format:
     * - Jika unit = ML -> "ml"
     * - Jika unit = GRAM -> "g"
     *
     * @return string simbol unit ("ml" atau "g")
     */
    private String unitSymbol() {
        return (unit == Unit.ML) ? "ml" : "g";
    }

    /**
     * Label default menu.
     * Format: "<namaMenu> <quantity><unitSymbol>".
     * 
     * @return label string default
     */
    public String label() {
        return String.format("%s %d%s", namaMenu, quantity, unitSymbol());
    }

    /**
     * Overloading label:
     * Jika showPrice = true, kembalikan "<namaMenu> <quantity><unit> |
     * Rp<hargaFinal>"
     * Jika showPrice = false, kembalikan label() saja
     * 
     * @param showPrice tampilkan harga atau tidak
     * @return label menu (dengan atau tanpa harga)
     */
    public String label(boolean showPrice) {
        return showPrice ? String.format("%s | Rp%d", label(), price()) : label();
    }

    /**
     * Final method (tidak boleh dioverride): Mengembalikan brand tetap untuk semua
     * MenuItem.
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
        return String.format("%s %s dari %s", kategori, label(true), brand());
    }
}
