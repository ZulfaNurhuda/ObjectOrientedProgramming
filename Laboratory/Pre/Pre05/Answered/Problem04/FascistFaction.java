import java.util.Random;

/**
 * POLYMORPHIC IMPLEMENTATION: FascistFaction extends Faction
 * 
 * This class demonstrates POLYMORPHISM by providing Fascist-specific
 * implementations of all abstract methods from the Faction class.
 * 
 * Fascist Faction Goals:
 * - Win by enacting 6 fascist policies OR by getting Hitler as chancellor with
 * 3+ fascist policies
 * - Coordinate secretly to achieve fascist control
 */
public class FascistFaction extends Faction {
    private static final Random rand = new Random(43); // Fixed seed for consistency

    public FascistFaction() {
        super("Fascist");
    }

    @Override
    public Policy getPreferredDiscard(Policy[] policies) {
        // Fascists want to prevent liberal policies from being enacted
        // So they discard liberal policies if possible
        for (Policy policy : policies) {
            if (policy == Policy.LIBERAL) {
                return policy;
            }
        }

        // If no liberal policy found, discard the first available policy
        return policies[0];
    }

    @Override
    public Vote getVoteDecision(Player chancellor, Player president) {
        // Fascists vote to get their allies into power.
        boolean isFascistGovernment = chancellor.getFaction() instanceof FascistFaction ||
                                      president.getFaction() instanceof FascistFaction;

        if (isFascistGovernment) {
            // Usually vote YAY for a fascist government.
            // Occasionally vote NAY to appear less coordinated and more like a liberal.
            if (rand.nextInt(10) < 9) { // 90% chance to vote YAY
                return Vote.YAY;
            } else {
                return Vote.NAY;
            }
        }

        // Always vote NAY for a purely liberal government.
        return Vote.NAY;
    }

    @Override
    public boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor) {
        // Fascists can win in two ways:

        // 1. By enacting 6 fascist policies
        if (fascistPolicies >= 6) {
            return true;
        }

        // 2. By getting Hitler as chancellor when 3+ fascist policies are enacted
        if (fascistPolicies >= 3 && hitlerIsChancellor) {
            return true;
        }

        return false;
    }
}
