/**
 * Exception checked untuk kasus produk tidak ditemukan pada pencarian.
 */
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String m){ 
        super(m);
    }
}