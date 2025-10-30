public class Food implements Product {
    private String name;
    private double price;
    private String expiryDate;

    /*
     * TODO: Lengkapi implementasi konstruktor Food
     * Semua attribut diinisialisasi melalui konstruktor
     */
    public Food(String name, double price, String expiryDate) {
        // TODO: Lengkapi implementasi method ini
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    /*
     * TODO: Lengkapi implementasi method getPrice
     * Method ini mengembalikan nilai price dari produk makanan
     */
    @Override
    public double getPrice() {
        // TODO: Lengkapi implementasi method ini
        return price;
    }

    /*
     * TODO: Lengkapi implementasi method getName
     * Method ini mengembalikan nilai name dari produk makanan
     */
    @Override
    public String getName() {
        // TODO: Lengkapi implementasi method ini
        return name;
    }

    /*
     * TODO: Lengkapi implementasi method getExpiryDate
     * Method ini mengembalikan nilai expiryDate dari produk makanan
     */
    public String getExpiryDate() {
        // TODO: Lengkapi implementasi method ini
        return expiryDate;
    }

    /*
     * TODO: Lengkapi implementasi method toString
     * Method ini mengembalikan representasi string dari produk makanan
     * Format: "<name> - Rp<price> (exp: <expiryDate>)"
     */
    @Override
    public String toString() {
        // TODO: Lengkapi implementasi method ini
        return name + " - Rp" + price + " (exp: " + expiryDate + ")";
    }
}
