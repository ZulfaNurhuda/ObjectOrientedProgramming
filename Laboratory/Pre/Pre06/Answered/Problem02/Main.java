public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("SECTION 1: Basic Library Operations");
        System.out.println("=".repeat(60));
        
        Library lib = new Library("City Library");
        System.out.println("Library created: " + lib.getName());
        
        Library.Section fiction = new Library.Section("Fiction");
        Library.Section science = new Library.Section("Science");
        Library.Section history = new Library.Section("History");
        
        System.out.println("\nSection names: " + fiction.getSectionName() + ", " + 
                          science.getSectionName() + ", " + history.getSectionName());
        
        Library.Section.Book book1 = fiction.new Book("1984", "George Orwell");
        Library.Section.Book book2 = fiction.new Book("Animal Farm", "George Orwell");
        Library.Section.Book book3 = science.new Book("Cosmos", "Carl Sagan");
        Library.Section.Book book4 = science.new Book("A Brief History of Time", "Stephen Hawking");
        Library.Section.Book book5 = history.new Book("Sapiens", "Yuval Noah Harari");
        
        fiction.addBook(book1);
        fiction.addBook(book2);
        science.addBook(book3);
        science.addBook(book4);
        history.addBook(book5);
        
        lib.addSection(fiction);
        lib.addSection(science);
        lib.addSection(history);
        
        System.out.println("\nTotal sections in library: " + lib.getSections().size());
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SECTION 2: Book Borrowing and Returning");
        System.out.println("=".repeat(60));
        
        System.out.println("\n--- Testing borrowBook() ---");
        System.out.println("Book1 available before borrow: " + book1.isAvailable());
        book1.borrowBook("Alice");
        System.out.println("Book1 available after borrow: " + book1.isAvailable());
        
        book1.borrowBook("Bob"); 
        
        System.out.println("\n--- Testing getDetails() ---");
        System.out.println(book1.getDetails());
        System.out.println(book2.getDetails());
        
        System.out.println("\n--- Testing returnBook() ---");
        book1.returnBook();
        System.out.println("Book1 available after return: " + book1.isAvailable());
        
        book2.returnBook(); 
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SECTION 3: Section Display and Management");
        System.out.println("=".repeat(60));
        
        System.out.println("\n--- Fiction Section Books ---");
        fiction.displayBooks();
        
        System.out.println("\n--- Science Section Books ---");
        science.displayBooks();
        
        System.out.println("\n--- Using getBooks() method ---");
        System.out.println("Fiction section has " + fiction.getBooks().size() + " books");
        System.out.println("Science section has " + science.getBooks().size() + " books");
        
        System.out.println("\n--- Testing removeBook() ---");
        fiction.removeBook("Animal Farm");
        System.out.println("Fiction books after removal: " + fiction.getBooks().size());
        fiction.removeBook("Nonexistent Book");
        
        Library.Section emptySection = new Library.Section("Empty Section");
        System.out.println("\n--- Empty Section Display ---");
        emptySection.displayBooks();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SECTION 4: Library-Wide Search and Display");
        System.out.println("=".repeat(60));
        
        System.out.println("\n--- Testing findBook() - Book exists ---");
        lib.findBook("Cosmos");
        
        System.out.println("\n--- Testing findBook() - Book doesn't exist ---");
        lib.findBook("The Great Gatsby");
        
        System.out.println("\n--- Testing displayAllBooks() ---");
        System.out.println("=== " + lib.getName() + " - All Books ===");
        lib.displayAllBooks();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SECTION 5: Member Management System");
        System.out.println("=".repeat(60));
        
        Library.Section fantasy = new Library.Section("Fantasy");
        Library.Section.Book book6 = fantasy.new Book("Harry Potter", "J.K. Rowling");
        Library.Section.Book book7 = fantasy.new Book("Lord of the Rings", "J.R.R. Tolkien");
        Library.Section.Book book8 = fantasy.new Book("The Hobbit", "J.R.R. Tolkien");
        Library.Section.Book book9 = fantasy.new Book("Chronicles of Narnia", "C.S. Lewis");
        
        fantasy.addBook(book6);
        fantasy.addBook(book7);
        fantasy.addBook(book8);
        fantasy.addBook(book9);
        lib.addSection(fantasy);
        
        Library.Member alice = new Library.Member("Alice", 3);
        Library.Member bob = new Library.Member("Bob", 2);
        
        System.out.println("\n--- Testing canBorrow() ---");
        System.out.println("Alice can borrow: " + alice.canBorrow());
        System.out.println("Bob can borrow: " + bob.canBorrow());
        
        System.out.println("\n--- Alice borrowing books ---");
        alice.borrowBook(book6);
        alice.borrowBook(book7);
        alice.borrowBook(book8);
        
        System.out.println("\nAlice can borrow now: " + alice.canBorrow());
        
        System.out.println("\n--- Attempting to exceed borrow limit ---");
        alice.borrowBook(book9); 
        
        System.out.println("\n--- Bob trying to borrow Alice's book ---");
        bob.borrowBook(book6); 
        
        System.out.println("\n--- Testing displayBorrowedBooks() ---");
        alice.displayBorrowedBooks();
        bob.displayBorrowedBooks();
        
        System.out.println("\n--- Alice returning a book ---");
        alice.returnBook(book6);
        alice.displayBorrowedBooks();
        
        System.out.println("\nAlice can borrow now: " + alice.canBorrow());
        
        System.out.println("\n--- Alice borrowing after returning ---");
        alice.borrowBook(book9);
        alice.displayBorrowedBooks();
        
        System.out.println("\n--- Testing return error ---");
        bob.returnBook(book7); 
        
        System.out.println("\n--- Bob borrowing books ---");
        bob.borrowBook(book6);  
        bob.borrowBook(book3);  
        bob.displayBorrowedBooks();
        
        System.out.println("\nBob can borrow: " + bob.canBorrow());
        bob.borrowBook(book4);  
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("SECTION 6: Final Library State");
        System.out.println("=".repeat(60));
        
        System.out.println("\n=== Complete Library Catalog ===");
        lib.displayAllBooks();
        
        System.out.println("\n=== All Members and Their Books ===");
        alice.displayBorrowedBooks();
        bob.displayBorrowedBooks();
        
        System.out.println("=".repeat(60));
    }
}