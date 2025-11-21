class BinWorker implements Runnable {
    private final InventorySystem inventory;
    private final int start;
    private final int end;

    public BinWorker(InventorySystem inventory, int start, int end) {
        this.inventory = inventory;
        this.start = start;
        this.end = end;
    }

    /**
     * TODO: Lengkapi fungsi run dibawah ini
     *
     * Langkah-langkah:
     * 1. Iterasi i dari start hingga end - 1.
     * 2. Ambil nilai menggunakan inventory.getValueAt(i)
     * 3. Hitung indeks bin dengan value / 10.
     * 5. Panggil inventory.addToBin(binIndex) untuk mencatat frekuensi.
     *
     * Catatan: Perhatikan bahwa beberapa thread mungkin memanggil fungsi addToBin
     * secara bersamaan
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("Belum diimplementasikan");
    }
}
