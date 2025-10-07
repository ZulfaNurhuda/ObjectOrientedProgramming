import java.util.*;

public class GameManager {
  private Player[] players;
  private List<Policy> policyDeck;
  private List<Policy> discardPile;
  private int liberalPolicies;
  private int fascistPolicies;
  private int currentPresidentIndex;
  private Player currentChancellor;
  private boolean gameEnded;
  private Faction winner;
  private Random rand;

  public GameManager(int numPlayers) {
    this(numPlayers, 42); // Default constructor with fixed seed
  }

  public GameManager(int numPlayers, long seed) {
    if (numPlayers < 5) {
      throw new IllegalArgumentException("Minimum 5 players required");
    }

    this.players = new Player[numPlayers];
    this.policyDeck = new ArrayList<>();
    this.discardPile = new ArrayList<>();
    this.liberalPolicies = 0;
    this.fascistPolicies = 0;
    this.currentPresidentIndex = 0;
    this.gameEnded = false;
    this.rand = new Random(seed); // Use provided seed for different results

    initializePlayers(numPlayers);
    initializePolicyDeck();
  }

  private void initializePlayers(int numPlayers) {
    // Calculate faction distribution
    int numFascists = (numPlayers <= 6) ? 2 : 3; // 1 Hitler + 1/2 fascists

    // Create players
    for (int i = 0; i < numPlayers; i++) {
      players[i] = new LiberalPlayer("Player" + (i + 1), i);
    }

    // Assign fascist roles randomly but consistently
    Set<Integer> fascistIndices = new HashSet<>();
    while (fascistIndices.size() < numFascists) {
      fascistIndices.add(rand.nextInt(numPlayers));
    }

    int fascistCount = 0;
    for (int index : fascistIndices) {
      if (fascistCount == 0) {
        players[index] = new HitlerPlayer("Player" + (index + 1), index); // First fascist is Hitler
      } else {
        players[index] = new FascistPlayer("Player" + (index + 1), index); // Regular fascists
      }
      fascistCount++;
    }
  }

  private void initializePolicyDeck() {
    // Add 11 fascist and 6 liberal policies
    for (int i = 0; i < 11; i++) {
      policyDeck.add(Policy.FASCIST);
    }
    for (int i = 0; i < 6; i++) {
      policyDeck.add(Policy.LIBERAL);
    }

    // Shuffle with fixed seed for consistency
    Collections.shuffle(policyDeck, rand);
  }

  public void playGame() {
    System.out.println("=== Secret Hitler Game Started ===");
    printGameState();

    while (!gameEnded) {
      playRound();
      if (!gameEnded) {
        nextPresident();
      }
    }

    System.out.println("\n=== Game Ended ===");
    System.out.println("Winner: " + winner.getFactionName());
  }

  private void playRound() {
    System.out.println("\n--- Round " + (currentPresidentIndex + 1) + " ---");
    Player president = players[currentPresidentIndex];
    System.out.println("President: " + president.getName());

    // President chooses chancellor
    Player[] availablePlayers = getAlivePlayers();
    Player chancellor = president.chooseChancellor(availablePlayers);

    if (chancellor == null) {
      System.out.println("No chancellor could be chosen!");
      return;
    }

    System.out.println("Chosen Chancellor: " + chancellor.getName());

    // Vote on chancellor
    if (!voteOnChancellor(chancellor, president)) {
      System.out.println("Chancellor nomination failed!");
      return;
    }

    currentChancellor = chancellor;
    System.out.println("Chancellor approved: " + chancellor.getName());

    // Policy phase
    policyPhase(president, chancellor);

    // Check win conditions
    checkWinConditions();

    // Executive actions (if fascist policies >= 4)
    if (fascistPolicies >= 4 && !gameEnded) {
      executePresidentialPower(president);
    }
  }

  private boolean voteOnChancellor(Player chancellor, Player president) {
    int yayVotes = 0;
    int nayVotes = 0;

    for (Player player : players) {
      if (player.isAlive()) {
        Vote vote = player.vote(chancellor, president);
        if (vote == Vote.YAY) {
          yayVotes++;
        } else {
          nayVotes++;
        }
      }
    }

    System.out.println("Votes - YAY: " + yayVotes + ", NAY: " + nayVotes);
    return yayVotes > nayVotes;
  }

