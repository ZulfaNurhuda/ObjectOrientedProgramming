public abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int speed;

    public Vehicle(String brand, String model, int speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public abstract void move();

    public void displayInfo() {
        System.out.println("Kendaraan: " + brand + " " + model);
    }

    // TODO : Tambahkan method overloading displayInfo dengan parameter String detailLevel dan Vehicle other

    public void refuel() {
        System.out.println("Kendaraan " + brand + " " + model + " sedang mengisi bahan bakar");
    }

    // TODO : Tambahkan method overloading refuel dengan parameter String fuelType

    public String getEnergySource() {
        return "Tidak diketahui";
    }

    // TODO : Tambahkan method race dengan parameter Vehicle opponent

}