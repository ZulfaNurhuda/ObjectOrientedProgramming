public class MacOS extends OperatingSystem {
    private boolean hasMSeriesChip;

    public MacOS(String name, String version, String kernelType, double baseScore, boolean hasMSeriesChip) {
        super(name, version, kernelType, baseScore);
        this.hasMSeriesChip = hasMSeriesChip;
    }

    public boolean hasMSeriesChip() {
        return hasMSeriesChip;
    }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double m = 0.0;

        if (usage == UsageType.DEVELOPMENT) {
            m += 0.25;
        } else if (usage == UsageType.GAMING) {
            m += -0.20;
        }

        if (hasMSeriesChip) {
            m += 0.10;
        }

        double finalScore = base + (m * base);
        return clampScore(finalScore);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Has M-Series Chip: " + (hasMSeriesChip ? "Yes" : "No");
    }
}
