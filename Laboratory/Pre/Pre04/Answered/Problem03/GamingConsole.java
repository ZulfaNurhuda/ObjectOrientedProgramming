class GamingConsole implements IGadget {
    private String brand;
    private String model;
    private double price;
    private boolean isOn;

    /* Konstruktor */
    public GamingConsole(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isOn = false;
        System.out.println("Gaming Console " + brand + " " + model + " created.");
    }

    public void turnOn() {
        isOn = true;
        System.out.printf("%s %s is now ON\n", brand, model);
    }

    public void turnOff() {
        isOn = false;
        System.out.printf("%s %s is now OFF\n", brand, model);
    }

    public String getInfo() {
        String info;
        if (isOn) {
            info = "[ON] " + brand + " " + model + " - Rp " + price;
        } else {
            info = "[OFF] " + brand + " " + model + " - Rp " + price;
        }
        return info;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return new String(brand);
    }

    // Gaming Console specific method
    /**
     * Memainkan game pada konsol
     * Menampilkan pesan "Playing [gameName] on [brand] [model]"
     * 
     * @param gameName
     */
    public void playGame(String gameName) {
        System.out.printf("Playing %s on %s %s\n", gameName, brand, model);
    }
}