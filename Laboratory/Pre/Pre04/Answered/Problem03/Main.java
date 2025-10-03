public class Main {
    public static void main(String[] args) {
        IGadget[] gadgets = {
            new Smartphone("Google", "Pixel 7", 6999999),
            new Laptop("ASUS", "ZenBook", 8999999, "Windows 11"),
            new GamingConsole("Microsoft", "Xbox Series X", 4999999)
        };

        for (IGadget gadget : gadgets) {
            System.out.println(gadget.getInfo());
        }
    }
}
