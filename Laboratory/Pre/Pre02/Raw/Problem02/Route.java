public class Route {
    private String startPoint;
    private String destination;
    private int distance; 
    private int averageSpeed;

    public Route(String startPoint, String destination, int distance, int averageSpeed) {
	/**
	 * TODO: Buatlah konstruktor untuk kelas route ini
	 * */
    }

    public void showRoute() {
	    /**
	     * TODO: Menampilkan informasi rute dengan format,
	     * 		"{startPoint} >> {destination} ({distance} km)
	     * 		Estimasi waktu tempuh: {time} jam"
	     * 		Waktu tempuh ditulis sampai 1 angka di belakang koma.
	     * */
    }

    public double estimateTravelTime() {
	    /**
	     * TODO: Fungsi ini memprediksi berapa lama rute ditempuh dengan 
	     * kecepatan rata rata
	     * */
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }

    public int getAverageSpeed() {
        return averageSpeed;
    }
}
