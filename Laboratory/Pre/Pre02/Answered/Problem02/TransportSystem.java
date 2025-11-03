import java.util.ArrayList;

public class TransportSystem {
    private String name;
    private ArrayList<Vehicle> vehicles;

    public TransportSystem(String name) {
        /**
         * TODO: Buatlah konstruktor untuk sistem transportasi
         */
        this.name = name;
        this.vehicles = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        /**
         * TODO: Fungsinya untuk menambahkan objek kendaraan ke list kendaraan
         */
        if (vehicle != null) {
            vehicles.add(vehicle);
        }
    }

    public Vehicle findVehicleByDriver(String driverName) {
        /**
         * TODO: Fungsi untuk mencari kendaraan berdasarkan nama dari driver,
         * kembalikan null jika tidak ditemukan
         */
        Vehicle vehicleFound = null;
        if (driverName != null) {
            for (int i = 0; i < vehicles.size() && vehicleFound == null; i++) {
                Vehicle v = vehicles.get(i);
                if (v.getDriver().getName().equals(driverName)) {
                    vehicleFound = v;
                }
            }
        }
        return vehicleFound;
    }

    public int totalPassengerCapacity() {
        /**
         * TODO: Menghitung seluruh kapasitas yang tersedia
         */
        int total = 0;
        for (Vehicle v : vehicles) {
            total += v.getCapacity();
        }
        return total;
    }

    public void showAllVehicles() {
        /**
         * TODO: Menampilkan seluruh info kendaraan dengan format
         * "=== Transport System: {name} ===
         * {info vehicles}
         * -------------------
         * {info vehicles}
         * -------------------
         * ...
         * "
         * Baris terakhir disertai garis juga yah.
         * jika kendaraan kosong, keluarkan "No vehicles in the system
         */
        if (vehicles != null && !vehicles.isEmpty()) {
            System.out.println("=== Transport System: " + name + " ===");
            for (Vehicle v : vehicles) {
                v.showInfo();
                System.out.println("-------------------");
            }
        } else {
            System.out.println("No vehicles in the system");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
