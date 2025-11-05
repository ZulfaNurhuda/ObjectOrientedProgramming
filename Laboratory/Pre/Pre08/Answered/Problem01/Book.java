/* TODO: Lengkapi class Book dengan validasi ISBN dan exception handling

   Fields:
   - title (String)
   - author (String)
   - isbn (String): ISBN-10 atau ISBN-13
   - publicationYear (int)
   - copies (int): total copies
   - availableCopies (int): copies yang tersedia

   Constructor:
   - Book(String title, String author, String isbn, int publicationYear, int copies)
     throws InvalidBookException

     Validasi (throw InvalidBookException dengan bookTitle, invalidField, dan optional invalidValue):
     1. title tidak boleh null/kosong (trim)
     2. author tidak boleh null/kosong (trim)
     3. author harus minimal 2 kata (pisahkan dengan split("\\s+"))
     4. publicationYear harus antara 1000 dan tahun sekarang (gunakan java.time.Year.now().getValue())
     5. copies tidak boleh negatif
     6. ISBN harus valid (panggil isValidISBN)

     Jika semua valid:
     - Set semua fields (trim untuk String)
     - Set availableCopies = copies

   Private Helper Methods untuk ISBN Validation:

   - boolean isValidISBN(String isbn)
     * Return false jika isbn null
     * Remove hyphens dan spaces: cleanISBN = isbn.replaceAll("[\\s-]", "")
     * Jika length 10: return isValidISBN10(cleanISBN)
     * Jika length 13: return isValidISBN13(cleanISBN)
     * Otherwise: return false

   - boolean isValidISBN10(String isbn)
     * ISBN-10 checksum algorithm:
       - Sum = (digit1 * 10) + (digit2 * 9) + ... + (digit9 * 2) + check_digit
       - Check digit bisa 'X' (nilai 10) atau digit 0-9
       - Valid jika Sum % 11 == 0
     * Gunakan try-catch untuk handle exceptions, return false jika error

   - boolean isValidISBN13(String isbn)
     * ISBN-13 checksum algorithm:
       - Sum = digit1 + (digit2 * 3) + digit3 + (digit4 * 3) + ... + digit13
       - Digit ganjil (index 0,2,4...) * 1, digit genap (index 1,3,5...) * 3
       - Valid jika Sum % 10 == 0
     * Gunakan try-catch, return false jika error

   Public Methods:

   - getters untuk semua fields (getTitle, getAuthor, getIsbn, getPublicationYear, getCopies, getAvailableCopies)

   - void borrowBook() throws BookNotAvailableException
     * Jika availableCopies <= 0: throw BookNotAvailableException dengan detail (title, requestedCopies=1, availableCopies)
     * Kurangi availableCopies

   - void returnBook() throws InvalidBookException
     * Jika availableCopies >= copies: throw InvalidBookException
     * Tambah availableCopies

   - toString(): return format string
     * Format EXACT (abaikan simbol <>): "<title> by <author> (<year>) [ISBN: <isbn>] - Available: <avail>/<total>"
     * <title> = judul buku
     * <author> = nama penulis
     * <year> = tahun publikasi
     * <isbn> = ISBN (dengan hyphens/spaces seperti input asli)
     * <avail> = availableCopies
     * <total> = copies
     * Contoh: "Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/5"
     * Contoh: "Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2"
*/

public class Book {
	// TODO: Declare fields
	private String title;
	private String author;
	private String isbn;
	private int publicationYear;
	private int copies;
	private int availableCopies;

	// TODO: Implement constructor dengan validasi lengkap
	Book(String title, String author, String isbn, int publicationYear, int copies) throws InvalidBookException {
		if (title == null || title.trim().isEmpty()) {
			throw new InvalidBookException("Title cannot be null or empty", title, "title");
		}

		if (author == null || author.trim().isEmpty()) {
			throw new InvalidBookException("Author cannot be null or empty", title, "author");
		}

		String[] authorParts = author.trim().split("\\s+");
		if (authorParts.length < 2) {
			throw new InvalidBookException("Author must have at least two words", title, "author", author);
		}

		int currentYear = java.time.Year.now().getValue();
		if (publicationYear < 1000 || publicationYear > currentYear) {
			throw new InvalidBookException("Publication year must be between 1000 and " + currentYear, title, "publicationYear", Integer.toString(publicationYear));
		}

		if (copies < 0) {
			throw new InvalidBookException("Copies cannot be negative", title, "copies", Integer.toString(copies));
		}

		if (!isValidISBN(isbn)) {
			throw new InvalidBookException("Invalid ISBN", title, "isbn", isbn);
		}

		this.title = title.trim();
		this.author = author.trim();
		this.isbn = isbn;
		this.publicationYear = publicationYear;
		this.copies = copies;
		this.availableCopies = copies;
	}

	// TODO: Implement private helper methods untuk ISBN validation
	private boolean isValidISBN(String isbn) {
		boolean valid = false;
		if (isbn != null) {
			String cleanISBN = isbn.replaceAll("[\\s-]", "");
			if (cleanISBN.length() == 10) {
				valid = isValidISBN10(cleanISBN);
			} else if (cleanISBN.length() == 13) {
				valid = isValidISBN13(cleanISBN);
			}
		}
		return valid;
	}

	private boolean isValidISBN10(String isbn) {
		boolean valid = false;
		try {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				int digit = Character.getNumericValue(isbn.charAt(i));
				sum += digit * (10 - i);
			}
			char checkChar = isbn.charAt(9);
			int checkDigit = (checkChar == 'X') ? 10 : Character.getNumericValue(checkChar);
			sum += checkDigit;
			valid = sum % 11 == 0;
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

	private boolean isValidISBN13(String isbn) {
		boolean valid = false;
		try {
			int sum = 0;
			for (int i = 0; i < 13; i++) {
				int digit = Character.getNumericValue(isbn.charAt(i));
				sum += (i % 2 == 0) ? digit : digit * 3;
			}
			valid = sum % 10 == 0;
		} catch (Exception e) {
			valid = false;
		}
		return valid;
	}

	// TODO: Implement getters
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getCopies() {
		return copies;
	}

	public int getAvailableCopies() {
		return availableCopies;
	}

	// TODO: Implement borrowBook()
	public void borrowBook() throws BookNotAvailableException {
		if (availableCopies <= 0) {
			throw new BookNotAvailableException("Book not available", title, 1, availableCopies);
		}
		availableCopies--;
	}

	// TODO: Implement returnBook()
	public void returnBook() throws InvalidBookException {
		if (availableCopies >= copies) {
			throw new InvalidBookException("All copies are already returned", title, "availableCopies", Integer.toString(availableCopies));
		}
		availableCopies++;
	}

	// TODO: Implement toString()
	@Override
	public String toString() {
		return String.format("%s by %s (%d) [ISBN: %s] - Available: %d/%d", title, author, publicationYear, isbn, availableCopies, copies);
	}
}