  private void policyPhase(Player president, Player chancellor) {
    System.out.println("\n--- Policy Phase ---");

    // Draw 3 policies
    Policy[] drawnPolicies = drawPolicies(3);
    System.out.println("Drawn policies: " + Arrays.toString(drawnPolicies));

    // President discards one
    Policy discarded = president.discardPolicy(drawnPolicies);
    Policy[] remainingPolicies = removePolicy(drawnPolicies, discarded);
    discardPile.add(discarded);

    System.out.println("President discarded: " + discarded);
    System.out.println("Remaining policies: " + Arrays.toString(remainingPolicies));

    // Chancellor chooses one to enact
    Policy enacted = chancellor.discardPolicy(remainingPolicies);
    Policy finalDiscarded = null;
    for (Policy p : remainingPolicies) {
      if (p != enacted) {
        finalDiscarded = p;
        break;
      }
    }

    if (finalDiscarded != null) {
      discardPile.add(finalDiscarded);
    }

    // Enact the policy
    enactPolicy(enacted);
    System.out.println("Enacted policy: " + enacted);
  }

  private Policy[] drawPolicies(int count) {
    if (policyDeck.size() < count) {
      // Reshuffle discard pile back into deck
      policyDeck.addAll(discardPile);
      discardPile.clear();
      Collections.shuffle(policyDeck, rand);
    }

    Policy[] drawn = new Policy[count];
    for (int i = 0; i < count; i++) {
      drawn[i] = policyDeck.remove(policyDeck.size() - 1);
    }
    return drawn;
  }

  private Policy[] removePolicy(Policy[] policies, Policy toRemove) {
    List<Policy> remaining = new ArrayList<>();
    boolean removed = false;
    for (Policy p : policies) {
      if (!removed && p == toRemove) {
        removed = true;
      } else {
        remaining.add(p);
      }
    }
    return remaining.toArray(new Policy[0]);
  }

  private void enactPolicy(Policy policy) {
    if (policy == Policy.LIBERAL) {
      liberalPolicies++;
    } else {
      fascistPolicies++;
    }
  }

  private void checkWinConditions() {
    // Check liberal win
    if (liberalPolicies >= 5) {
      gameEnded = true;
      winner = new LiberalFaction();
      return;
    }

    // Check fascist wins
    if (fascistPolicies >= 6) {
      gameEnded = true;
      winner = new FascistFaction();
      return;
    }

    // Check Hitler chancellor win (if 3+ fascist policies)
    if (fascistPolicies >= 3 && currentChancellor != null && currentChancellor.isHitler()) {
      gameEnded = true;
      winner = new FascistFaction();
      System.out.println("Hitler became Chancellor with 3+ fascist policies!");
    }
  }

  private void executePresidentialPower(Player president) {
    System.out.println("\n--- Presidential Power: Execution ---");
    Player[] availablePlayers = getAlivePlayers();
    Player target = president.choosePlayerToKill(availablePlayers);

    if (target != null) {
      target.kill();
      System.out.println(president.getName() + " executed " + target.getName());

      // If Hitler is killed, liberals win
      if (target.isHitler()) {
        gameEnded = true;
        winner = new LiberalFaction();
        System.out.println("Hitler was executed! Liberals win!");
      }
    }
  }

  private Player[] getAlivePlayers() {
    List<Player> alive = new ArrayList<>();
    for (Player p : players) {
      if (p.isAlive()) {
        alive.add(p);
      }
    }
    return alive.toArray(new Player[0]);
  }

  private void nextPresident() {
    do {
      currentPresidentIndex = (currentPresidentIndex + 1) % players.length;
    } while (!players[currentPresidentIndex].isAlive());
  }

  private void printGameState() {
    System.out.println("\n=== Game State ===");
    System.out.println("Liberal Policies: " + liberalPolicies);
    System.out.println("Fascist Policies: " + fascistPolicies);
    System.out.println("Players:");

    for (Player player : players) {
      String status = player.isAlive() ? "Alive" : "Dead";
      String role = player.isHitler() ? " (Hitler)" : "";
      System.out.println("  " + player.getName() + " - " +
          player.getFaction().getFactionName() + role + " - " + status);
    }
    System.out.println("Policies in deck: " + policyDeck.size());
    System.out.println("==================");
  }

  public static void main(String[] args) {
    GameManager game = new GameManager(5);
    game.playGame();
  }
}