public class Answer {
    /*
     * Implementasikan skenario berikut pada metode runUrAnswer():
     * 
     * Sistem operasi memiliki tiga proses: P0, P1, dan P2.
     * Dengan satu CPU:"CPU" dan dua perangkat I/O: "IO0" dan "IO1".
     * Setiap proses memerlukan akses ke sumber daya CPU dan sumber daya I/O untuk menyelesaikan tugasnya.
     * Proses P0 dan P2 berbagi sumber daya I/O yang sama (IO0), 
     *      sedangkan P1 menggunakan sumber daya I/O yang berbeda (IO1).
     * Proses dieksekusi secara berurutan: P0, diikuti oleh P1, dan akhirnya P2.
     * Namun, selama eksekusi P2, proses ini diinterupsi saat mencoba mengakses sumber daya I/O.
     * Tugas Anda adalah mensimulasikan skenario ini menggunakan kelas ProcessTask dan Resource.
     * Contoh output yang diharapkan ada pada file output.txt
     */
    public static void runUrAnswer() {
        Resource cpu = new Resource("CPU");
        Resource io0 = new Resource("IO0");
        Resource io1 = new Resource("IO1");

        ProcessTask p0 = new ProcessTask("P0", cpu, io0);
        ProcessTask p1 = new ProcessTask("P1", cpu, io1);
        ProcessTask p2 = new ProcessTask("P2", cpu, io0);

        try {
            p0.start();
            p0.join();

            p1.start();
            p1.join();

            p2.start();
            Thread.sleep(125);
            p2.interrupt();
            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
