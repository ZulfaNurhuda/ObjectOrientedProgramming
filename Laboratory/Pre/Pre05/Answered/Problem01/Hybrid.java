class Hybrid extends Car {
    private int batteryLevelHybrid;

    public Hybrid(String brand, String model, int speed, int fuelLevel, int batteryLevelHybrid) {
        super(brand, model, speed, fuelLevel);
        this.batteryLevelHybrid = batteryLevelHybrid;
    }

    public void switchMode() {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode hemat energi");
    }

    public void switchMode(String mode) {
        System.out.println("Mobil " + brand + " " + model + " beralih ke mode " + mode);
    }

    // TODO : Tambahkan method yang hilang di kelas ini
    @Override
    public void move() {
        System.out.println(brand + " " + model + " (mobil hybrid) menggunakan kombinasi bensin dan baterai (" + fuelLevel + "% / " + batteryLevelHybrid + "%)");
    }

    @Override
    public String getEnergySource() {
        return "Hybrid (Bensin + Listrik)";
    }
}