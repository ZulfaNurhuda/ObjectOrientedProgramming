public class EWallet extends Pembayaran {
    public EWallet(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    @Override
    public double hitungTotal() {
        return jumlah + (jumlah * 0.01);
    }
}
