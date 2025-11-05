import java.util.Scanner;

public class BankDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankSystem system = new BankSystem(5);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistem Bank ===");
            System.out.println("1. Tambah Akun Baru");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Tampilkan Semua Akun");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Nama pemilik: ");
                        String name = sc.nextLine();
                        System.out.print("Saldo awal: ");
                        double initial = Double.parseDouble(sc.nextLine());
                        system.addAccount(new BankAccount(name, initial));
                        System.out.println("Akun berhasil dibuat.");
                        break;

                    case 2:
                        System.out.print("Nama akun: ");
                        String depName = sc.nextLine();
                        BankAccount depAcc = system.findAccount(depName);
                        if (depAcc == null)
                            throw new NullPointerException("Akun tidak ditemukan.");
                        System.out.print("Nominal deposit: ");
                        double depAmt = Double.parseDouble(sc.nextLine());
                        depAcc.deposit(depAmt);
                        System.out.println("Deposit berhasil.");
                        break;

                    case 3:
                        System.out.print("Nama akun: ");
                        String wdName = sc.nextLine();
                        BankAccount wdAcc = system.findAccount(wdName);
                        if (wdAcc == null)
                            throw new NullPointerException("Akun tidak ditemukan.");
                        System.out.print("Nominal withdraw: ");
                        double wdAmt = Double.parseDouble(sc.nextLine());
                        wdAcc.withdraw(wdAmt);
                        System.out.println("Withdraw berhasil.");
                        break;

                    case 4:
                        system.displayAll();
                        break;

                    case 0:
                        running = false;
                        System.out.println("Keluar dari sistem...");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            } catch (InvalidAmountException | InsufficientBalanceException e) {
                System.out.println("Transaksi gagal: " + e.getMessage());
            } catch (NullPointerException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Operasi selesai.");
            }
        }
        sc.close();
    }
}