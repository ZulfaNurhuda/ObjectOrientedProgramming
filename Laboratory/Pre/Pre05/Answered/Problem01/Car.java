class Car extends Vehicle {
    protected int fuelLevel;

    public Car(String brand, String model, int speed, int fuelLevel) {
        super(brand, model, speed);
        this.fuelLevel = fuelLevel;
    }

    public void refuel(int liter) {
        System.out.println("Mobil " + brand + " mengisi bensin sebanyak " + liter + " liter");
    }

    // TODO : Tambahkan method yang hilang di kelas ini
    @Override
    public void move() {
        System.out.println(brand + " " + model + " (mobil bensin) melaju dengan kecepatan " + speed + " km/h");
    }

    @Override
    public String getEnergySource() {
        return "Bensin";
    }

    @Override
    public void refuel() {
        System.out.println("Mobil " + brand + " " + model + " mengisi bensin. Level saat ini: " + fuelLevel + "%");
    }
}