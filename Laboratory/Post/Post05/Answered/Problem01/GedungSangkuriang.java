import java.util.List;
import java.util.ArrayList;

public final class GedungSangkuriang implements Asrama {
    List<Mahasiswa> penghuni;
    Integer kapasitas;

    /*
     * TODO: Implementasikan constructor kelas GedungSangkuriang
     * penghuni diinisialisasi dengan ArrayList baru
     * kapasitas diinisialisasi sesuai parameter
     */
    public GedungSangkuriang(Integer kapasitas) {
        this.penghuni = new ArrayList<>();
        this.kapasitas = kapasitas;
    }

    /*
     * TODO: Implementasikan method infoAsrama
     * Tampilkan "Asrama Gedung Sangkuriang dengan kapasitas <kapasitas>"
     */
    public void infoAsrama() {
        System.out.println("Asrama Gedung Sangkuriang dengan kapasitas " + this.kapasitas);
    }

    /*
     * TODO: Implementasikan method daftarAsrama
     * Jika kapasitas sudah penuh, tampilkan "Asrama Gedung Sangkuriang sudah penuh"
     * Jika mahasiswa sudah terdaftar di asrama lain (assigned), tampilkan "Mahasiswa sudah terdaftar di asrama lain"
     * Jika mahasiswa asing, tampilkan "Mahasiswa asing tidak boleh mendaftar di asrama ini"
     * Jika mahasiswa domestik dan asrama belum penuh, tambahkan mhs ke penghuni,
     * tampilkan "Mahasiswa <username> diterima di asrama Gedung Sangkuriang"
     * Lalu set asrama mahasiswa ke asrama ini
     */
    public void daftarAsrama(Mahasiswa mhs) {
        if (this.penghuni.size() >= this.kapasitas) {
            System.out.println("Asrama Gedung Sangkuriang sudah penuh");
        } else if (mhs.getAssigned()) {
            System.out.println("Mahasiswa sudah terdaftar di asrama lain");
        } else if (mhs instanceof MahasiswaAsing) {
            System.out.println("Mahasiswa asing tidak boleh mendaftar di asrama ini");
        } else {
            if (mhs.getAsrama() != null && mhs.getAsrama() instanceof GedungSangkuriang) {
                ((GedungSangkuriang) mhs.getAsrama()).penghuni.remove(mhs);
            } else if (mhs.getAsrama() != null && mhs.getAsrama() instanceof GedungKidangPananjung) {
                ((GedungKidangPananjung) mhs.getAsrama()).penghuni.remove(mhs);
            } else if (mhs.getAsrama() != null && mhs.getAsrama() instanceof GedungKanayakan) {
                ((GedungKanayakan) mhs.getAsrama()).penghuni.remove(mhs);
            } else if (mhs.getAsrama() != null && mhs.getAsrama() instanceof GedungInternasional) {
                ((GedungInternasional) mhs.getAsrama()).penghuni.remove(mhs);
            }
            this.penghuni.add(mhs);
            System.out.println("Mahasiswa " + mhs.getUsername() + " diterima di asrama Gedung Sangkuriang");
            mhs.setAsrama(this);
        }
    }
}