/**
 * Model produk sederhana dengan id unik dan stok yang dapat berubah.
 */
public class Product {
    private final String id;
    private int stock;

    /**
     * Membuat produk baru.
     * @param id id unik
     * @param stock stok awal
     */
    public Product(String id, int stock){ 
        this.id=id;
        this.stock=stock;
    }

    /**
     * @return id produk
     */
    public String getId(){
        return id;
    }
    
    /**
     * @return stok saat ini
     */
    public int getStock(){
        return stock;
    }

    /**
     * Mengurangi stok sebesar qty.
     */
    public void reduce(int qty){
        stock -= qty;
    }

    /**
     * Menambah stok sebesar qty.
     */
    public void add(int qty){
        stock += qty;
    }
}
