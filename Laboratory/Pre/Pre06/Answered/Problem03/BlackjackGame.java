public class BlackjackGame extends CardGame {
    private int minimumBet;

    public BlackjackGame(int maxPlayers, int minimumBet) {
        super("Blackjack", maxPlayers);
        this.minimumBet = minimumBet;
    }

    // TODO: Override method startGame() dari parent class
    // Tampilkan: "Game Blackjack dimulai! Minimum bet: [minimumBet]"
    @Override
    public void startGame() {
        System.out.println("Game Blackjack dimulai! Minimum bet: " + this.minimumBet);
    }

    // TODO: Buat inner class Dealer yang extends Player
    // Pertanyaan: Mengapa Dealer perlu extends Player?
    // Hint: Pikirkan hubungan "is-a" antara Dealer dan Player
    //
    // Constructor:
    // - Dealer tidak menerima parameter
    // - Gunakan super() untuk memanggil constructor parent class
    // - Set nama sebagai "Dealer" dan handSize sebagai 10
    //
    // Method yang diperlukan:
    // - dealCards(): menampilkan "Dealer membagikan kartu kepada semua pemain"
    public class Dealer extends Player {
        public Dealer() {
            super("Dealer", 10);
        }

        public void dealCards() {
            System.out.println("Dealer membagikan kartu kepada semua pemain");
        }
    }

    // TODO: Buat method hit(Player player)
    // Method ini dipanggil ketika player ingin mengambil kartu tambahan
    // Tampilkan: "Player [nama player] mengambil kartu tambahan"
    public void hit(Player player) {
        System.out.println("Player " + player.getName() + " mengambil kartu tambahan");
    }

    // TODO: Buat method stand(Player player)
    // Method ini dipanggil ketika player tidak ingin mengambil kartu lagi
    // Tampilkan: "Player [nama player] tidak mengambil kartu lagi"
    public void stand(Player player) {
        System.out.println("Player " + player.getName() + " tidak mengambil kartu lagi");
    }

    // TODO: Buat method checkBlackjack(Player player)
    // Method ini mengecek apakah player mendapat Blackjack (score = 21)
    // Langkah-langkah:
    // 1. Panggil method calculateScore() dari player
    // 2. Cek apakah score player sama dengan 21
    // 3. Jika ya, tampilkan: "BLACKJACK! [nama player] menang!"
    // Hint: Gunakan getter untuk mendapatkan score dan nama player
    public void checkBlackjack(Player player) {
        player.calculateScore();
        if (player.getScore() == 21) {
            System.out.println("BLACKJACK! " + player.getName() + " menang!");
        }
    }
}