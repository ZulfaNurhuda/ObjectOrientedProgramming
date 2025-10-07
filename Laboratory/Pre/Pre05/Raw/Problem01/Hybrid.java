class HybridCar extends Car {
    private int batteryLevelHybrid;

    public HybridCar(String brand, String model, int speed, int fuelLevel, int batteryLevelHybrid) {
        super(brand, model, speed, fuelLevel);
        this.batteryLevelHybrid = batteryLevelHybrid;
    }

    public void switchMode() {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode hemat energi");
    }

    // TODO : Tambahkan method yang hilang di kelas ini
}