class TabletDevice implements ITablet {
    private String brand;
    private String model;
    private double price;
    private boolean isOn;
    private String operatingSystem;

    /* Konstruktor */
    public TabletDevice(String brand, String model, double price, String operatingSystem) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.operatingSystem = operatingSystem;
        this.isOn = false;
        System.out.println("Tablet " + brand + " " + model + " created.");
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

    public void installSoftware(String software) {
        System.out.printf("Installing %s on %s %s\n", software, brand, model);
    }

    public void openApplication(String appName) {
        System.out.printf("Opening %s\n", appName);
    }

    public String getOperatingSystem() {
        return new String(operatingSystem);
    }

    public void usePen() {
        System.out.printf("Using pen on %s %s\n", brand, model);
    }

    public void rotateScreen() {
        System.out.printf("Screen rotated on %s %s\n", brand, model);
    }
}