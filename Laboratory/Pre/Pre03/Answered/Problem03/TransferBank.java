public class TransferBank extends Pembayaran {
    public TransferBank(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }

    @Override
    public double hitungTotal() {
        return jumlah + 4000;
    }
}
