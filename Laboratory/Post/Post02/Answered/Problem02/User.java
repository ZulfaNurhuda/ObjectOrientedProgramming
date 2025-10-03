class User {
    // TODO: Deklarasikan atribut: name (String), balance (double), cart (Cart)
    // TODO: Deklarasikan atribut static totalUserTransactions (int) untuk melacak
    // total transaksi semua user, nilai awal 0
    private String name;
    private double balance;
    private Cart cart;
    private static int totalUserTransactions = 0;

    // TODO: Constructor untuk inisialisasi name, balance, dan cart baru (cart
    // awalnya kosong)
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    // TODO: Buat method untuk menambahkan produk ke cart
    public void addToCart(Product p) {
        cart.addProduct(p);
    }

    // TODO: Buat method checkout() untuk melakukan pembelian (cart tidak mungkin
    // kosong)
    // - jika balance >= totalPrice cart, kurangi saldo dengan totalPrice cart dan
    // kosongkan cart. Tambahkan totalUserTransactions dengan 1
    // - jika saldo kurang, cetak "Saldo tidak cukup"
    public void checkout() {
        double totalPrice = cart.getTotalPrice();
        if (balance >= totalPrice) {
            balance -= totalPrice;
            cart.clearCart();
            totalUserTransactions++;
        } else {
            System.out.println("Saldo tidak cukup");
        }
    }

    // TODO: Buat method showProfile() untuk menampilkan profil.
    // Format:
    // User: <name>, Saldo: <balance>
    // Lalu tampilkan cart (gunakan method showCart())
    public void showProfile() {
        System.out.println("User: " + name + ", Saldo: " + balance);
        cart.showCart();
    }

    // TODO: Buat method getTotalUserTransactions() untuk mendapatkan
    // totalUserTransactions
    public static int getTotalUserTransactions() {
        return totalUserTransactions;
    }
}