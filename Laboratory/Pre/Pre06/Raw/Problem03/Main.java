import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== SECTION 1: Test CardGame Basic Functionality =====
        System.out.println("===== Testing CardGame =====");

        // Baca input untuk CardGame
        String gameName = scanner.nextLine();
        int maxPlayers = scanner.nextInt();
        scanner.nextLine();

        CardGame game = new CardGame(gameName, maxPlayers);

        // Test Card creation (Static Nested Class)
        String suit1 = scanner.nextLine();
        String rank1 = scanner.nextLine();
        int value1 = scanner.nextInt();
        scanner.nextLine();

        CardGame.Card card1 = new CardGame.Card(suit1, rank1, value1);
        card1.displayCard();

        String suit2 = scanner.nextLine();
        String rank2 = scanner.nextLine();
        int value2 = scanner.nextInt();
        scanner.nextLine();

        CardGame.Card card2 = new CardGame.Card(suit2, rank2, value2);
        card2.displayCard();

        String suit3 = scanner.nextLine();
        String rank3 = scanner.nextLine();
        int value3 = scanner.nextInt();
        scanner.nextLine();

        CardGame.Card card3 = new CardGame.Card(suit3, rank3, value3);

        // Test Deck (Inner Class)
        int deckSize = scanner.nextInt();
        scanner.nextLine();

        CardGame.Deck deck = game.new Deck(deckSize);
        deck.addCard(card1);
        deck.addCard(card2);
        deck.addCard(card3);
        deck.displayDeck();

        CardGame.Card drawn = deck.drawCard();
        if (drawn != null) {
            System.out.print("Kartu yang diambil: ");
            drawn.displayCard();
        }

        long shuffleSeed = scanner.nextLong();
        scanner.nextLine();
        deck.shuffle(shuffleSeed);
        deck.displayDeck();

        // Test Player (Inner Class)
        String playerName = scanner.nextLine();
        int handSize = scanner.nextInt();
        scanner.nextLine();

        CardGame.Player player = game.new Player(playerName, handSize);
        player.addCardToHand(card1);
        player.addCardToHand(card2);
        player.displayHand();
        player.calculateScore();

        // Test playCard method
        int cardIndexToPlay = scanner.nextInt();
        scanner.nextLine();
        player.playCard(cardIndexToPlay);
        player.displayHand();

        // Test method overloading
        game.startGame();
        int rounds = scanner.nextInt();
        scanner.nextLine();
        game.startGame(rounds);

        // ===== SECTION 2: Test PokerGame =====
        System.out.println("\n===== Testing PokerGame =====");

        int pokerMaxPlayers = scanner.nextInt();
        int blindAmount = scanner.nextInt();
        scanner.nextLine();

        PokerGame poker = new PokerGame(pokerMaxPlayers, blindAmount);
        poker.startGame();

        String pokerPlayerName = scanner.nextLine();
        CardGame.Player pokerPlayer = poker.new Player(pokerPlayerName, 5);

        // Add some cards to poker player
        pokerPlayer.addCardToHand(card1);
        pokerPlayer.addCardToHand(card2);
        pokerPlayer.displayHand();

        poker.evaluateHand(pokerPlayer);
        PokerGame.HandRank rank = poker.getHandRank(pokerPlayer);
        System.out.println("Hand rank: " + rank);

        // ===== SECTION 3: Test BlackjackGame =====
        System.out.println("\n===== Testing BlackjackGame =====");

        int bjMaxPlayers = scanner.nextInt();
        int minBet = scanner.nextInt();
        scanner.nextLine();

        BlackjackGame blackjack = new BlackjackGame(bjMaxPlayers, minBet);
        blackjack.startGame();

        BlackjackGame.Dealer dealer = blackjack.new Dealer();
        dealer.dealCards();

        String bjPlayerName = scanner.nextLine();
        CardGame.Player bjPlayer = blackjack.new Player(bjPlayerName, 5);

        // Add cards untuk test blackjack
        String bjSuit1 = scanner.nextLine();
        String bjRank1 = scanner.nextLine();
        int bjValue1 = scanner.nextInt();
        scanner.nextLine();

        CardGame.Card bjCard1 = new CardGame.Card(bjSuit1, bjRank1, bjValue1);
        bjPlayer.addCardToHand(bjCard1);

        String bjSuit2 = scanner.nextLine();
        String bjRank2 = scanner.nextLine();
        int bjValue2 = scanner.nextInt();
        scanner.nextLine();

        CardGame.Card bjCard2 = new CardGame.Card(bjSuit2, bjRank2, bjValue2);
        bjPlayer.addCardToHand(bjCard2);

        bjPlayer.displayHand();
        blackjack.hit(bjPlayer);
        blackjack.stand(bjPlayer);
        blackjack.checkBlackjack(bjPlayer);

        scanner.close();
    }
}