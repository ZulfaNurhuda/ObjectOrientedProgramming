/**
 * Abstract base class representing a faction in the Secret Hitler game.
 * This class demonstrates POLYMORPHISM by defining common faction behavior
 * while allowing each specific faction (Liberal/Fascist) to implement
 * their own strategies and win conditions.
 * 
 * POLYMORPHISM CONCEPT: The GameManager can work with any Faction type
 * without knowing the specific implementation, but each faction will
 * behave according to its own rules and objectives.
 */
public abstract class Faction {
  protected String factionName;

  public Faction(String factionName) {
    this.factionName = factionName;
  }

  public String getFactionName() {
    return factionName;
  }

  // POLYMORPHIC METHODS - Each faction implements these differently

  /**
   * POLYMORPHIC METHOD: Determine which policy this faction prefers to discard.
   * Different factions have opposite preferences:
   * - Liberal faction prefers to discard fascist policies
   * - Fascist faction prefers to discard liberal policies
   * 
   * @param policies Array of available policies
   * @return The policy this faction would prefer to discard
   */
  public abstract Policy getPreferredDiscard(Policy[] policies);

  /**
   * POLYMORPHIC METHOD: Determine how this faction typically votes.
   * Different voting patterns:
   * - Liberal faction tends to vote more openly/trustingly
   * - Fascist faction votes strategically to benefit their members
   * 
   * @param chancellor The nominated chancellor
   * @param president  The current president
   * @return The vote decision for this faction
   */
  public abstract Vote getVoteDecision(Player chancellor, Player president);

  /**
   * POLYMORPHIC METHOD: Check if this faction has won the game.
   * Different win conditions:
   * - Liberals win by passing 5 liberal policies OR killing Hitler
   * - Fascists win by passing 6 fascist policies OR getting Hitler as chancellor
   * with 3+ fascist policies
   * 
   * @param liberalPolicies    Number of liberal policies enacted
   * @param fascistPolicies    Number of fascist policies enacted
   * @param hitlerIsChancellor Whether Hitler is currently chancellor
   * @return true if this faction has won, false otherwise
   */
  public abstract boolean checkWinCondition(int liberalPolicies, int fascistPolicies, boolean hitlerIsChancellor);
}