import java.util.ArrayList;
import java.util.List;

/* TODO: Lengkapi class Member
   Class untuk member perpustakaan dengan batasan peminjaman.

   Fields:
   - name (String): nama member
   - memberId (String): ID unik member
   - maxBorrowLimit (int): maksimal buku yang bisa dipinjam
   - borrowedBooks (List<String>): daftar judul buku yang sedang dipinjam
   - isActive (boolean): status aktif member

   Constructor:
   - Member(String name, String memberId, int maxBorrowLimit) throws LibraryException
     Validasi:
     * name tidak boleh null/kosong (after trim) -> throw LibraryException dengan errorCode "INVALID_MEMBER"
     * memberId tidak boleh null/kosong (after trim) -> throw LibraryException dengan errorCode "INVALID_MEMBER"
     * maxBorrowLimit harus > 0 -> throw LibraryException dengan errorCode "INVALID_MEMBER"
     * inisialisasi borrowedBooks sebagai ArrayList kosong
     * set isActive = true

   Methods:
   - getters untuk semua fields: getName(), getMemberId(), getMaxBorrowLimit(), isActive()
   - getCurrentBorrowedCount(): return jumlah buku yang dipinjam
   - getBorrowedBooks(): return copy of list (new ArrayList<>(borrowedBooks))
   - setActive(boolean active): set status aktif

   - borrowBook(String bookTitle) throws LibraryException
     * URUTAN PENGECEKAN PENTING:
     1. Cek member aktif, jika tidak throw LibraryException dengan errorCode "MEMBER_INACTIVE"
     2. Cek belum meminjam buku ini (DUPLICATE CHECK FIRST!), jika sudah throw LibraryException dengan errorCode "ALREADY_BORROWED"
        Format message: "Anggota <name> sudah meminjam buku '<bookTitle>'."
     3. Cek belum mencapai limit, jika sudah throw LibraryException dengan errorCode "LIMIT_EXCEEDED"
        Format message: "Anggota <name> telah mencapai batas peminjaman (<current>/<max>)."
     4. Tambahkan bookTitle ke borrowedBooks

   - returnBook(String bookTitle) throws LibraryException
     * Cek buku ada di borrowedBooks, jika tidak throw LibraryException dengan errorCode "NOT_BORROWED"
       Format message: "Anggota <name> tidak meminjam buku '<bookTitle>'."
     * Hapus bookTitle dari borrowedBooks

   - hasBorrowedBook(String bookTitle): return true jika ada di borrowedBooks

   - toString(): return format string
     * Format EXACT (abaikan simbol <>): "<name> (ID: <id>) - Borrowed: <count>/<limit>"
     * <name> = nama member
     * <id> = memberId
     * <count> = getCurrentBorrowedCount()
     * <limit> = maxBorrowLimit
     * Contoh: "Alice Johnson (ID: M001) - Borrowed: 2/3"
     * Contoh: "Bob Smith (ID: M002) - Borrowed: 0/5"
*/

public class Member {
	// TODO: Implementasi class Member dengan exception handling
	private String name;
	private String memberId;
	private int maxBorrowLimit;
	private List<String> borrowedBooks;
	private boolean isActive;

	public Member(String name, String memberId, int maxBorrowLimit) throws LibraryException {
		if (name == null || name.trim().isEmpty()) {
			throw new LibraryException("Member name cannot be null or empty", "INVALID_MEMBER");
		}
		
		if (memberId == null || memberId.trim().isEmpty()) {
			throw new LibraryException("Member id cannot be null or empty", "INVALID_MEMBER");
		}
		
		if (maxBorrowLimit <= 0) {
			throw new LibraryException("Max borrowed limit cannot be negative", "INVALID_MEMBER");
		}
		
		this.name = name;
		this.memberId = memberId;
		this.maxBorrowLimit = maxBorrowLimit;
		this.borrowedBooks = new ArrayList<String>();
		this.isActive = true;
	}

	public String getName() {
		return name;
	}

	public String getMemberId() {
		return memberId;
	}

	public int getMaxBorrowLimit() {
		return maxBorrowLimit;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getCurrentBorrowedCount() {
		return borrowedBooks.size();
	}

	public List<String> getBorrowedBooks() {
		return new ArrayList<String>(borrowedBooks);
	}

	public void setActive(boolean active) {
		this.isActive = active;
	}

	public void borrowBook(String bookTitle) throws LibraryException {
		if (!isActive) {
			throw new LibraryException("Member is inactive", "MEMBER_INACTIVE");
		}
		if (borrowedBooks.contains(bookTitle)) {
			throw new LibraryException("Member " + name + " has already borrowed '" + bookTitle + "'", "ALREADY_BORROWED");
		}
		if (getCurrentBorrowedCount() >= maxBorrowLimit) {
			throw new LibraryException("Member " + name + " has reached borrow limit (" + getCurrentBorrowedCount() + "/" + maxBorrowLimit + ")", "LIMIT_EXCEEDED");
		}
		borrowedBooks.add(bookTitle);
	}

	public void returnBook(String bookTitle) throws LibraryException {
		if (!borrowedBooks.contains(bookTitle)) {
			throw new LibraryException("Member " + name + " has not borrowed '" + bookTitle + "'", "NOT_BORROWED");
		}
		borrowedBooks.remove(bookTitle);
	}

	public boolean hasBorrowedBook(String bookTitle) {
		return borrowedBooks.contains(bookTitle);
	}

	@Override
	public String toString() {
		return String.format("%s (ID: %s) - Borrowed: %d/%d", name, memberId, getCurrentBorrowedCount(), maxBorrowLimit);
	}
}
