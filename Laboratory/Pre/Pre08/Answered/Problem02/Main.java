import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Registration registration = new Registration();

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        System.out.print("Masukkan umur: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        try {
            registration.registerStudent(name, age, password);
            System.out.println("Pendaftaran berhasil!");
        } catch (InvalidNameException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (WeakPasswordException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Pendaftaran selesai (selalu dijalankan).");
        }

        scanner.close();
    }
}
