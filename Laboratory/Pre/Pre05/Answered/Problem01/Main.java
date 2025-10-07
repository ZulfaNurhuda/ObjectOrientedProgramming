public class Main {
    public static void main(String[] args) {

        Vehicle v1 = new Car("Toyota", "Avanza", 120, 70);
        Vehicle v2 = new ElectricCar("Tesla", "Model 3", 150, 80);
        Vehicle v3 = new Hybrid("Esemka", "Bima", 130, 60, 50);

        v1.move();
        v2.move();
        v3.move(); 

        v1.displayInfo(); 
        v1.displayInfo("Full Detail"); 
        v1.displayInfo(v2);

        v1.refuel();
        v2.refuel();
        v3.refuel();
        v1.refuel("Pertamax");

        // TODO : Inisialiasi e
        ElectricCar e = new ElectricCar("Tesla", "Model 3", 140, 60);
        e.recharge(30);
        e.recharge("Fast Mode");
    
        // TODO : Inisialiasi h
        Hybrid h = new Hybrid("Esemka", "Bima", 120, 50, 50);
        h.switchMode();
        h.switchMode("Sport");
        
        v1.race(v2);
        v2.race(v3);
        v3.race(v1);

        Vehicle[] garage = { v1, v2, v3 };
        for (Vehicle vehicle : garage) {
            System.out.println("Tipe energi: " + vehicle.getEnergySource());
            vehicle.move();
        }

        ((Car) v1).refuel(20); // TODO : casting v1 dengan benar
    }
}
