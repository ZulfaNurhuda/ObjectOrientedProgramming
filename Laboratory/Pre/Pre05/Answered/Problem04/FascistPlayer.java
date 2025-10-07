import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * POLYMORPHIC IMPLEMENTATION: FascistPlayer extends Player
 * 
 * This class demonstrates POLYMORPHISM by providing Fascist-specific
 * implementations of all abstract methods from the Player class.
 * 
 * Fascist Strategy:
 * - Goal: Pass fascist policies, get Hitler elected with 3+ fascist policies
 * - Knowledge: Knows who other fascists and Hitler are
 * - Behavior: Acts deceptively, supports fellow fascists
 */
public class FascistPlayer extends Player {
    public FascistPlayer(String name, int id) {
        super(name, id);
        this.faction = new FascistFaction();
    }

    @Override
    public Policy discardPolicy(Policy[] policies) {
        // Fascists want to enact fascist policies
        // They will discard a liberal policy if they can
        return this.faction.getPreferredDiscard(policies);
    }

    @Override
    public Vote vote(Player chancellor, Player president) {
        // Fascists know who their allies are and vote to get them into power
        // Vote YAY if the chancellor or president is a fascist (including Hitler)
        return this.faction.getVoteDecision(chancellor, president);
    }

    @Override
    public Player chooseChancellor(Player[] availablePlayers) {
        // A fascist president wants to elect a fascist chancellor to ensure
        // a fascist policy is enacted. They know who their allies are.
        // To reduce risk, they prefer electing a regular fascist over Hitler.
        // Choosing a liberal is a last resort to appear less suspicious.

        List<Player> fascistCandidates = new ArrayList<>();
        List<Player> liberalCandidates = new ArrayList<>();

        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                // Find non-Hitler fascists
                if (player.getFaction() instanceof FascistFaction && !player.isHitler()) {
                    fascistCandidates.add(player);
                } else if (!(player.getFaction() instanceof FascistFaction)) {
                    liberalCandidates.add(player);
                }
            }
        }
        
        Random rand = new Random(this.getId() ^ System.nanoTime());

        // Prefer to elect a fellow (non-Hitler) fascist.
        if (!fascistCandidates.isEmpty()) {
            return fascistCandidates.get(rand.nextInt(fascistCandidates.size()));
        }

        // If no regular fascists are available, elect a random liberal.
        if (!liberalCandidates.isEmpty()) {
            return liberalCandidates.get(rand.nextInt(liberalCandidates.size()));
        }
        
        // As a last resort (e.g., only Hitler is left), choose any available player not self.
        List<Player> anyPlayer = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                anyPlayer.add(player);
            }
        }
        if (!anyPlayer.isEmpty()) {
            return anyPlayer.get(rand.nextInt(anyPlayer.size()));
        }

        return null;
    }

    @Override
    public Player choosePlayerToKill(Player[] availablePlayers) {
        // A fascist with execution power should eliminate a liberal.
        // Choosing randomly among liberals makes it harder for liberals to deduce
        // who the fascists are based on execution patterns.
        List<Player> targets = new ArrayList<>();
        for (Player player : availablePlayers) {
            // Target players who are alive, not self, and not in the Fascist faction.
            if (player.isAlive() && player.getId() != this.getId() && !(player.getFaction() instanceof FascistFaction)) {
                targets.add(player);
            }
        }
        
        Random rand = new Random(this.getId() ^ System.nanoTime());

        if (!targets.isEmpty()) {
            // Kill a random liberal.
            return targets.get(rand.nextInt(targets.size()));
        }

        // Fallback: if no liberals are left, kill any non-fascist ally (not self).
        List<Player> anyTargets = new ArrayList<>();
        for (Player player : availablePlayers) {
            if (player.isAlive() && player.getId() != this.getId()) {
                anyTargets.add(player);
            }
        }

        if(!anyTargets.isEmpty()){
            return anyTargets.get(rand.nextInt(anyTargets.size()));
        }

        return null;
    }
}
