class Game {
    // TODO: Deklarasi atribut: namaGame (String), genre (String), developer
    // (Developer)
    // TODO: Deklarasi atribut: playerCount (int) awal 0
    // TODO: Deklarasi atribut statik: totalGame (int)

    // TODO: Constructor set semua field dan increment totalGame
    Game(String namaGame, String genre, Developer developer) {
        // HINT: this.namaGame = ...; dst.
    }

    // TODO: Saat player join, increment playerCount dan cetak:
    // "<username> bergabung ke game <namaGame>."
    void joinGame(Player p) {
        // HINT: Akses p.username
    }

    // TODO: Kembalikan totalGame
    static int getTotalGame() {
        return 0; // ganti dengan nilai dari totalGame
    }
}
