import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        Question first = new Question("Apa bahasa pemrograman yang digunakan untuk aplikasi ini?");
        first.addOption("Python", false);
        first.addOption("Java", true);
        first.addOption("Kotlin", false);
        quiz.addQuestion(first);

        Question second = new Question("Kapan sebuah inner class non-static dapat dibuat?");
        second.addOption("Kapan saja tanpa parent object", false);
        second.addOption("Hanya setelah membuat parent object", true);
        second.addOption("Saat program dikompilasi", false);
        quiz.addQuestion(second);

        Question third = new Question("Apa keuntungan utama menggunakan inner class?");
        third.addOption("Meningkatkan ukuran file secara signifikan", false);
        third.addOption("Menjaga logic relationship antara kelas", true);
        third.addOption("Membuat kode tidak dapat diuji", false);
        quiz.addQuestion(third);

        System.out.println("Selamat datang di aplikasi kuis!");
        System.out.printf("Total pertanyaan: %d%n%n", quiz.size());

        try (Scanner scanner = new Scanner(System.in)) {
            int score = 0;
            for (int i = 0; i < quiz.size(); i++) {
                Question question = quiz.getQuestions().get(i);
                System.out.printf("Pertanyaan %d:%n", i + 1);
                question.display();

                int choice = readAnswer(scanner, question);
                if (quiz.checkAnswer(i, choice)) {
                    System.out.println("Benar!\n");
                    score++;
                } else {
                    System.out.println("Salah.\n");
                }
            }
            System.out.printf("Skor akhir: %d dari %d%n", score, quiz.size());
        }
    }

    private static int readAnswer(Scanner scanner, Question question) {
        int choice;
        while (true) {
            System.out.print("Jawaban Anda (masukkan nomor opsi): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Masukan harus berupa angka. Coba lagi.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (!question.isValidOption(choice)) {
                System.out.println("Nomor opsi tidak valid. Coba lagi.");
                continue;
            }
            return choice;
        }
    }
}
