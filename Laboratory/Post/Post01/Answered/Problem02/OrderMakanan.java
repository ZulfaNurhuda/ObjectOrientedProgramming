public class OrderMakanan {
    private String namaMakanan;
    private int countMakanan;
    private double hargaSatuan;

    /**
     * Konstruktor OrderMakanan
     * 
     * @param nama
     * @param count
     * @param harga
     */
    public OrderMakanan(String nama, int count, double harga) {
        // TODO: inisialisasi atribut
        namaMakanan = nama;
        countMakanan = count;
        hargaSatuan = harga;
    }

    /**
     * getNamaMakanan
     * 
     * @return namaMakanan
     */
    public String getNamaMakanan() {
        // TODO: return namaMakanan
        return namaMakanan;
    }

    /**
     * setNamaMakanan
     * 
     * @param namaBaru
     */
    public void setNamaMakanan(String namaBaru) {
        // TODO: ubah nilai namaMakanan
        namaMakanan = namaBaru;
    }

    /**
     * getcountMakanan
     * 
     * @return countMakanan
     */
    public int getcountMakanan() {
        // TODO: return countMakanan
        return countMakanan;
    }

    /**
     * setcountMakanan
     * 
     * @param countBaru
     */
    public void setcountMakanan(int countBaru) {
        // TODO: ubah nilai countMakanan
        countMakanan = countBaru;
    }

    /**
     * getHargaSatuan
     * 
     * @return hargaSatuan
     */
    public double getHargaSatuan() {
        // TODO: return hargaSatuan
        return hargaSatuan;
    }

    /**
     * setHargaSatuan
     * 
     * @param hargaBaru
     */
    public void setHargaSatuan(double hargaBaru) {
        // TODO: ubah nilai hargaSatuan
        hargaSatuan = hargaBaru;
    }

    /**
     * increasecountMakanan
     * Menambahkan countMakanan pesanan
     * 
     * @param tambahan
     */
    public void increasecountMakanan(int tambahan) {
        // TODO: tambahkan nilai countMakanan dengan tambahan
        // Hint: hanya jika tambahan > 0
        if (tambahan > 0) {
            countMakanan += tambahan;
        }
    }

    /**
     * decreasecountMakanan
     * Mengurangi countMakanan pesanan
     * 
     * @param pengurangan
     */
    public void decreasecountMakanan(int pengurangan) {
        // TODO: kurangi nilai countMakanan dengan pengurangan
        // Hint: hanya jika pengurangan > 0
        if (pengurangan > 0) {
            countMakanan -= pengurangan;
        }
    }

    /**
     * getTotalHarga
     * Menghitung total harga pesanan
     * 
     * @return totalHarga
     */
    public double getTotalHarga() {
        // TODO: hitung total harga pesanan
        return countMakanan * hargaSatuan;
    }
}