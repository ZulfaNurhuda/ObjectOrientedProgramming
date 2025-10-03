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
}