/* TODO: Lengkapi class InvalidBookException
   Exception ini dilempar ketika data buku tidak valid.
   Class ini extends LibraryException.

   Fields tambahan:
   - bookTitle (String): judul buku yang invalid
   - invalidField (String): field mana yang invalid (misalnya "title", "author", "isbn")
   - invalidValue (String): nilai yang invalid (optional)

   Constructors yang dibutuhkan:
   1. InvalidBookException(String message) - panggil super dengan errorCode "INVALID_BOOK"
   2. InvalidBookException(String message, Throwable cause) - untuk exception chaining
   3. InvalidBookException(String message, String bookTitle, String invalidField)
   4. InvalidBookException(String message, String bookTitle, String invalidField, String invalidValue)

   Methods:
   - getBookTitle(), getInvalidField(), getInvalidValue()
   - getMessage(): override untuk menambahkan informasi bookTitle, invalidField, dan invalidValue

   Format message: "[INVALID_BOOK] <message> (Book: '<bookTitle>', Invalid Field: <invalidField>, Value: '<invalidValue>')"
   Jika invalidValue null, jangan tampilkan bagian "Value: ..."
*/

public class InvalidBookException extends LibraryException {
    // TODO: Implementasi
}
