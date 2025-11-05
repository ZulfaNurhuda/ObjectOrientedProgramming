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
	private Book[] books;
	private int bookCount;
	private Map<String, Member> members;

	public Library(int capacity) {
		this.books = new Book[capacity];
		this.bookCount = 0;
		this.members = new HashMap<String, Member>();
	}

	public void addBook(Book book) {
		if (book == null) {
			throw new NullPointerException("Book cannot be null");
		}
		if (bookCount >= books.length) {
			throw new IllegalStateException("Library is at full capacity");
		}
		books[bookCount++] = book;
	}

	public void registerMember(Member member) throws LibraryException {
		if (member == null) {
			throw new LibraryException("Member cannot be null", "INVALID_MEMBER");
		}
		if (members.containsKey(member.getMemberId())) {
			throw new LibraryException("Member already registered", "DUPLICATE_MEMBER");
		}
		members.put(member.getMemberId(), member);
	}

	public Member findMember(String memberId) throws LibraryException {
		if (memberId == null || memberId.trim().isEmpty()) {
			throw new LibraryException("Invalid member ID", "INVALID_MEMBER");
		}
		Member member = members.get(memberId);
		if (member == null) {
			throw new LibraryException("Member not found", "MEMBER_NOT_FOUND");
		}
		return member;
	}

	public Book findBook(String title) {
		Book foundBook = null;
		if (title != null) {
			for (int i = 0; i < bookCount && foundBook == null; i++) {
				if (books[i].getTitle().equalsIgnoreCase(title)) {
					foundBook = books[i];
				}
			}
		}
		return foundBook;
	}

	public Book findBookByISBN(String isbn) throws InvalidBookException {
		if (isbn == null || isbn.trim().isEmpty()) {
			throw new InvalidBookException("ISBN cannot be null or empty");
		}
		Book foundBook = null;
		for (int i = 0; i < bookCount && foundBook == null; i++) {
			if (books[i].getIsbn().equals(isbn)) {
				foundBook = books[i];
			}
		}
		return foundBook;
	}

	public void borrowBook(String memberId, String bookTitle) throws LibraryException {
		Member member = null;
		Book book = null;
		try {
			member = findMember(memberId);
			book = findBook(bookTitle);
			if (book == null) {
				throw new BookNotAvailableException("Book not found: " + bookTitle);
			}
			member.borrowBook(bookTitle);
			book.borrowBook();
		} catch (BookNotAvailableException e) {
			throw e;
		} catch (LibraryException e) {
			throw e;
		} finally {
			if (member != null) {
				System.out.println("Transaction attempt completed for: " + member.getName());
			}
		}
	}

	public void returnBook(String memberId, String bookTitle) throws LibraryException {
		Member member = null;
		Book book = null;
		try {
			member = findMember(memberId);
			book = findBook(bookTitle);
			if (book == null) {
				throw new InvalidBookException("Book not found: " + bookTitle, "N/A", "bookTitle", bookTitle);
			}
			member.returnBook(bookTitle);
			book.returnBook();
		} catch (InvalidBookException e) {
			throw e;
		} catch (LibraryException e) {
			throw e;
		} finally {
			if (member != null) {
				System.out.println("Return transaction completed for: " + member.getName());
			}
		}
	}

	public void displayAllBooks() {
		if (bookCount == 0) {
			System.out.println("Perpustakaan kosong.");
		} else {
			System.out.println("=== Daftar Buku di Perpustakaan ===");
			for (int i = 0; i < bookCount; i++) {
				System.out.printf("%d. %s\n", i + 1, books[i].toString());
			}
		}
	}

	public void displayAllMembers() {
		if (members.isEmpty()) {
			System.out.println("Tidak ada anggota terdaftar.");
		} else {
			System.out.println("=== Daftar Anggota Perpustakaan ===");
			int index = 1;
			for (Member member : members.values()) {
				System.out.printf("%d. %s\n", index++, member.toString());
			}
		}
	}

	public void displayMemberBooks(String memberId) throws LibraryException {
		Member member = findMember(memberId);
		System.out.println("=== Buku yang Dipinjam oleh " + member.getName() + " ===");
		if (member.getCurrentBorrowedCount() == 0) {
			System.out.println("Tidak ada buku yang dipinjam.");
		} else {
			for (String bookTitle : member.getBorrowedBooks()) {
				System.out.println("- " + bookTitle);
			}
		}
	}

	public int getBookCount() {
		return bookCount;
	}

	public int getMemberCount() {
		return members.size();
	}
}
