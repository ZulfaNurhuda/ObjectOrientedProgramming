/**
 * POLYMORPHIC IMPLEMENTATION: LiberalPlayer extends Player
 * 
 * This class demonstrates POLYMORPHISM by providing Liberal-specific
 * implementations of all abstract methods from the Player class.
 * 
 * Liberal Strategy:
 * - Goal: Pass liberal policies and prevent fascist takeover
 * - Knowledge: Don't know who the fascists or Hitler are
 * - Behavior: Generally trusting, tries to discard fascist policies
 */
public class LiberalPlayer extends Player {
    public LiberalPlayer(String name, int id) {
        super(name, id);
        this.faction = new LiberalFaction();
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
        // MAIN TODO: Implement chancellor selection for liberals
        // HINT: Liberals don't know who fascists are, so they can't make informed
        // choices
        // HINT: 'this' is yourself

        // TODO: Loop through available players to nominate as chancellor
        // TODO: Make sure the chosen player is the first player found that is alive and
        // not yourself

        Player choosenChancellor = null;

        for (int i = 0; i < availablePlayers.length && choosenChancellor == null; i++) {
            Player player = availablePlayers[i];
            if (player.isAlive() && player != this) {
                choosenChancellor = availablePlayers[i];
            }
        }

        return choosenChancellor; // STUDENT TODO: Replace with chosen player
    }

    @Override
    public Player choosePlayerToKill(Player[] availablePlayers) {
        // MAIN TODO: Implement player elimination strategy for liberals
        // HINT: Liberals don't know who fascists are, so they must choose without
        // information

        // TODO: Implement a strategy to choose a player to eliminate
        // TODO: Make sure the chosen player is the first player found that is alive and
        // not yourself

        Player playerToKill = null;

        for (int i = 0; i < availablePlayers.length && playerToKill == null; i++) {
            Player player = availablePlayers[i];
            if (player.isAlive() && player != this) {
                playerToKill = availablePlayers[i];
            }
        }

        return playerToKill;
    }
}