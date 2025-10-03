public abstract class OperatingSystem {
    private String name;
    private String version;
    private String kernelType;
    private double baseScore; // Interval: 0 - 100

    public OperatingSystem(String name, String version, String kernelType, double baseScore) {
        this.name = sanitize(name, "Unknown OS");
        this.version = sanitize(version, "Unknown Version");
        this.kernelType = sanitize(kernelType, "Unknown Kernel");
        this.baseScore = clampScore(baseScore);
    }

    public abstract double calculateCompatibility(UsageType usage);

    protected double clampScore(double score) {
        double finalScore = score;
        if (score < 0.0) {
            finalScore = 0.0;
        } else if (score > 100.0) {
            finalScore = 100.00;
        }
        return finalScore;
    }

    protected String getAdditionalInfo() {
        return "";
    }

    public void printInfo(UsageType usage) {
        System.out.printf("Name: %s%n", getName());
        System.out.printf("Version: %s%n", getVersion());
        System.out.printf("Kernel Type: %s%n", getKernelType());

        String extra = getAdditionalInfo();
        if (extra != null && !extra.isEmpty()) {
            System.out.println(extra);
        }

        System.out.printf("Base Score: %.2f%n", getBaseScore());
        double comp = calculateCompatibility(usage);
        System.out.printf("Compatibility for %s: %.2f%n", usage.name(), comp);
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getKernelType() {
        return kernelType;
    }

    public double getBaseScore() {
        return baseScore;
    }

    private String sanitize(String s, String fallback) {
        if (s == null) {
            return fallback;
        }
        String t = s.trim();
        return t.isEmpty() ? fallback : t;
    }
}
