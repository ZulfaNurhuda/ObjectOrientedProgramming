import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * POLYMORPHIC IMPLEMENTATION: HitlerPlayer extends Player
 * 
 * This class demonstrates POLYMORPHISM by providing Hitler-specific
 * implementations of all abstract methods from the Player class.
 * 
 * Hitler Strategy:
 * - Goal: Become chancellor with 3+ fascist policies enacted
 * - Knowledge: Does NOT know who other fascists are (key game rule!)
 * - Behavior: Must appear liberal to avoid suspicion, acts unpredictably
 */
public class HitlerPlayer extends Player {
    private static final Random rand = new Random(42); // Fixed seed for consistent results

    public HitlerPlayer(String name, int id) {
        super(name, id);
        // Hitler belongs to the Fascist faction
        this.faction = new FascistFaction();
        // Set the Hitler flag
        this.isHitler = true;
    }

    @Override
    public Policy discardPolicy(Policy[] policies) {
        // Hitler's goal is to enact fascist policies while appearing liberal.
        // He will usually discard liberal policies, but sometimes discard a fascist one
        // to sow confusion and build trust with unsuspecting liberals.

        boolean hasLiberal = false;
        boolean hasFascist = false;
        for (Policy policy : policies) {
            if (policy == Policy.LIBERAL) {
                hasLiberal = true;
            } else {
                hasFascist = true;
            }
        }

        // If there's no choice, just discard what's available.
        if (!hasLiberal || !hasFascist) {
            return policies[0];
        }

        // With a mix of policies, decide deceptively.
        // 70% chance to discard a Liberal policy (to help Fascists).
        if (rand.nextInt(10) < 7) {
            return Policy.LIBERAL;
        } else {
            // 30% chance to discard a Fascist policy (to appear Liberal).
            return Policy.FASCIST;
        }
    }

    @Override
    public Vote vote(Player chancellor, Player president) {
        // Hitler doesn't know who other fascists are (important game rule!)
        // Hitler must appear unpredictable to avoid detection
        // Vote randomly to stay hidden

        if (rand.nextBoolean()) {
            return Vote.YAY;
        } else {
            return Vote.NAY;
        }
    }

    @Override
    public Player chooseChancellor(Player[] availablePlayers) {
        // Hitler doesn't know his allies. To avoid suspicion, he must act
        // like a liberal would, which means choosing randomly. A predictable
        // choice could reveal him.
        List<Player> candidates = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                candidates.add(player);
            }
        }

        if (candidates.isEmpty()) {
            return null;
        }

        // Use the static rand for this choice
        return candidates.get(rand.nextInt(candidates.size()));
    }

    @Override
    public Player choosePlayerToKill(Player[] availablePlayers) {
        // Hitler does NOT know who other fascists are (crucial game rule!)
        // Must choose randomly to avoid revealing identity
        List<Player> targets = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                targets.add(player);
            }
        }

        if (targets.isEmpty()) {
            return null;
        }

        return targets.get(rand.nextInt(targets.size()));
    }
}
