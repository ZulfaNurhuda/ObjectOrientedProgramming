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
    // TODO: Initialize the faction and Hitler status for this player
    // HINT: What faction does Hitler belong to?
    // HINT: Don't forget to set the isHitler flag!
    this.faction = null; // STUDENT TODO: Replace with appropriate faction
    // STUDENT TODO: Set the isHitler flag appropriately
  }

  @Override
  public Policy discardPolicy(Policy[] policies) {
    // STUDENT TODO: Implement Hitler's policy discarding strategy
    // HINT: Hitler wants fascist policies to pass, but must be subtle about it
    // Consider: Should Hitler behave exactly like a fascist, or differently?

    // TODO: Decide which policy Hitler should discard
    // TODO: Consider that Hitler wants fascist policies but must avoid suspicion

    return null; // STUDENT TODO: Replace with actual implementation
  }

  @Override
  public Vote vote(Player chancellor, Player president) {
    // STUDENT TODO: Implement Hitler's voting behavior
    // HINT: Hitler doesn't know who other fascists are (important game rule!)
    // HINT: Hitler must appear unpredictable to avoid detection
    // Consider: Should Hitler vote consistently or randomly?

    // TODO: Implement a voting strategy that helps Hitler stay hidden
    // TODO: Use the Random object (rand) to make unpredictable choices

    return null; // STUDENT TODO: Replace with YAY or NAY
  }

  @Override
  public Player chooseChancellor(Player[] availablePlayers) {
    // STUDENT TODO: Implement chancellor selection for Hitler
    // HINT: Hitler DOES NOT know who the other fascists are!
    // Consider: How should Hitler choose without this knowledge?
    // Consider: What strategy would help Hitler avoid suspicion?

    // TODO: Choose a chancellor without knowing other players' factions
    // TODO: Make sure chosen player is alive and not yourself

    return null; // STUDENT TODO: Replace with chosen player
  }

  @Override
  public Player choosePlayerToKill(Player[] availablePlayers) {
    // STUDENT TODO: Implement player elimination strategy for Hitler
    // HINT: Hitler does NOT know who other fascists are (crucial game rule!)
    // HINT: Hitler must choose without knowledge of other players' roles
    // Consider: Random selection might be the only option

    // TODO: Choose a player to eliminate without faction knowledge
    // TODO: Use the Random object (rand) for unpredictable selection
    // TODO: Make sure chosen player is alive and not yourself

    return null; // STUDENT TODO: Replace with chosen player
  }
}