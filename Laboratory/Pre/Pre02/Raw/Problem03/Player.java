class Player {
    // TODO: Deklarasikan atribut: username (String), avatar (Avatar), game (Game)
    // TODO: Deklarasikan static int totalPlayer untuk menghitung total player
    // dibuat

    // TODO: Constructor set username dan avatar, dan increment totalPlayer
    Player(String username, Avatar avatar) {
        // HINT: this.username = username; dst.
    }

    // TODO: Method joinGame: set game ke g kemudian panggil g.joinGame(this)
    void joinGame(Game g) {
    }

    // TODO: Tampilkan profil sesuai format:
    // Username: <username>.
    // Avatar: <namaSkin> (Lv.<level>).
    // Sedang bermain: <namaGame>.
    // ATAU jika belum gabung: Belum bergabung ke game.
    // Diakhiri 1 baris kosong
    void showProfile() {
        // HINT: Cek game == null
    }

    // TODO: Kembalikan totalPlayer
    static int getTotalPlayer() {
        return 0; // ganti dengan nilai dari totalPlayer
    }
}
