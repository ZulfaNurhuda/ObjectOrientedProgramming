/**
 * Exception checked untuk kondisi stok produk kurang dari jumlah yang diminta.
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String m){
        super(m);
    }
}