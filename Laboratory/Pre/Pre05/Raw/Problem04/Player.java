/**
 * Abstract base class representing a player in the Secret Hitler game.
 * This class demonstrates POLYMORPHISM through abstract methods that
 * are implemented differently by each player type (Liberal, Fascist, Hitler).
 * 
 * POLYMORPHISM CONCEPT: The same method calls (like discardPolicy, vote, etc.)
 * will behave differently depending on the actual player type at runtime.
 * This allows the GameManager to treat all players uniformly while each
 * player type maintains its unique behavior.
 */
public abstract class Player {
  protected String name;
  protected int id;
  protected Faction faction;
  protected boolean isAlive;
  protected boolean isHitler;

  public Player(String name, int id) {
    this.name = name;
    this.id = id;
    this.isAlive = true;
    this.isHitler = false;
  }

  // Getter methods - these are concrete (not polymorphic)
  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public Faction getFaction() {
    return faction;
  }

  public void setFaction(Faction faction) {
    this.faction = faction;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void kill() {
    this.isAlive = false;
  }

  public boolean isHitler() {
    return isHitler;
  }

  public void setHitler(boolean hitler) {
    this.isHitler = hitler;
  }

  // POLYMORPHIC METHODS - Each player type implements these differently

  /**
   * POLYMORPHIC METHOD: Choose which policy to discard from available policies.
   * Different player types have different strategies:
   * - Liberals want to discard fascist policies
   * - Fascists want to discard liberal policies
   * - Hitler acts like a fascist but may be more strategic
   * 
   * @param policies Array of policies to choose from
   * @return The policy this player chooses to discard
   */
  public abstract Policy discardPolicy(Policy[] policies);

  /**
   * POLYMORPHIC METHOD: Decide how to vote on a chancellor nomination.
   * Different player types vote differently:
   * - Liberals generally vote YAY (trusting)
   * - Fascists vote strategically to help their faction
   * - Hitler votes unpredictably to avoid suspicion
   * 
   * @param chancellor The nominated chancellor
   * @param president  The current president
   * @return YAY or NAY vote
   */
  public abstract Vote vote(Player chancellor, Player president);

  /**
   * POLYMORPHIC METHOD: Choose a chancellor from available players.
   * Different strategies based on player type:
   * - Liberals choose somewhat randomly (don't know who's who)
   * - Fascists try to choose other fascists
   * - Hitler doesn't know other fascists, so chooses randomly
   * 
   * @param availablePlayers Array of players that can be chosen as chancellor
   * @return The chosen chancellor, or null if none available
   */
  public abstract Player chooseChancellor(Player[] availablePlayers);

  /**
   * POLYMORPHIC METHOD: Choose a player to eliminate (presidential power).
   * Different targeting strategies:
   * - Liberals kill randomly (don't know who fascists are)
   * - Fascists try to kill liberals (they know each other)
   * - Hitler kills randomly (doesn't know other fascists)
   * 
   * @param availablePlayers Array of players that can be targeted
   * @return The player to eliminate, or null if none chosen
   */
  public abstract Player choosePlayerToKill(Player[] availablePlayers);
}