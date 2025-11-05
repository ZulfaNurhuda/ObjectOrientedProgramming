/* TODO: Lengkapi class BookNotAvailableException
   Exception ini dilempar ketika buku tidak tersedia untuk dipinjam.
   Class ini extends LibraryException.

   Fields tambahan:
   - bookTitle (String): judul buku
   - requestedCopies (int): jumlah copy yang diminta
   - availableCopies (int): jumlah copy yang tersedia

   Constructors:
   1. BookNotAvailableException(String message) - dengan errorCode "BOOK_NOT_AVAILABLE"
   2. BookNotAvailableException(String message, String bookTitle, int requestedCopies, int availableCopies)

   Methods:
   - getBookTitle(), getRequestedCopies(), getAvailableCopies()
   - getMessage(): format "[BOOK_NOT_AVAILABLE] <message> (Book: '<title>', Requested: <n>, Available: <m>)"
*/

public class BookNotAvailableException extends LibraryException {
    // TODO: Implementasi
}
