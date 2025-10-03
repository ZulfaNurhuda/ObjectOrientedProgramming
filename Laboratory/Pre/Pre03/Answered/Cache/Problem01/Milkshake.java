/**
 * Milkshake.java
 * 
 */
public class Milkshake extends MenuItem {
    public enum Ukuran {
        SMALL, MEDIUM, LARGE
    }

    private String jenis;
    private boolean iceCreamTopping;
    private Ukuran ukuran;

    /**
     * Constructor Milkshake.
     *
     * For your exploration:
     * - Untuk enum, jangan lupa gunakan EnumName.VALUE
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set
     * jenis menjadi "Original"
     *
     * @param volumeMl        volume minuman dalam ml
     * @param jenis           jenis milkshake (contoh: "Strawberry")
     * @param iceCreamTopping true jika ada topping es krim tambahan
     * @param ukuran          ukuran milkshake (SMALL, MEDIUM, LARGE)
     */
    public Milkshake(int volumeMl, String jenis, boolean iceCreamTopping, Ukuran ukuran) {
        super("Milkshake", volumeMl, Unit.ML, Kategori.MINUMAN);
        setJenis(jenis);
        this.iceCreamTopping = iceCreamTopping;
        this.ukuran = ukuran;
    }

    /**
     * Getter untuk jenis milkshake.
     *
     * @return jenis milkshake
     */
    public String getJenis() {
        return this.jenis;
    }

    /**
     * Setter untuk jenis milkshake.
     * 
     * - Pastikan input jenis milkshake bersih dengan menggunakan .trim()
     * - Pastikan nama jenis milkshake tidak null/kosong, jika null/kosong, set
     * jenis menjadi "Original"
     *
     * @param jenis jenis milkshake baru
     */
    public void setJenis(String jenis) {
        if (jenis == null || jenis.trim().isEmpty()) {
            this.jenis = "Original";
        } else {
            this.jenis = jenis.trim();
        }
    }

    /**
     * Getter untuk iceCreamTopping.
     *
     * @return iceCreamTopping
     */
    public boolean hasIceCreamTopping() {
        return this.iceCreamTopping;
    }

    /**
     * Setter untuk status topping es krim.
     * 
     * @param iceCreamTopping true jika ada topping
     */
    public void setIceCreamTopping(boolean iceCreamTopping) {
        this.iceCreamTopping = iceCreamTopping;
    }

    /**
     * Getter untuk ukuran milkshake.
     *
     * @return ukuran milkshake
     */
    public Ukuran getUkuran() {
        return this.ukuran;
    }

    /**
     * Setter untuk ukuran milkshake.
     *
     * @param ukuran ukuran milkshake baru
     */
    public void setUkuran(Ukuran ukuran) {
        this.ukuran = ukuran;
    }

    /**
     * Override basePrice() dari MenuItem.
     * Aturan harga dasar:
     * - SMALL = 10000
     * - MEDIUM = 13000
     * - LARGE = 15000
     * Tambahan:
     * - Jika iceCreamTopping = true, tambahkan 5000
     *
     * @return harga dasar milkshake
     */
    @Override
    public int basePrice() {
        int price = 0;
        switch (this.ukuran) {
            case SMALL:
                price = 10000;
                break;
            case MEDIUM:
                price = 13000;
                break;
            case LARGE:
                price = 15000;
                break;
        }
        if (this.iceCreamTopping) {
            price += 5000;
        }
        return price;
    }

    /**
     * Override label() dari MenuItem.
     * Format contoh:
     * - "Milkshake Strawberry [MEDIUM] 250ml" (jika iceCreamTopping = false)
     * - "Milkshake Strawberry Float [MEDIUM] 250ml" (jika iceCreamTopping = true)
     *
     * @return label string untuk milkshake
     */
    @Override
    public String label() {
        String floatLabel = hasIceCreamTopping() ? " Float" : "";
        return String.format("%s %s%s [%s] %d%s",
                getNamaMenu(), getJenis(), floatLabel, getUkuran(), getQuantity(), "ml");
    }
}
