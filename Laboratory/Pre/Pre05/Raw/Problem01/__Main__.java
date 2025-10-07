public class __Main__ {
    public static void main(String[] args) {

        Vehicle v1 = new Car("adsfaedf", "dvewasdfs", 1200, 90);
        Vehicle v2 = new ElectricCar("u83wh8a", "dfiwndssf", 150, 80);
        Vehicle v3 = new HybridCar("fjwa39dssak", "adfjie9di", 130, 30, 57);

        v1.move();
        v2.move();
        v3.move();

        v1.displayInfo();
        v1.displayInfo("asda9shj");
        v1.displayInfo(v2);

        v1.refuel();
        v2.refuel();
        v3.refuel();
        v1.refuel("diiiis");

        // TODO : Inisialiasi e
        ElectricCar e = new ElectricCar("u83wh8a", "dfiwndssf", 150, 80);
        e.recharge(20);
        e.recharge("asdwdaosdjajd");

        // TODO : Inisialiasi h
        HybridCar h = new HybridCar("fjwa39dssak", "adfjie9di", 130, 30, 57);
        h.switchMode();
        h.switchMode("d88dhaka");

        v1.race(v2);
        v2.race(v3);
        v3.race(v1);

        Vehicle[] garage = { v1, v2, v3 };
        for (Vehicle vehicle : garage) {
            System.out.println("Tsss: " + vehicle.getEnergySource());
            vehicle.move();
        }

        ((Car) v1).refuel(50); // TODO : casting v1 dengan benar
    }
}
