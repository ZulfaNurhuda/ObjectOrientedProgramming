import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.hasNext() ? scanner.next() : UsageType.DEVELOPMENT.name();
        UsageType usage = parseUsage(input);
        if (usage == null) {
            System.out.println("Invalid usage type: " + input);
            scanner.close();
            return;
        }

        List<OperatingSystem> systems = buildOperatingSystems();
        for (int i = 0; i < systems.size(); i++) {
            systems.get(i).printInfo(usage);
            if (i < systems.size() - 1) {
                System.out.println();
            }
        }

        double average = calculateAverageCompatibility(systems, usage);
        System.out.printf("%nAverage Compatibility for %s: %.2f%n", usage.name(), average);
        scanner.close();
    }

    private static UsageType parseUsage(String raw) {
        if (raw == null) {
            return null;
        }
        String cleaned = raw.trim();
        for (UsageType type : UsageType.values()) {
            if (type.name().equalsIgnoreCase(cleaned)) {
                return type;
            }
        }
        return null;
    }

    private static List<OperatingSystem> buildOperatingSystems() {
        List<OperatingSystem> systems = new ArrayList<>();
        systems.add(new Linux("Ubuntu", "22.04 LTS", "Monolithic", 82, Linux.Distro.UBUNTU));
        systems.add(new Linux("Fedora Server", "39", "Monolithic", 78, Linux.Distro.FEDORA));
        systems.add(new MacOS("macOS Sonoma", "14.0", "Hybrid", 88, true));
        systems.add(new Windows("Windows 11", "23H2", "Hybrid", 85, Windows.Edition.PRO));
        systems.add(new Windows("Windows Server 2022", "21H2", "Hybrid", 80, Windows.Edition.SERVER));
        return systems;
    }

    public static double calculateAverageCompatibility(List<OperatingSystem> systems, UsageType usage) {
        if (systems == null || systems.isEmpty()) {
            return 0.0;
        }
        double total = 0.0;
        for (OperatingSystem os : systems) {
            total += os.calculateCompatibility(usage);
        }
        return total / systems.size();
    }
}
