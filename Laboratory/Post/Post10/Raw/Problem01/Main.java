import java.util.Scanner;

public class Main {
    private static final long DATA_SEED = 42L;

    public static void main(String[] args) throws InterruptedException {
        Config config = readConfiguration();
        InventorySystem inventory = new InventorySystem(config.dataLength, DATA_SEED);

        int threadCount = config.threadCount;
        Thread[] threads = new Thread[threadCount];
        int chunkSize = (int) Math.ceil((double) config.dataLength / threadCount);

        /**
         * TODO: Implementasikan logika eksekusi multithread berikut.
         *
         * Langkah-langkah:
         * 1. Untuk setiap thread, hitung indeks start dan end berdasarkan chunkSize.
         * Berikut adalah kode bantuan untuk digunakan:
         * int start = i * chunkSize;
         * int end = Math.min(start + chunkSize, config.dataLength);
         *
         * 2. Lewati thread yang tidak memiliki data (start >= end).
         * 3. Buat objek Thread dengan BinWorker yang menerima inventory, start, dan
         * end.
         * 4. Mulai setiap thread.
         * 5. Pastikan seluruh data selesai diproses sebelum lanjut ke generateReport().
         */

        // TODO: Tuliskan implementasi pembuatan dan sinkronisasi thread di sini.

        inventory.generateReport();
    }

    private static Config readConfiguration() {
        Scanner scanner = new Scanner(System.in);
        int dataLength = readNextInt(scanner);
        int threadCount = readNextInt(scanner);
        return new Config(Math.max(0, dataLength), threadCount);
    }

    private static int readNextInt(Scanner scanner) {
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            scanner.next();
        }
        return 0;
    }

    private static final class Config {
        final int dataLength;
        final int threadCount;

        Config(int dataLength, int threadCount) {
            this.dataLength = dataLength;
            this.threadCount = threadCount;
        }
    }
}
