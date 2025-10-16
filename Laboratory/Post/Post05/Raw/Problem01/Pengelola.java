public final class Pengelola implements User {
    // static Integer pengelolaCounter = 0;
    // String NIP;  // format "2"+5 digit angka (200001, 200002, dst)
    // String username;
    // String password;

    /*
     * TODO: Implementasikan constructor kelas Pengelola
     * username, dan password diinisialisasi null
     * NIP di-generate otomatis dengan format "2"+5 digit angka (200001, 200002, dst)
     * pengelolaCounter diincrement setiap ada objek Pengelola baru
     */
    public Pengelola() {
        // TODO: answer here
    }

    /*
     * TODO: Implementasikan method isRegistered
     * mengembalikan true jika username dan password tidak null
     * mengembalikan false jika username atau password null
     */
    public boolean isRegistered() {
        // TODO: answer here
    }

    /*
     * TODO: Implementasikan method register
     * Jika sudah terdaftar, tampilkan "Pengelola dengan username <username> sudah terdaftar"
     * Jika belum terdaftar, lakukan pendaftaran dengan mengisi username, password, dan NIP
     * Setelah berhasil mendaftar, tampilkan "Pengelola berhasil terdaftar"
     */
    public void register(String username, String password) {
        // TODO: answer here
    }

    /*
     * TODO: Implementasikan method login
     * Jika username dan password sesuai, tampilkan "Login berhasil" dan perkenalkan diri
     * Jika tidak sesuai, tampilkan "Login gagal"
     * perkenalkan diri dilakukan dengan memanggil method perkenalkan()
    */
    public void login(String username, String password) {
        // TODO: answer here
    }


    /*
     * TODO: Implementasikan method perkenalkan
     * Tampilkan "Halo, saya pengelola dengan NIP <NIP> dan username <username>"
     */
    public void perkenalkan() {
        //TODO: answer here
    }

    /*
     * TODO: Implementasikan method terimaPendaftaran
     * Jika mahasiswa sudah memilih asrama, set assigned mahasiswa menjadi true
     * Tampilkan "Pendaftaran mahasiswa <username> telah diverifikasi oleh pengelola <username>"
     * Jika mahasiswa belum memilih asrama, tampilkan "Pengelola gagal melakukan verifikasi pendaftaran mahasiswa <username>"
     */
    public void terimaPendaftaran(Mahasiswa mhs, Asrama asrama) {
        // TODO: answer here
    }
}
