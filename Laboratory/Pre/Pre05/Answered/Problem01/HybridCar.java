public class HybridCar extends Hybrid {
    /********************************************************************
     * Tujuan file ini adalah sebagai "ALIASES" untuk "class Hybrid"    *
     * dikarenakan Makefile pada grader membutuhkan file "Hybrid.java", *
     * tapi Main file pada grader membutuhkan "class HybridCar"         *
     ********************************************************************/
    public HybridCar(String brand, String model, int speed, int fuelLevel, int batteryLevelHybrid) {
        super(brand, model, speed, fuelLevel, batteryLevelHybrid);
    }

    /** No implementation needed! */
}
