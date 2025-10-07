import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        // Liberals don't know who is who, so they choose a chancellor randomly.
        // This avoids predictable patterns that could be exploited.
        List<Player> candidates = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                candidates.add(player);
            }
        }

        if (candidates.isEmpty()) {
            return null;
        }

        return candidates.get(new Random(this.getId() ^ System.nanoTime()).nextInt(candidates.size()));
    }

    @Override
    public Player choosePlayerToKill(Player[] availablePlayers) {
        // As a liberal with no information, the fairest and least predictable
        // strategy is to choose a player to kill at random.
        List<Player> targets = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                targets.add(player);
            }
        }

        if (targets.isEmpty()) {
            return null;
        }

        return targets.get(new Random(this.getId() ^ System.nanoTime()).nextInt(targets.size()));
    }
}
