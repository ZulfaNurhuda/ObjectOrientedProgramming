public class MahasiswaAsing extends Mahasiswa {
    private String country;

    /*
     * TODO: Implementasikan constructor kelas MahasiswaAsing
     * country diinisialisasi sesuai parameter, username dan password diinisialisasi dengan null
     */
    MahasiswaAsing(String country) {
        super();
        this.country = country;
    }

    /*
     * TODO: Implementasikan method perkenalkan
     * Tampilkan "Halo, saya mahasiswa asing dengan username <username> dari negara <country>"
     */
    public void perkenalkan() {
        System.out.println("Halo, saya mahasiswa asing dengan username " + getUsername() + " dari negara " + this.country);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Tampilkan "Mahasiswa asing dengan username <username> dari negara <country> berhasil mendaftar asrama"
     * panggil method daftarAsrama pada objek asrama
     */
    public void daftarAsrama(Asrama asrama) {
        System.out.println("Mahasiswa asing dengan username " + getUsername() + " dari negara " + this.country + " berhasil mendaftar asrama");
        asrama.daftarAsrama(this);
    }
    
    /*
     * TODO: Implementasikan setter dan getter
     * setCountry, getCountry
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }
}
