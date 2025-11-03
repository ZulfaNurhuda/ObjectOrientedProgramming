public class Route {
    private String startPoint;
    private String destination;
    private int distance;
    private int averageSpeed;

    public Route(String startPoint, String destination, int distance, int averageSpeed) {
        /**
         * TODO: Buatlah konstruktor untuk kelas route ini
         */
        this.startPoint = startPoint;
        this.destination = destination;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }

    public void showRoute() {
        /**
         * TODO: Menampilkan informasi rute dengan format,
         * "{startPoint} >> {destination} ({distance} km)
         * Estimasi waktu tempuh: {time} jam"
         * Waktu tempuh ditulis sampai 1 angka di belakang koma.
         */
        System.out.println(startPoint + " >> " + destination + " (" + distance + " km)");
        double time = estimateTravelTime();
        if (time >= 0) {
            System.out.printf("Estimasi waktu tempuh: %.1f jam\n", time);
        } else {
            System.out.println("Estimasi waktu tempuh: invalid (averageSpeed <= 0)");
        }
    }

    public double estimateTravelTime() {
        /**
         * TODO: Fungsi ini memprediksi berapa lama rute ditempuh dengan
         * kecepatan rata rata
         */
        double totalTime = -1.0;
        if (averageSpeed > 0) {
            totalTime = (double) distance / (double) averageSpeed;
        }
        return totalTime;
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
