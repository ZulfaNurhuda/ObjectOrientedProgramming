import java.util.ArrayList;
import java.util.List;

public class Section<T extends Product> {
    private String name;
    private List<T> products;

    /*
     * TODO: Lengkapi implementasi konstruktor Section
     * Semua attribut diinisialisasi melalui konstruktor.
     * Attribut products diinisialisasi sebagai ArrayList kosong.
     */
    public Section(String name) {
        // TODO: Lengkapi implementasi method ini
        this.name = name;
        products = new ArrayList<T>();
    }

    /*
     * TODO: Lengkapi implementasi method addProduct
     * Method ini akan menambahkan produk ke dalam list products
     */
    public void addProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        products.add(product);
    }
    
    /*
     * TODO: Lengkapi implementasi method removeProduct
     * Method ini akan menghapus produk dari dalam list products
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found"
     */
    public void removeProduct(T product) {
        // TODO: Lengkapi implementasi method ini
        if (!products.remove(product)) {
            System.out.println("Product not found");
        }
    }

    /*
     * TODO: Lengkapi implementasi method getProducts
     * Method ini akan mengembalikan list produk yang ada di dalam section
     */
    public List<T> getProducts() {
        // TODO: Lengkapi implementasi method ini
        return products;
    }

    /*
     * TODO: Lengkapi implementasi method getName
     * Method ini akan mengembalikan nama dari section
     */
    public String getName() {
        // TODO: Lengkapi implementasi method ini
        return name;
    }

    /*
     * TODO: Lengkapi implementasi method getProductWithNameAndType
     * Method ini akan mengembalikan produk berdasarkan nama dan tipe produk
     * Jika produk tidak ditemukan, tampilkan pesan "Product not found".
     * Jika produk ditemukan, tampilkan representasi string dari produk tersebut dan kembalikan produk tersebut.
     */
    public T getProductWithNameAndType(String name, Class<? extends T> type) {
        // TODO: Lengkapi implementasi method ini
        T foundProduct = null;
        for (int i = 0; i < products.size() && foundProduct == null; i++) {
            T product = products.get(i);
            if (product.getName().equals(name) && type.isInstance(product)) {
                foundProduct = product;
            }
        }

        if (foundProduct == null) {
            System.out.println("Product not found");
        } else {
            System.out.println(foundProduct);
        }

        return foundProduct;
    }

    /*
     * TODO: Lengkapi implementasi method getTotalValue
     * Method ini akan mengembalikan total nilai dari semua produk yang ada di dalam section
     */
    public double getTotalValue() {
        // TODO: Lengkapi implementasi method ini
        double totalValue = 0;
        for (T product : products) {
            totalValue += product.getPrice();
        }
        return totalValue;
    }

    /*
     * TODO: Lengkapi implementasi method findCheapest
     * Method ini akan mencari produk dengan harga terendah dari dalam list
     */
    public static <U extends Product> U findCheapest(List<? extends U> list) {
        // TODO: Lengkapi implementasi method ini
        if (list == null || list.isEmpty()) {
            return null;
        }
        U cheapestProduct = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            U product = list.get(i);
            if (product.getPrice() < cheapestProduct.getPrice()) {
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }

    /*
     * TODO: Lengkapi implementasi method showProducts
     * Method ini akan menampilkan semua produk yang ada di dalam list.
     * Setiap produk ditampilkan dalam baris baru dengan menggunakan representasi string dari produk tersebut.
     */
    public static void showProducts(List<? extends Product> items) {
        // TODO: Lengkapi implementasi method ini
        for (Product item : items) {
            System.out.println(item);
        }
    }
}
