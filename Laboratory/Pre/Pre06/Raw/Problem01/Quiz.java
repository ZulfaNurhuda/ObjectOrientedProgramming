import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Quiz {
    // TODO: Deklarasikan field untuk menyimpan daftar pertanyaan

    public Quiz() {
        // TODO: Inisialisasi daftar pertanyaan
    }

    public void addQuestion(Question question) {
        // TODO: Tambahkan pertanyaan ke daftar
    }

    public void displayAllQuestions() {
        // TODO: Iterasi setiap pertanyaan dan tampilkan dengan format "Pertanyaan
        // x:<newline>" lalu detailnya dengan memanggil question.display() dan tambahkan
        // juga 1 newline setelah pemanggilan fungsi display
    }

    public boolean checkAnswer(int questionIndex, int selectedOptionNumber) {
        // TODO: Validasi indeks pertanyaan, jike tidak valid maka keluarkan output:
        // "Question index out of bounds<newline>"
        // kemudian return false
        // TODO: Ambil pertanyaan berdasarkan indeks
        // TODO: Periksa apakah nomor opsi valid, jika tidak valid keluarkan output:
        // "Selected option is not available<newline>"
        // kemudian return false
        // TODO: Kembalikan hasil pemeriksaan jawaban benar
        return false;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(...<list of questions>);
    }

    public int size() {
        // TODO: Mengembalikan jumlah pertanyaan dalam kuis
        return 0;
    }
}
