public class COD extends Pembayaran {
    public COD(String namaPelanggan, double jumlah) {
        super(namaPelanggan, jumlah);
    }
    
    @Override
    public double hitungTotal() {
        return jumlah + 5000;
    }    
}
