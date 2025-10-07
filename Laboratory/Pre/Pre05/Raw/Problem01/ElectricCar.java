class ElectricCar extends Vehicle {
    private int batteryLevel;

    public ElectricCar(String brand, String model, int speed, int batteryLevel) {
        super(brand, model, speed);
        this.batteryLevel = batteryLevel;
    }

    public void recharge(int durationMinutes) {
        System.out.println("Mobil " + brand + " " + model + " mengisi daya selama " + durationMinutes + " menit");
    }

    // TODO : Tambahkan method yang hilang di kelas ini
}