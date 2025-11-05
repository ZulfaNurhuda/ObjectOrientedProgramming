public class Registration {
    
    public Student registerStudent(String name, int age, String password) throws InvalidNameException, InvalidAgeException, WeakPasswordException {
        // TODO:
        // 1. Panggil validateName untuk memverifikasi parameter name.
        // 2. Panggil validateAge untuk memverifikasi parameter age.
        // 3. Panggil validatePassword untuk memverifikasi parameter password.
        // 4. Jika semua validasi lolos, buat dan kembalikan objek Student baru
        // dengan data yang diberikan.
        validateName(name);
        validateAge(age);
        validatePassword(password);

        return new Student(name, age, password);
    }

    private void validateName(String name) throws InvalidNameException {
        // TODO:
        // 1. Periksa jika name null, kosong, atau panjangnya setelah trim kurang dari 3
        // karakter.
        // 2. Jika tidak valid, lempar InvalidNameException dengan pesan persis "Nama
        // harus minimal 3 karakter!".
        if (name == null || name.trim().length() < 3) {
            throw new InvalidNameException("Nama harus minimal 3 karakter!");
        }
    }

    private void validateAge(int age) throws InvalidAgeException {
        // TODO:
        // 1. Periksa apakah age bernilai kurang dari 13.
        // 2. Jika tidak valid, lempar InvalidAgeException dengan pesan persis "Umur
        // harus minimal 13 tahun!".
        if (age < 13) {
            throw new InvalidAgeException("Umur harus minimal 13 tahun!");
        }
    }

    private void validatePassword(String password) throws WeakPasswordException {
        // TODO:
        // 1. Periksa apakah password null, panjangnya kurang dari 6 karakter, atau
        // tidak mengandung digit (gunakan regex atau loop).
        // 2. Jika tidak valid, lempar WeakPasswordException dengan pesan persis
        // "Password harus minimal 6 karakter dan mengandung angka!".
        if (password == null || password.length() < 6 || !password.matches(".*\\d.*")) {
            throw new WeakPasswordException("Password harus minimal 6 karakter dan mengandung angka!");
        }
    }
}
