import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting Secret Hitler Game...");

        // Read number of players from input
        int numPlayers = scanner.nextInt();

        // Create a game with specified number of players and unique seed
        long seed = numPlayers * 100 + 42; // Unique seed based on player count
        GameManager game = new GameManager(numPlayers, seed);
        game.playGame();

        System.out.println("\nGame completed!");
        scanner.close();
    }
}
