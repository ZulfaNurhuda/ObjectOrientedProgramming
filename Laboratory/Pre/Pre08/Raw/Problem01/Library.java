import java.util.HashMap;
import java.util.Map;

/* TODO: Lengkapi class Library dengan member management dan exception handling kompleks

   Fields:
   - books (Book[]): array untuk menyimpan buku
   - bookCount (int): jumlah buku saat ini
   - members (Map<String, Member>): HashMap untuk menyimpan member (key: memberId)

   Constructor:
   - Library(int capacity)
     * Inisialisasi books array dengan size capacity
     * Set bookCount = 0
     * Inisialisasi members sebagai new HashMap<>()

   Methods:

   1. void addBook(Book book)
      * Jika book null: throw NullPointerException
      * Jika bookCount >= books.length: throw IllegalStateException
      * Tambah book ke array, increment bookCount

   2. void registerMember(Member member) throws LibraryException
      * Jika member null: throw LibraryException dengan errorCode "INVALID_MEMBER"
      * Jika members.containsKey(member.getMemberId()): throw LibraryException dengan errorCode "DUPLICATE_MEMBER"
      * members.put(member.getMemberId(), member)

   3. Member findMember(String memberId) throws LibraryException
      * Jika memberId null/kosong: throw LibraryException dengan errorCode "INVALID_MEMBER"
      * Get member dari map
      * Jika null: throw LibraryException dengan errorCode "MEMBER_NOT_FOUND"
      * Return member

   4. Book findBook(String title)
      * Jika title null: return null
      * Loop books array, bandingkan dengan equalsIgnoreCase
      * Return book jika ditemukan, null jika tidak

   5. Book findBookByISBN(String isbn) throws InvalidBookException
      * Jika isbn null/kosong: throw InvalidBookException
      * Loop books array, bandingkan ISBN
      * Return book jika ditemukan, null jika tidak

   6. void borrowBook(String memberId, String bookTitle) throws LibraryException
      PENTING: Method ini harus menggunakan try-catch-finally!

      * Declare: Member member = null, Book book = null
      * Try block:
        - member = findMember(memberId)
        - book = findBook(bookTitle)
        - Jika book == null: throw BookNotAvailableException (buku tidak ditemukan)
        - member.borrowBook(bookTitle) - ini bisa throw LibraryException
        - book.borrowBook() - ini bisa throw BookNotAvailableException

      * Catch blocks (PENTING: Gunakan dua catch blocks terpisah, bukan multi-catch, karena BookNotAvailableException adalah subclass dari LibraryException):
        catch (BookNotAvailableException e)
        - Re-throw exception
        catch (LibraryException e)
        - Re-throw exception

      * Finally block:
        - WAJIB PRINT: "Transaction attempt completed for: " + member.getName()
        - Hanya print jika member != null
        - Format EXACT: "Transaction attempt completed for: <nama member tanpa <> >"
        - Contoh: "Transaction attempt completed for: Alice Johnson"

   7. void returnBook(String memberId, String bookTitle) throws LibraryException
      PENTING: Gunakan try-catch-finally pattern seperti borrowBook!

      * Declare: Member member = null, Book book = null
      * Try:
        - member = findMember(memberId)
        - book = findBook(bookTitle)
        - Jika book == null: throw InvalidBookException
        - member.returnBook(bookTitle)
        - book.returnBook()

      * Catch blocks (PENTING: Gunakan dua catch blocks terpisah):
        catch (InvalidBookException e)
        - Re-throw
        catch (LibraryException e)
        - Re-throw

      * Finally:
        - WAJIB PRINT: "Return transaction completed for: " + member.getName()
        - Hanya print jika member != null
        - Format EXACT: "Return transaction completed for: <nama member tanpa <> >"
        - Contoh: "Return transaction completed for: Bob Smith"

   8. void displayAllBooks()
      * Jika bookCount == 0:
        - WAJIB PRINT EXACT: "Perpustakaan kosong."
      * Else:
        - WAJIB PRINT EXACT: "=== Daftar Buku di Perpustakaan ==="
        - Loop dan print setiap buku dengan format: "<nomor>. <book.toString()>"
        - Nomor mulai dari 1
        - Contoh output:
          === Daftar Buku di Perpustakaan ===
          1. Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/3
          2. Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2

   9. void displayAllMembers()
      * Jika members.isEmpty():
        - WAJIB PRINT EXACT: "Tidak ada anggota terdaftar."
      * Else:
        - WAJIB PRINT EXACT: "=== Daftar Anggota Perpustakaan ==="
        - Loop members.values() dan print setiap member dengan format: "<nomor>. <member.toString()>"
        - Nomor mulai dari 1
        - Contoh output:
          === Daftar Anggota Perpustakaan ===
          1. Alice Johnson (ID: M001) - Borrowed: 2/3
          2. Bob Smith (ID: M002) - Borrowed: 0/5

   10. void displayMemberBooks(String memberId) throws LibraryException
       * member = findMember(memberId)
       * WAJIB PRINT EXACT: "=== Buku yang Dipinjam oleh " + member.getName() + " ==="
       * Jika getCurrentBorrowedCount() == 0:
         - WAJIB PRINT EXACT: "Tidak ada buku yang dipinjam."
       * Else:
         - Loop dan print setiap buku dengan format: "- <judul buku>"
       * Contoh output:
         === Buku yang Dipinjam oleh Alice Johnson ===
         - Clean Code
         - Design Patterns

   11. int getBookCount(): return bookCount
   12. int getMemberCount(): return members.size()

   HINTS:
   - Gunakan multi-catch untuk menangkap beberapa exception types
   - try-catch-finally memastikan cleanup code berjalan
   - Finally block berjalan bahkan jika ada exception
   - Throw LibraryException sebagai parent untuk polimorfisme
*/

public class Library {
    // TODO: Implement all methods with proper exception handling
}
