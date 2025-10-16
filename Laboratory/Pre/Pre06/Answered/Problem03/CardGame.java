import java.util.Random;

public class CardGame {
    private String gameName;
    private int maxPlayers;

    public CardGame(String gameName, int maxPlayers) {
        this.gameName = gameName;
        this.maxPlayers = maxPlayers;
    }

    public String getGameName() {
        return gameName;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    // TODO: Buat static nested class bernama Card
    // Pertanyaan: Mengapa Card menggunakan static nested class?
    // Hint: Apakah sebuah kartu perlu bergantung pada instance game tertentu?
    //
    // Atribut yang diperlukan: suit, rank, value (tipe data sesuaikan sendiri)
    // Method yang diperlukan:
    // - Constructor untuk inisialisasi
    // - Getter untuk setiap atribut
    // - displayCard() untuk menampilkan informasi kartu dalam format:
    //   "[rank] of [suit] (Value: [value])"
    public static class Card {
        private String suit;
        private String rank;
        private int value;

        public Card(String suit, String rank, int value) {
            this.suit = suit;
            this.rank = rank;
            this.value = value;
        }

        public String getSuit() {
            return suit;
        }

        public String getRank() {
            return rank;
        }

        public int getValue() {
            return value;
        }

        public void displayCard() {
            System.out.println(this.rank + " of " + this.suit + " (Value: " + this.value + ")");
        }
    }

    // TODO: Buat inner class bernama Deck
    // Pertanyaan: Mengapa Deck menggunakan inner class (bukan static)?
    // Hint: Perhatikan apakah Deck perlu mengakses atribut gameName dari outer class
    //
    // Atribut yang diperlukan:
    // - Array untuk menyimpan Card
    // - Variabel untuk melacak jumlah kartu yang ada di deck
    //
    // Method yang diperlukan:
    // - Constructor(int size): inisialisasi deck dengan kapasitas tertentu
    // - addCard(Card card): menambahkan kartu ke deck
    //   * Tampilkan: "Kartu ditambahkan ke deck [gameName]"
    //   * Handle kasus deck penuh dengan menampilkan pesan "Deck penuh!"
    // - drawCard(): mengambil kartu terakhir dari deck dan mengembalikannya
    //   * Handle kasus deck kosong dengan menampilkan pesan "Deck kosong!" dan return null
    //   * Pastikan kartu yang diambil dihapus dari deck
    // - shuffle(long seed): mengacak posisi kartu dalam deck
    //   * Parameter: seed untuk Random (agar hasil deterministik)
    //   * Tampilkan: "Deck [gameName] dikocok"
    //   * Implementasi: gunakan java.util.Random dengan seed parameter
    //   * Algoritma: Fisher-Yates shuffle
    //     Hint: Loop dari belakang (i = currentSize-1 sampai 1 (inklusif)),
    //           pilih random index j dari 0 sampai i (gunakan rand.nextInt(i+1)),
    //           swap cards[i] dengan cards[j]
    // - displayDeck(): menampilkan semua kartu di deck
    //   * Format: "Deck [gameName] berisi [jumlah] kartu:"
        public class Deck {
        private Card[] cards;
        private int currentSize;

        public Deck(int size) {
            this.cards = new Card[size];
            this.currentSize = 0;
        }

        public void addCard(Card card) {
            if (this.currentSize < this.cards.length) {
                this.cards[this.currentSize++] = card;
                System.out.println("Kartu ditambahkan ke deck " + CardGame.this.gameName);
            } else {
                System.out.println("Deck penuh!");
            }
        }

        public Card drawCard() {
            if (this.currentSize > 0) {
                Card drawnCard = this.cards[--this.currentSize];
                this.cards[this.currentSize] = null;
                return drawnCard;
            } else {
                System.out.println("Deck kosong!");
                return null;
            }
        }

        public void shuffle(long seed) {
            Random rand = new Random(seed);
            System.out.println("Deck " + CardGame.this.gameName + " dikocok");
            for (int i = this.currentSize - 1; i > 0; i--) {
                int j = rand.nextInt(i + 1);
                Card temp = this.cards[i];
                this.cards[i] = this.cards[j];
                this.cards[j] = temp;
            }
        }

        public void displayDeck() {
            System.out.println("Deck " + CardGame.this.gameName + " berisi " + this.currentSize + " kartu:");
            for (int i = 0; i < this.currentSize; i++) {
                this.cards[i].displayCard();
            }
        }
    }

    // TODO: Buat inner class bernama Player
    // Atribut yang diperlukan:
    // - name
    // - Array untuk menyimpan kartu di tangan (hand)
    // - score
    // - Variabel untuk melacak berapa banyak kartu yang dimiliki
    //   (Hint: Pikirkan mengapa kita perlu variabel terpisah untuk tracking jumlah kartu)
    //
    // Method yang diperlukan:
    // - Constructor(String name, int handSize): inisialisasi player
    // - Getter untuk name, hand, dan score
    // - addCardToHand(Card card): menambahkan kartu ke hand
    //   * Tampilkan: "[name] menerima kartu di game [gameName]"
    //   * Handle kasus hand penuh dengan menampilkan pesan "Tangan [name] sudah penuh!"
    // - playCard(int index): memainkan kartu pada index tertentu
    //   * Tampilkan kartu yang dimainkan menggunakan displayCard()
    //   * Hapus kartu dari hand (Hint: pikirkan cara reorganisasi array, array harus rata kiri)
    //   * Return kartu yang dimainkan
    //   * Handle kasus index tidak valid dengan menampilkan pesan "Tidak ada kartu di index tersebut"
    // - displayHand(): menampilkan semua kartu di tangan
    //   * Format: "[name] memiliki [jumlah] kartu:" lalu list kartu menggunakan displayCard()
    // - calculateScore(): menghitung total nilai kartu di tangan
    //   * Tampilkan: "[name] memiliki total score: [score]"
    public class Player {
        private String name;
        private Card[] hand;
        private int score;
        private int cardCount;

        public Player(String name, int handSize) {
            this.name = name;
            this.hand = new Card[handSize];
            this.score = 0;
            this.cardCount = 0;
        }

        public String getName() {
            return this.name;
        }

        public Card[] getHand() {
            return this.hand;
        }

        public int getScore() {
            return this.score;
        }

        public void addCardToHand(Card card) {
            if (this.cardCount < this.hand.length) {
                this.hand[this.cardCount++] = card;
                System.out.println(this.name + " menerima kartu di game " + CardGame.this.gameName);
            } else {
                System.out.println("Tangan " + this.name + " sudah penuh!");
            }
        }

        public Card playCard(int index) {
            if (index >= 0 && index < this.cardCount) {
                Card playedCard = this.hand[index];
                System.out.println(this.name + " memainkan kartu:");
                playedCard.displayCard();
                for (int i = index; i < this.cardCount - 1; i++) {
                    this.hand[i] = this.hand[i + 1];
                }
                this.hand[--this.cardCount] = null;
                return playedCard;
            } else {
                System.out.println("Tidak ada kartu di index tersebut");
                return null;
            }
        }

        public void displayHand() {
            System.out.println(this.name + " memiliki " + this.cardCount + " kartu:");
            for (int i = 0; i < this.cardCount; i++) {
                this.hand[i].displayCard();
            }
        }

        public void calculateScore() {
            this.score = 0;
            for (int i = 0; i < this.cardCount; i++) {
                this.score += this.hand[i].getValue();
            }
            System.out.println(this.name + " memiliki total score: " + this.score);
        }
    }

    // TODO: Buat method startGame()
    // Tampilkan: "Game [gameName] dimulai dengan [maxPlayers] pemain maksimal!"
    public void startGame() {
        System.out.println("Game " + this.gameName + " dimulai dengan " + this.maxPlayers + " pemain maksimal!");
    }

    // TODO: Buat method overloading startGame(int rounds)
    // Tampilkan: "Game [gameName] dimulai dengan [rounds] ronde!"
    public void startGame(int rounds) {
        System.out.println("Game " + this.gameName + " dimulai dengan " + rounds + " ronde!");
    }
}