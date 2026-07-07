package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class LibrarySystemPractice {

    // ==================== ENUMS ====================
    enum BorrowStatus {
        BORROWED, RETURNED, OVERDUE
    }

    // ==================== ENTITY CLASSES ====================
    static class Book {
        int bookId;
        String title;
        String author;
        String isbn;
        int totalCopies;
        int availableCopies;

        Book(int bookId, String title, String author, String isbn, int totalCopies) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.totalCopies = totalCopies;
            this.availableCopies = totalCopies;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", available=" + availableCopies + '/' + totalCopies +
                    '}';
        }
    }

    static class Member {
        int memberId;
        String name;
        String email;
        LocalDate membershipDate;

        Member(int memberId, String name, String email) {
            this.memberId = memberId;
            this.name = name;
            this.email = email;
            this.membershipDate = LocalDate.now();
        }

        @Override
        public String toString() {
            return name + " (ID: " + memberId + ")";
        }
    }

    static class BorrowRecord {
        int recordId;
        int memberId;
        int bookId;
        LocalDate borrowDate;
        LocalDate dueDate;
        LocalDate returnDate; // null if not yet returned
        BorrowStatus status;

        BorrowRecord(int recordId, int memberId, int bookId, LocalDate borrowDate, LocalDate dueDate) {
            this.recordId = recordId;
            this.memberId = memberId;
            this.bookId = bookId;
            this.borrowDate = borrowDate;
            this.dueDate = dueDate;
            this.returnDate = null;
            this.status = BorrowStatus.BORROWED;
        }

        @Override
        public String toString() {
            return "BorrowRecord{" +
                    "memberId=" + memberId +
                    ", bookId=" + bookId +
                    ", borrowDate=" + borrowDate +
                    ", dueDate=" + dueDate +
                    ", returnDate=" + returnDate +
                    ", status=" + status +
                    '}';
        }
    }

    // ==================== MANAGER CLASS ====================
    static class LibraryManager {
        Map<Integer, Book> books = new HashMap<>();
        Map<Integer, Member> members = new HashMap<>();
        List<BorrowRecord> borrowRecords = new ArrayList<>();
        int nextRecordId = 1000;

        // 1. Add a new book to the library
        // TODO: Store the book in the 'books' map using bookId as key.
        //       Ensure the book is accessible for future borrow operations.
        void addBook(Book book) {
            // TODO: implement
        }

        // 2. Add a new member to the library
        // TODO: Store the member in the 'members' map using memberId as key.
        //       Ensure the member can be retrieved for borrow/return operations.
        void addMember(Member member) {
            // TODO: implement
        }

        // 3. Borrow a book (14-day loan period)
        // TODO: Validate that memberId and bookId exist.
        //       Check if the book has available copies.
        //       Create a new BorrowRecord with borrowDate=today, dueDate=today+14 days.
        //       Decrement availableCopies for the book.
        //       Return true if successful, false if member/book not found or no copies available.
        boolean borrowBook(int memberId, int bookId) {
            // TODO: implement
            return false;
        }

        // 4. Return a book
        // TODO: Find the BorrowRecord by recordId (ensure returnDate is null/not yet returned).
        //       Set returnDate to today.
        //       Update status: RETURNED if returnDate <= dueDate, OVERDUE if after.
        //       Increment availableCopies for the book.
        //       Return true if successful, false if record not found or already returned.
        boolean returnBook(int recordId) {
            // TODO: implement
            return false;
        }

        // 5. Get all available books
        // TODO: Filter books where availableCopies > 0.
        //       Format each as: "title by author (n available)".
        //       Sort results alphabetically by title.
        //       Return as a List<String>.
        List<String> getAvailableBooks() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 6. Get borrow history for a specific member
        // TODO: Filter borrowRecords by memberId.
        //       Return all records (both returned and currently borrowed).
        //       Order by borrowDate (optional, but may be helpful).
        List<BorrowRecord> getMemberBorrowHistory(int memberId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 7. Get currently overdue items (dueDate < today and not returned)
        // TODO: Filter borrowRecords where returnDate is null and dueDate < today.
        //       For each, create a Map with: "memberName", "bookTitle", "daysOverdue".
        //       Sort by daysOverdue in descending order (most overdue first).
        //       Return as List<Map<String, Object>>.
        List<Map<String, Object>> getOverdueBooks() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 8. Get top borrowers (sorted by number of books borrowed)
        // TODO: Group borrowRecords by memberId and count occurrences.
        //       Sort by count in descending order.
        //       Format each as: "memberName (n borrows)".
        //       Return as List<String>.
        List<String> getTopBorrowers() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get statistics for a specific book (times borrowed, current availability, avg loan time)
        // TODO: Find the book by bookId. If not found, return empty map.
        //       Count total borrow records for this book.
        //       Calculate average loan duration in days (for returned records).
        //       Return Map with keys: "title", "totalBorrows", "availableCopies",
        //                             "totalCopies", "avgLoanDays" (formatted to 2 decimals).
        Map<String, Object> getBookStats(int bookId) {
            // TODO: implement
            return new HashMap<>();
        }

        // 10. Get member statistics: total books borrowed, currently checked out, overdue count
        // TODO: Find the member by memberId. If not found, return empty map.
        //       Count total borrow records for this member.
        //       Count records where returnDate is null (currently checked out).
        //       Count records where returnDate is null AND dueDate < today (overdue).
        //       Return Map with keys: "memberName", "memberId", "totalBorrowed",
        //                             "currentlyCheckedOut", "overdueCount".
        Map<String, Object> getMemberStats(int memberId) {
            // TODO: implement
            return new HashMap<>();
        }

        // 11. Get most popular books (sorted by borrow count)
        // TODO: Group borrowRecords by bookId and count occurrences.
        //       Sort by count in descending order.
        //       Format each as: "title (n times)".
        //       Return as List<String>.
        List<String> getMostPopularBooks() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 12. Search books by author (case-insensitive)
        // TODO: Filter books by author (case-insensitive comparison).
        //       Format each as: "title - n/total available".
        //       Sort results alphabetically by title.
        //       Return as List<String>.
        List<String> searchByAuthor(String author) {
            // TODO: implement
            return new ArrayList<>();
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        // --- Setup books ---
        library.addBook(new Book(101, "To Kill a Mockingbird", "Harper Lee", "ISBN001", 3));
        library.addBook(new Book(102, "1984", "George Orwell", "ISBN002", 2));
        library.addBook(new Book(103, "Pride and Prejudice", "Jane Austen", "ISBN003", 4));
        library.addBook(new Book(104, "The Great Gatsby", "F. Scott Fitzgerald", "ISBN004", 2));
        library.addBook(new Book(105, "Jane Eyre", "Charlotte Brontë", "ISBN005", 1));

        // --- Setup members ---
        library.addMember(new Member(1, "Alice Johnson", "alice@example.com"));
        library.addMember(new Member(2, "Bob Smith", "bob@example.com"));
        library.addMember(new Member(3, "Carol White", "carol@example.com"));
        library.addMember(new Member(4, "David Brown", "david@example.com"));

        // --- Test 1: Borrow and return books ---
        System.out.println("=== Test 1: Borrow Books ===");
        System.out.println("Alice borrows To Kill a Mockingbird: " + library.borrowBook(1, 101));
        System.out.println("Alice borrows 1984: " + library.borrowBook(1, 102));
        System.out.println("Bob borrows Pride and Prejudice: " + library.borrowBook(2, 103));
        System.out.println("Bob borrows The Great Gatsby: " + library.borrowBook(2, 104));
        System.out.println("Carol borrows To Kill a Mockingbird: " + library.borrowBook(3, 101));
        System.out.println("Carol borrows Jane Eyre: " + library.borrowBook(3, 105));
        System.out.println("David borrows Pride and Prejudice: " + library.borrowBook(4, 103));
        System.out.println("David borrows 1984 (borrow again): " + library.borrowBook(4, 102));

        // --- Test 2: Get available books ---
        System.out.println("\n=== Test 2: Available Books ===");
        List<String> available = library.getAvailableBooks();
        for (String book : available) {
            System.out.println("  " + book);
        }

        // --- Test 3: Get member borrow history ---
        System.out.println("\n=== Test 3: Alice's Borrow History ===");
        for (BorrowRecord record : library.getMemberBorrowHistory(1)) {
            System.out.println("  " + record);
        }

        // --- Test 4: Return a book ---
        System.out.println("\n=== Test 4: Return Books ===");
        System.out.println("Alice returns book (record 1000): " + library.returnBook(1000));
        System.out.println("Bob returns book (record 1002): " + library.returnBook(1002));

        // --- Test 5: Get top borrowers ---
        System.out.println("\n=== Test 5: Top Borrowers ===");
        for (String borrower : library.getTopBorrowers()) {
            System.out.println("  " + borrower);
        }

        // --- Test 6: Get member statistics ---
        System.out.println("\n=== Test 6: Member Statistics ===");
        for (int i = 1; i <= 4; i++) {
            System.out.println("  " + library.getMemberStats(i));
        }

        // --- Test 7: Get book statistics ---
        System.out.println("\n=== Test 7: Book Statistics ===");
        System.out.println("  To Kill a Mockingbird: " + library.getBookStats(101));
        System.out.println("  Pride and Prejudice: " + library.getBookStats(103));

        // --- Test 8: Get most popular books ---
        System.out.println("\n=== Test 8: Most Popular Books ===");
        for (String book : library.getMostPopularBooks()) {
            System.out.println("  " + book);
        }

        // --- Test 9: Search by author ---
        System.out.println("\n=== Test 9: Search Books by Author ===");
        System.out.println("  Books by Jane Austen: " + library.searchByAuthor("Jane Austen"));
        System.out.println("  Books by Charlotte Brontë: " + library.searchByAuthor("Charlotte Brontë"));

        // --- Test 10: Simulate overdue books (modify dates for demo) ---
        System.out.println("\n=== Test 10: Overdue Books ===");
        // Manually set a record's due date to past for demonstration
        if (!library.borrowRecords.isEmpty()) {
            BorrowRecord firstRecord = library.borrowRecords.get(0);
            firstRecord.dueDate = LocalDate.now().minusDays(5);
            System.out.println("  Overdue items: " + library.getOverdueBooks());
        }

        // --- Edge case: Try to borrow unavailable book ---
        System.out.println("\n=== Edge Case: Borrow Unavailable Book ===");
        System.out.println("All 2 copies of The Great Gatsby are out.");
        System.out.println("Try to borrow 3rd copy: " + library.borrowBook(1, 104));
    }
}



