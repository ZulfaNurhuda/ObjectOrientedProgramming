public class Linux extends OperatingSystem {
    public enum Distro {
        UBUNTU, FEDORA, ARCH, DEBIAN
    }

    private Distro distroType;

    public Linux(String name, String version, String kernelType, double baseScore, Distro distroType) {
        super(name, version, kernelType, baseScore);
        this.distroType = (distroType == null) ? Distro.UBUNTU : distroType;
    }

    public Distro getDistroType() {
        return distroType;
    }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double m = 0.0;
        
        if (usage == UsageType.SERVER) {
            m = 0.20;
        } else if (usage == UsageType.DEVELOPMENT) {
            m = 0.10;
        } else if (usage == UsageType.GAMING) {
            m = -0.15;
        }

        double finalScore = base + (m * base);
        return clampScore(finalScore);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Distribution: " + distroType.name();
    }
}
