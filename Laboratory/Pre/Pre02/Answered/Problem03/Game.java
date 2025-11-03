class Game {
    // TODO: Deklarasi atribut: namaGame (String), genre (String), developer
    // (Developer)
    // TODO: Deklarasi atribut: playerCount (int) awal 0
    // TODO: Deklarasi atribut statik: totalGame (int)
    public String namaGame;
    public String genre;
    public Developer developer;
    public int playerCount = 0;
    public static int totalGame = 0;

    // TODO: Constructor set semua field dan increment totalGame
    Game(String namaGame, String genre, Developer developer) {
        // HINT: this.namaGame = ...; dst.
        this.namaGame = namaGame;
        this.genre = genre;
        this.developer = developer;
        totalGame++;
    }

    // TODO: Saat player join, increment playerCount dan cetak:
    // "<username> bergabung ke game <namaGame>."
    public void joinGame(Player p) {
        // HINT: Akses p.username
        this.playerCount++;
        System.out.println(p.username + " bergabung ke game " + this.namaGame + ".");
    }

    // TODO: Kembalikan totalGame
    public static int getTotalGame() {
        return totalGame; // ganti dengan nilai dari totalGame
    }
}