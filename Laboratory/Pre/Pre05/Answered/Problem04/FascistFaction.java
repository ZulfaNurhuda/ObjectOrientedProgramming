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

    public FascistFaction() {
        super("Fascist");
    }

    @Override
    public Policy getPreferredDiscard(Policy[] policies) {
        // MAIN TODO: Implement fascist faction's policy preference
        // HINT: Fascists want to prevent liberal policies from being enacted, so they
        // should discard liberal policies if possible

        // TODO: Loop through policies to find the preferred discard type
        // TODO: Return a default option (first policy) if preferred type not found

        Policy preferredDiscardPolicy = null;

        for (int i = 0; i < policies.length && preferredDiscardPolicy == null; i++) {
            if (policies[i] == Policy.LIBERAL) {
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
        // MAIN TODO: Implement fascist faction's voting behavior
        // HINT: Fascists vote strategically to help other fascists gain power

        // TODO: Check if the chancellor or president belongs to the fascist faction
        // TODO: Vote to benefit fascist players and hinder liberal players

        Vote voteDecision = Vote.NAY;

        if (chancellor.getFaction() instanceof FascistFaction || president.getFaction() instanceof FascistFaction) {
            voteDecision = Vote.YAY;
        }

        return voteDecision;
    }

    @Override
    public boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor) {
        // MAIN TODO: Implement fascist win condition check
        // HINT: Fascists can win in two ways:
        // 1. By enacting enough fascist policies (6 fascists policies enacted)
        // 2. By getting Hitler as chancellor when certain conditions are met (3
        // fascists policies enacted)

        // TODO: Check for fascist policy victory condition
        // TODO: Check for Hitler-chancellor victory condition
        // TODO: Return true if any win condition is met

        return (fascistPolicies >= 6) || (fascistPolicies >= 3 && hitlerIsChancellor);
    }
}