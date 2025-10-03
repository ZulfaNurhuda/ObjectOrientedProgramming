import java.util.ArrayList;

class Cart {
    // TODO: Deklarasikan list products untuk menyimpan Product (Gunakan ArrayList)
    // TODO: Deklarasikan atribut totalPrice (double)
    private ArrayList<Product> products;
    private double totalPrice;

    // TODO: Constructor cart untuk inisialisasi list dengan list kosong dan
    // totalPrice dengan 0.0
    public Cart() {
        totalPrice = 0.0;
        products = new ArrayList<Product>();
    }

    // TODO: Buat method addProduct(Product p) untuk menambah produk ke list &
    // tambah totalPrice dengan harga produk
    public void addProduct(Product p) {
        products.add(p);
        totalPrice += p.getPrice();
    }

    // TODO: Buat method getTotalPrice() untuk mendapatkan totalPrice
    public double getTotalPrice() {
        return totalPrice;
    }

    // TODO: Buat method showCart() untuk menampilkan isi cart & total harga
    // Case 1 (jika keranjang kosong):
    // Isi Keranjang:
    // (Kosong)

    // Case 2 (jika keranjang ada isinya):
    // Isi Keranjang:
    // - Nama Produk 1 : Harga Produk 1
    // - Nama Produk 2 : Harga Produk 2
    // Total harga: totalPrice

    // Hint : Manfaatkan method toString() dari class Product
    public void showCart() {
        System.out.println("Isi Keranjang:");
        if (products.isEmpty()) {
            System.out.println("(Kosong)");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
            System.out.println("Total harga: " + totalPrice);
        }
    }

    // TODO: Buat method clearCart() untuk mengosongkan list products dan reset
    // totalPrice ke 0.0
    public void clearCart() {
        products.clear();
        totalPrice = 0.0;
    }
}