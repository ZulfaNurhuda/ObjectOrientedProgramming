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

    public LiberalFaction() {
        super("Liberal");
    }

    @Override
    public Policy getPreferredDiscard(Policy[] policies) {
        // MAIN TODO: Implement liberal faction's policy preference
        // HINT: Liberals want to prevent fascist policies from being enacted

        // TODO: Loop through policies to find the preferred discard type
        // TODO: Return a default option (first policy) if preferred type not found

        Policy preferredDiscardPolicy = null;

        for (int i = 0; i < policies.length && preferredDiscardPolicy == null; i++) {
            if (policies[i] == Policy.FASCIST) {
                preferredDiscardPolicy = policies[i];
            }
        }

        if (preferredDiscardPolicy == null) {
            preferredDiscardPolicy = policies[0];
        }

        return preferredDiscardPolicy;
    }

    @Override
    public Vote getVoteDecision(Player chancellor, Player president) {
        // MAIN TODO: Implement liberal faction's voting behavior
        // HINT: Liberals generally trust other players since they don't know who
        // fascists are

        // TODO: Always vote YAY as a simple trusting strategy

        return Vote.YAY;
    }

    @Override
    public boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor) {
        // STUDENT TODO: Implement liberal win condition check
        // HINT: Liberals can win in one ways:
        // 1. By enacting enough liberal policies (5 Policies)

        // TODO: Check if liberals have won based on policy count
        // TODO: Return true if win condition is met, false otherwise

        return liberalPolicies >= 5;
    }
}