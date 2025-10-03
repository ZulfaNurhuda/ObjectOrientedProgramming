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
}