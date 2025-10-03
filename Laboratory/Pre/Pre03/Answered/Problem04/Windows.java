public class Windows extends OperatingSystem {
    public enum Edition {
        HOME, PRO, SERVER
    }

    private Edition edition;

    public Windows(String name, String version, String kernelType, double baseScore, Edition edition) {
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    public Edition getEdition() {
        return edition;
    }

    @Override
    public double calculateCompatibility(UsageType usage) {
        double base = getBaseScore();
        double m = 0.0;

        if (usage == UsageType.GAMING) {
            m += 0.20;
        } else if (usage == UsageType.SERVER) {
            if (edition == Edition.SERVER)
                m += 0.30;
            if (edition == Edition.HOME)
                m += -0.05;
        }

        double finalScore = base + (m * base);
        return clampScore(finalScore);
    }

    @Override
    protected String getAdditionalInfo() {
        return "Edition: " + edition.name();
    }
}
