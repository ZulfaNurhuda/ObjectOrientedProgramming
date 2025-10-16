import java.util.ArrayList;
import java.util.List;

public class Library {
    // Todo: Buat atribut name (String) dan sections (List<Section>)

    public Library(String name) {
        // Todo: Implementasi konstruktor dengan inisialisasi atribut name dengan parameter name
        // dan inisialisasi sections sebagai ArrayList kosong
    }

    // Todo: Implementasi method addSection yang menerima parameter Section
    // Method ini menambahkan section ke list sections
    // Tampilkan pesan: "Section '[nama section]' added to [nama library]"

    // Todo: Implementasi method findBook yang menerima parameter String title
    // Method ini mencari buku berdasarkan judul di semua section
    // Jika ditemukan, tampilkan:
    // - "Found "[title]" in [nama section] section"
    // - Detail buku menggunakan getDetails()
    // Jika tidak ditemukan, tampilkan: "Book "[title]" not found in library"

    // Todo: Implementasi method displayAllBooks tanpa parameter
    // Method ini menampilkan semua buku di semua section

    // Todo: Implementasi getter getName() yang mengembalikan name

    // Todo: Implementasi getter getSections() yang mengembalikan sections

    // Static Nested Class - Section
    public static class Section {
        // Todo: Buat atribut sectionName (String) dan books (List<Book>)

        public Section(String sectionName) {
            // Todo: Implementasi konstruktor
            // Inisialisasi sectionName dengan parameter
            // Inisialisasi books sebagai ArrayList kosong
        }

        // Todo: Implementasi method addBook yang menerima parameter Book
        // Method ini menambahkan book ke list books
        // Tampilkan pesan: "Book "[judul buku]" added to [nama section] section"

        // Todo: Implementasi method removeBook yang menerima parameter String title
        // Method ini menghapus buku berdasarkan judul dari list books
        // Gunakan looping untuk mencari buku dengan judul yang sesuai (case-insensitive)
        // Jika ditemukan:
        // - Hapus buku dari list
        // - Tampilkan: "Book "[title]" removed from [nama section] section"
        // Jika tidak ditemukan:
        // - Tampilkan: "Book "[title]" not found in [nama section] section"

        // Todo: Implementasi method displayBooks tanpa parameter
        // Jika books kosong, tampilkan: "No books in this section"
        // Jika ada buku, tampilkan detail setiap buku

        // Todo: Implementasi getter getSectionName() yang mengembalikan sectionName

        // Todo: Implementasi getter getBooks() yang mengembalikan books

        // Non-static Inner Class - Book
        public class Book {
            // Todo: Buat atribut:
            // - title (String)
            // - author (String)
            // - isAvailable (boolean)
            // - borrowedBy (String)

            public Book(String title, String author) {
                // Todo: Implementasi konstruktor
                // Inisialisasi title dan author dengan parameter
                // Set isAvailable = true
                // Set borrowedBy = null
            }

            // Todo: Implementasi method borrowBook yang menerima parameter String memberName
            // Jika buku sudah dipinjam (!isAvailable):
            // - Tampilkan: "Error: Book "[title]" is already borrowed by [borrowedBy]"
            
            // Jika tersedia:
            // - Set isAvailable = false
            // - Set borrowedBy = memberName
            // - Tampilkan: "Book "[title]" is now borrowed by [memberName]"

            // Todo: Implementasi method returnBook tanpa parameter
            // Jika buku sedang tidak dipinjam (isAvailable):
            // - Tampilkan: "Error: Book "[title]" is not currently borrowed"

            // Jika sedang dipinjam:
            // - Tampilkan: "Book "[title]" returned by [borrowedBy]"
            // - Set isAvailable = true
            // - Set borrowedBy = null

            // Todo: Implementasi method getDetails() yang mengembalikan String
            // Buat variabel status:
            // - Jika isAvailable = true, status = "Available"
            // - Jika isAvailable = false, status = "Borrowed by [borrowedBy]"
            // Return format: "Book "[title]" by [author] [[status]] - Section: [sectionName]"
            // Note: Book dapat mengakses sectionName dari enclosing class Section

            // Todo: Implementasi getter getTitle() yang mengembalikan title

            // Todo: Implementasi getter getAuthor() yang mengembalikan author

            // Todo: Implementasi getter isAvailable() yang mengembalikan isAvailable
        }
    }

    public static class Member {
        // Todo: Buat atribut:
        // - name (String)
        // - borrowedBooks (List<Section.Book>)
        // - maxBorrowLimit (int)

        public Member(String name, int maxBorrowLimit) {
            // Todo: Implementasi konstruktor
            // Inisialisasi name dan maxBorrowLimit dengan parameter
            // Inisialisasi borrowedBooks sebagai ArrayList kosong
        }

        // Todo: Implementasi method canBorrow() yang mengembalikan boolean
        // Return true jika jumlah borrowedBooks < maxBorrowLimit
        // Return false jika sudah mencapai limit

        // Todo: Implementasi method borrowBook yang menerima parameter Section.Book book
        // Jika member tidak bisa meminjam lagi (!canBorrow()):
        // - Tampilkan: "Error: [name] has reached the borrow limit of [maxBorrowLimit] books"
        
        // Jika buku tidak tersedia (!book.isAvailable()):
        // - Tampilkan: "Error: Book "[judul buku]" is not available"
      
        // Jika bisa meminjam:
        // - Panggil book.borrowBook(name)
        // - Tambahkan book ke borrowedBooks

        // Todo: Implementasi method returnBook yang menerima parameter Section.Book book
        // Jika book ada di borrowedBooks:
        // - Panggil book.returnBook()
        // - Hapus book dari borrowedBooks
        // Jika book tidak ada di borrowedBooks:
        // - Tampilkan: "Error: [name] has not borrowed "[judul buku]""

        // Todo: Implementasi method displayBorrowedBooks tanpa parameter
        // Tampilkan: "[name]'s Borrowed Books ([jumlah borrowed]/[maxBorrowLimit]):"
        // Jika borrowedBooks kosong:
        // - Tampilkan: "No books currently borrowed"
        // Jika ada buku yang dipinjam:
        // - Untuk setiap buku, tampilkan: "  - [title] by [author]"
    }
}