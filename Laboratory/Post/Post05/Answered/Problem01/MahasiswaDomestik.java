public final class MahasiswaDomestik extends Mahasiswa{
    private Gender gender;

    /*
     * TODO: Implementasikan constructor kelas MahasiswaDomestik
     * gender diinisialisasi sesuai parameter, username dan password diinisialisasi dengan null
     * */
    public MahasiswaDomestik(Gender gender){
        super();
        this.gender = gender;
    }

    /*
     * TODO: Implementasikan method perkenalkan
     * Tampilkan "Halo, saya mahasiswa domestik <gender> dengan username <username>"
     */
    public void perkenalkan(){
        System.out.println("Halo, saya mahasiswa domestik " + this.gender + " dengan username " + getUsername());
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Tampilkan "Mahasiswa domestik <gender> dengan username <username> berhasil mendaftar asrama"
     * panggil method daftarAsrama pada objek asrama
     */
    public void daftarAsrama(Asrama asrama) {
        System.out.println("Mahasiswa domestik " + this.gender + " dengan username " + getUsername() + " berhasil mendaftar asrama");
        asrama.daftarAsrama(this);
    }

    /*
     * TODO: Implementasikan setter dan getter
     * setGender, getGender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return this.gender;
    }
}
