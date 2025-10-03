class Smartphone implements IMobileDevice {
    private String brand;
    private String model;
    private double price;
    private boolean isOn;

    /* Konstruktor */
    public Smartphone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.isOn = false;
        System.out.println("Smartphone " + brand + " " + model + " created.");
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

    public void makeCall(String number) {
        System.out.printf("Calling %s from %s %s\n", number, brand, model);
    }

    public void sendMessage(String message) {
        System.out.printf("Sending message: %s\n", message);
    }

    public void connectToWifi(String networkName) {
        System.out.printf("Connected to %s\n", networkName);
    }
}