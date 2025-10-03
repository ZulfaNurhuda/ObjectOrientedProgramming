class Laptop implements IDesktop {
    private String brand;
    private String model;
    private double price;
    private boolean isOn;
    private String operatingSystem;

    /* Konstruktor */
    public Laptop(String brand, String model, double price, String operatingSystem) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.isOn = false;
        System.out.println("Laptop " + brand + " " + model + " created.");
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

    public void installSoftware(String softwareName) {
        System.out.printf("Installing %s on %s %s\n", softwareName, brand, model);
    }

    public void openApplication(String appName) {
        System.out.printf("Opening %s\n", appName);
    }

    public String getOperatingSystem() {
        return new String(operatingSystem);
    }
}