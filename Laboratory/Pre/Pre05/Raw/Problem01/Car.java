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
}