public abstract class Pembayaran {
    protected String namaPelanggan;
    protected double jumlah;

    public Pembayaran(String namaPelanggan, double jumlah) {
        this.namaPelanggan = namaPelanggan;
        this.jumlah = jumlah;
    } 

    public abstract double hitungTotal();

    public String getNamaPelanggan() {
        return namaPelanggan;
    }
}
