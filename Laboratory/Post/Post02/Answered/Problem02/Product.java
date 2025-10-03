class Product {
    // TODO: Deklarasikan atribut: name (String), price (double)
    private String name;
    private double price;

    // TODO: Constructor untuk inisialisasi name dan price
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // TODO: Buat method getName() untuk mendapatkan nama produk
    public String getName() {
        return name;
    }

    // TODO: Buat method getPrice() untuk mendapatkan harga produk
    public double getPrice() {
        return price;
    }

    // TODO: Override method toString() untuk menampilkan informasi produk
    // Format: "- name : price"
    public String toString() {
        return "- " + name + " : " + price;
    }
}