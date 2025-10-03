import java.lang.System;
import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Baca jumlah pembeli (N)
        // HINT: Perhatikan input setelah N ini
        int N = sc.nextInt();
        sc.nextLine();

        int i = 0;
        while (i < N) {
            // TODO: Baca data pembeli (nama, nomorMeja, saldo)
            // HINT: Perhatikan input setelah data pembeli ini
            String nama = sc.nextLine();
            int nomorMeja = sc.nextInt();
            double saldo = sc.nextDouble();
            sc.nextLine();

            // TODO: Baca data order makanan (namaMakanan, jumlah, hargaSatuan)
            // HINT: Perhatikan input setelah data order makanan ini
            String namaMakanan = sc.nextLine();
            int jumlah = sc.nextInt();
            double hargaSatuan = sc.nextDouble();
            sc.nextLine();

            // TODO: Buat objek Pembeli dan OrderMakanan
            Pembeli pembeli = new Pembeli(nama, nomorMeja, saldo);
            OrderMakanan order = new OrderMakanan(namaMakanan, jumlah, hargaSatuan);

            
            // TODO: Cetak laporan pembeli i
            // HINT: Perhatikan lagi format output yang diharapkan
            System.out.printf("=== Pembeli %d ===\n", i + 1);
            System.out.printf("Nama: %s (Meja %d)\n", pembeli.getNamaPembeli(), pembeli.getNomorMeja());
            System.out.printf("Pesanan: %s x %d @ %.1f\n", order.getNamaMakanan(), order.getcountMakanan(), order.getHargaSatuan());
            System.out.printf("Total: %.1f\n", order.getTotalHarga());

            // TODO: Cek apakah pembeli bisa membayar sendiri pesanannya
            if (pembeli.cekBisaBayar(order)) {
                System.out.print("Bisa Bayar: Bisa\n");
                
                // TODO: Jika bisa bayar, kurangi saldo pembeli
                double sisaSaldo = pembeli.getSaldo() - order.getTotalHarga();
                pembeli.setSaldo(sisaSaldo);
                
                System.out.printf("Saldo setelah bayar: %.1f\n", pembeli.getSaldo());
            } else {
                // HINT: Jika pembeli tidak bisa membayar, tidak perlu tampilkan saldo setelah
                // bayar
                System.out.print("Bisa Bayar: Gak Bisa\n");
            }

            System.out.println();

            i++;
        }

        sc.close();
    }
}