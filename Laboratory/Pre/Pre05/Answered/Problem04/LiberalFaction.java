import java.util.Random;

/**
 * POLYMORPHIC IMPLEMENTATION: LiberalFaction extends Faction
 * 
 * This class demonstrates POLYMORPHISM by providing Liberal-specific
 * implementations of all abstract methods from the Faction class.
 * 
 * Liberal Faction Goals:
 * - Win by enacting 5 liberal policies OR by killing Hitler
 * - Prevent fascist takeover and Hitler becoming chancellor
 */
public class LiberalFaction extends Faction {
    private static final Random rand = new Random(42); // Fixed seed for consistency

    public LiberalFaction() {
        super("Liberal");
    }

    @Override
    public Policy getPreferredDiscard(Policy[] policies) {
        // Liberals want to prevent fascist policies from being enacted
        // So they discard fascist policies if available
        for (Policy policy : policies) {
            if (policy == Policy.FASCIST) {
                return policy;
            }
        }

        // If no fascist policy found, discard the first available policy
        return policies[0];
    }

    @Override
    public Vote getVoteDecision(Player chancellor, Player president) {
        // Liberals don't know who is who, so they vote with some skepticism.
        // They are more likely to vote YAY, but will sometimes vote NAY to be safe.
        // This simulates a degree of distrust without any specific information.
        if (rand.nextInt(10) < 8) { // 80% chance to vote YAY
            return Vote.YAY;
        } else {
            return Vote.NAY;
        }
    }

    @Override
    public boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor) {
        // Liberals win if they enact 5 liberal policies
        // (Hitler being killed is handled elsewhere in GameManager)
        return liberalPolicies >= 5;
    }
}
