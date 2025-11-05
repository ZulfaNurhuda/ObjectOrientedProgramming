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
    private String bookTitle;
    private int requestedCopies;
    private int availableCopies;

    public BookNotAvailableException(String message) {
        super(message, "BOOK_NOT_AVAILABLE");
    }

    public BookNotAvailableException(String message, String bookTitle, int requestedCopies, int availableCopies) {
        super(message, "BOOK_NOT_AVAILABLE");
        this.bookTitle = bookTitle;
        this.requestedCopies = requestedCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getRequestedCopies() {
        return requestedCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    @Override
    public String getMessage() {
        return String.format("[BOOK_NOT_AVAILABLE] %s (Book: '%s', Requested: %d, Available: %d)", super.getMessage(), bookTitle, requestedCopies, availableCopies);
    }
}
