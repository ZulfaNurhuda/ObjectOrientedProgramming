import java.util.ArrayList;

public class TransportSystem {
    private String name;
    private ArrayList<Vehicle> vehicles;

    public TransportSystem(String name) {
  	/**
	 * TODO: Buatlah konstruktor untuk sistem transportasi
	 * */ 
    }

    public void addVehicle(Vehicle vehicle) {
       	/**
	 * TODO: Fungsinya untuk menambahkan objek kendaraan ke list kendaraan 
	 * */ 
    }

    public Vehicle findVehicleByDriver(String driverName) {
	/**
	 * TODO: Fungsi untuk mencari kendaraan berdasarkan nama dari driver, 
	 * kembalikan nulljika tidak ditemukan
	 * */
    }

    public int totalPassengerCapacity() {
	/**
	 * TODO: Menghitung seluruh kapasitas yang tersedia
	 * */	
    }

    public void showAllVehicles() {
        /**
	 * TODO: Menampilkan seluruh info kendaraan dengan format
	 * 	"=== Transport System: {name} ===
	 * 	{info vehicles}
	 *	-------------------
	 *	{info vehicles}
	 *	-------------------
	 *	...
	 *	"
	 *	Baris terakhir disertai garis juga yah.
	 *	jika kendaraan kosong, keluarkan "No vehicles in the system
	 * */
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
