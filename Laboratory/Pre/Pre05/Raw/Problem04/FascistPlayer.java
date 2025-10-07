/**
 * POLYMORPHIC IMPLEMENTATION: FascistPlayer extends Player
 * 
 * This class demonstrates POLYMORPHISM by providing Fascist-specific
 * implementations of all abstract methods from the Player class.
 * 
 * Fascist Strategy:
 * - Goal: Pass fascist policies and get Hitler into power
 * - Knowledge: Know who other fascists are (including Hitler)
 * - Behavior: Strategic, coordinate with other fascists, eliminate liberals
 */
public class FascistPlayer extends Player {

    public FascistPlayer(String name, int id) {
        super(name, id);
        this.faction = new FascistFaction();
    }

    @Override
    public Policy discardPolicy(Policy[] policies) {
        return this.faction.getPreferredDiscard(policies);
    }

    @Override
    public Vote vote(Player chancellor, Player president) {
        return this.faction.getVoteDecision(chancellor, president);
    }

    @Override
    public Player chooseChancellor(Player[] availablePlayers) {
        // MAIN TODO: Implement chancellor selection for fascists
        // HINT: Fascists prefer to nominate other fascists as chancellor
        // HINT: 'this' is yourself

        // TODO: First, try to find another fascist to nominate
        // TODO: If no fascist available, choose any available player
        // TODO: Make sure chosen player is the first player found that is alive and not
        // yourself

        return null;
    }

    @Override
    public Player choosePlayerToKill(Player[] availablePlayers) {
        // MAIN TODO: Implement player elimination strategy for fascists
        // HINT: Fascists want to eliminate liberals to reduce opposition

        // TODO: Try to find liberal players to eliminate
        // TODO: If no liberals are available, do not eliminate anyone

        return null;
    }
}