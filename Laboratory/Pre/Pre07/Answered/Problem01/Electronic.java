public class Electronic implements Product {
    private String name;
    private double price;
    private int warrantyMonths;

    /* 
     * TODO: Lengkapi implementasi konstruktor Electronic 
     * Semua attribut diinisialisasi melalui konstruktor
    */
    public Electronic(String name, double price, int warrantyMonths) {
        // TODO: Lengkapi implementasi konstruktor ini
        this.name = name;
        this.price = price;
        this.warrantyMonths = warrantyMonths;
    }

    /*
     * TODO: Lengkapi implementasi method getPrice
     * Method ini mengembalikan nilai price dari produk elektronik
     */
    @Override
    public double getPrice() {
        // TODO: Lengkapi implementasi method ini
        return price;
    }

    /*
     * TODO: Lengkapi implementasi method getName
     * Method ini mengembalikan nilai name dari produk elektronik
     */
    @Override
    public String getName() {
        // TODO: Lengkapi implementasi method ini
        return name;
    }

    /*
     * TODO: Lengkapi implementasi method getWarrantyMonths
     * Method ini mengembalikan nilai warrantyMonths dari produk elektronik
     */
    public int getWarrantyMonths() {
        // TODO: Lengkapi implementasi method ini
        return warrantyMonths;
    }

    /*
     * TODO: Lengkapi implementasi method toString
     * Method ini mengembalikan representasi string dari produk elektronik
     * Format: "<name> - Rp<price> (<warrantyMonths> months warranty)"
     */
    @Override
    public String toString() {
        // TODO: Lengkapi implementasi method ini
        return name + " - Rp" + price + " (" + warrantyMonths + " months warranty)";
    }
}
