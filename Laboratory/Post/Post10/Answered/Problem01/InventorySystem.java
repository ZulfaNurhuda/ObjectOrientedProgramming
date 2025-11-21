import java.util.Random;

public class InventorySystem {
    private final int[] bins = new int[10];
    private final int[] data;

    /**
     * Membuat dataset acak yang akan diproses oleh para worker.
     * Elemen pada array akan memiliki rentang nilai 0..99.
     */
    public InventorySystem(int dataSize, long seed) {
        this.data = new int[dataSize];
        Random rand = new Random(seed);
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(100);
        }
    }

    /**
     * Mengambil nilai pada indeks tertentu dari dataset dengan delay waktu.
     */
    public int getValueAt(int index) {
        induceDelay();
        return data[index];
    }

    /**
     * Menambahkan satu unit ke bin tertentu.
     */
    public void addToBin(int binIndex) {
        bins[binIndex] = bins[binIndex] + 1;
    }

    /**
     * Menuliskan hasil akhir seluruh bin ke stdout.
     */
    public void generateReport() {
        int total = 0;
        for (int i = 0; i < bins.length; i++) {
            String line = "Bin " + i + ": " + bins[i];
            System.out.println(line);
            total += bins[i];
        }
        System.out.println("Total Processed: " + total);
    }

    /**
     * Menambahkan delay buatan untuk setiap akses data.
     */
    private void induceDelay() {
        try {
            Thread.sleep(5); // Sleep for 5ms
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
