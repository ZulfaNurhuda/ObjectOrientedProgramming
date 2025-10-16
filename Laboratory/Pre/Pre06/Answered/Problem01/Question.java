import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    // TODO: Deklarasikan field untuk menyimpan teks pertanyaan
    // TODO: Deklarasikan field untuk daftar Option
    // TODO: Deklarasikan field untuk indeks jawaban yang benar
    private String text;
    private List<Option> options;
    private int correctAnswerIndex;

    public Question(String text) {
        // TODO: Inisialisasi teks pertanyaan dan struktur data daftar option
        // TODO: Atur nilai awal indeks jawaban benar (misalnya -1)
        this.text = text;
        options = new ArrayList<Option>();
        correctAnswerIndex = -1;
    }

    public void addOption(String optionText, boolean correct) {
        // TODO: Buat objek Option baru menggunakan inner class
        // TODO: Tambahkan option ke dalam daftar
        // TODO: Jika parameter correct true, perbarui indeks jawaban benar
        Option newOption = new Option(optionText);
        options.add(newOption);
        if (correct) {
            correctAnswerIndex = options.size() - 1;
        }
    }

    public void display() {
        // TODO: Cetak teks pertanyaan yang diakhiri newline
        // TODO: Iterasi seluruh option dan tampilkan dengan format "nomor.
        // teks<newline>"
        System.out.println(text);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i).getText());
        }
    }

    public boolean isCorrect(int selectedOptionNumber) {
        // TODO: Konversi nomor 1-based menjadi indeks 0-based dan bandingkan dengan
        // jawaban benar yang disimpan di dalam kelas
        return (selectedOptionNumber - 1) == correctAnswerIndex;
    }

    public boolean isValidOption(int selectedOptionNumber) {
        // TODO: Periksa apakah nomor opsi berada dalam rentang indeks daftar option
        return selectedOptionNumber >= 1 && selectedOptionNumber <= options.size();
    }

    public List<Option> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public class Option {
        // TODO: Deklarasikan field untuk menyimpan teks option
        private String text;

        private Option(String text) {
            // TODO: Simpan teks option pada field yang sesuai
            this.text = text;
        }

        public String getText() {
            // TODO: Mengembalikan teks option
            return text;
        }
    }
}
