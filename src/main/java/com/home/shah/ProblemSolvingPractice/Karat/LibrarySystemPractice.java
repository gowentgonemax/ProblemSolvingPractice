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
        void addBook(Book book) {
            books.put(book.bookId, book);
        }

        // 2. Add a new member to the library
        void addMember(Member member) {
            members.put(member.memberId, member);
        }

        // 3. Borrow a book (14-day loan period)
        boolean borrowBook(int memberId, int bookId) {
            if (!members.containsKey(memberId) || !books.containsKey(bookId)) {
                return false;
            }
            Book book = books.get(bookId);
            if (book.availableCopies <= 0) {
                return false;
            }
            book.availableCopies--;
            LocalDate borrowDate = LocalDate.now();
            LocalDate dueDate = borrowDate.plusDays(14);
            BorrowRecord record = new BorrowRecord(nextRecordId++, memberId, bookId, borrowDate, dueDate);
            borrowRecords.add(record);
            return true;
        }

        // 4. Return a book
        boolean returnBook(int recordId) {
            for (BorrowRecord record : borrowRecords) {
                if (record.recordId == recordId && record.returnDate == null) {
                    record.returnDate = LocalDate.now();
                    record.status = record.returnDate.isAfter(record.dueDate)
                        ? BorrowStatus.OVERDUE
                        : BorrowStatus.RETURNED;
                    Book book = books.get(record.bookId);
                    book.availableCopies++;
                    return true;
                }
            }
            return false;
        }

        // 5. Get all available books
        List<String> getAvailableBooks() {
            return books.values().stream()
                    .filter(b -> b.availableCopies > 0)
                    .map(b -> b.title + " by " + b.author + " (" + b.availableCopies + " available)")
                    .sorted()
                    .collect(Collectors.toList());
        }

        // 6. Get borrow history for a specific member
        List<BorrowRecord> getMemberBorrowHistory(int memberId) {
            return borrowRecords.stream()
                    .filter(r -> r.memberId == memberId)
                    .collect(Collectors.toList());
        }

        // 7. Get currently overdue items (dueDate < today and not returned)
        List<Map<String, Object>> getOverdueBooks() {
            LocalDate today = LocalDate.now();
            return borrowRecords.stream()
                    .filter(r -> r.returnDate == null && r.dueDate.isBefore(today))
                    .map(r -> {
                        Map<String, Object> item = new HashMap<>();
                        item.put("memberName", members.get(r.memberId).name);
                        item.put("bookTitle", books.get(r.bookId).title);
                        item.put("daysOverdue", ChronoUnit.DAYS.between(r.dueDate, today));
                        return item;
                    })
                    .sorted(Comparator.comparingLong((Map<String, Object> m) -> (Long) m.get("daysOverdue")).reversed())
                    .collect(Collectors.toList());
        }

        // 8. Get top borrowers (sorted by number of books borrowed)
        List<String> getTopBorrowers() {
            return borrowRecords.stream()
                    .collect(Collectors.groupingBy(r -> r.memberId, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .map(e -> members.get(e.getKey()).name + " (" + e.getValue() + " borrows)")
                    .collect(Collectors.toList());
        }

        // 9. Get statistics for a specific book (times borrowed, current availability, avg loan time)
        Map<String, Object> getBookStats(int bookId) {
            if (!books.containsKey(bookId)) {
                return new HashMap<>();
            }
            Book book = books.get(bookId);
            List<BorrowRecord> bookRecords = borrowRecords.stream()
                    .filter(r -> r.bookId == bookId)
                    .collect(Collectors.toList());

            long totalBorrows = bookRecords.size();
            double avgLoanDays = bookRecords.stream()
                    .filter(r -> r.returnDate != null)
                    .mapToLong(r -> ChronoUnit.DAYS.between(r.borrowDate, r.returnDate))
                    .average()
                    .orElse(0);

            Map<String, Object> stats = new HashMap<>();
            stats.put("title", book.title);
            stats.put("totalBorrows", totalBorrows);
            stats.put("availableCopies", book.availableCopies);
            stats.put("totalCopies", book.totalCopies);
            stats.put("avgLoanDays", String.format("%.2f", avgLoanDays));
            return stats;
        }

        // 10. Get member statistics: total books borrowed, currently checked out, overdue count
        Map<String, Object> getMemberStats(int memberId) {
            if (!members.containsKey(memberId)) {
                return new HashMap<>();
            }
            Member member = members.get(memberId);
            List<BorrowRecord> memberRecords = borrowRecords.stream()
                    .filter(r -> r.memberId == memberId)
                    .collect(Collectors.toList());

            long totalBorrowed = memberRecords.size();
            long currentlyCheckedOut = memberRecords.stream()
                    .filter(r -> r.returnDate == null)
                    .count();
            long overdueCount = memberRecords.stream()
                    .filter(r -> r.returnDate == null && r.dueDate.isBefore(LocalDate.now()))
                    .count();

            Map<String, Object> stats = new HashMap<>();
            stats.put("memberName", member.name);
            stats.put("memberId", memberId);
            stats.put("totalBorrowed", totalBorrowed);
            stats.put("currentlyCheckedOut", currentlyCheckedOut);
            stats.put("overdueCount", overdueCount);
            return stats;
        }

        // 11. Get most popular books (sorted by borrow count)
        List<String> getMostPopularBooks() {
            return borrowRecords.stream()
                    .collect(Collectors.groupingBy(r -> r.bookId, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                    .map(e -> books.get(e.getKey()).title + " (" + e.getValue() + " times)")
                    .collect(Collectors.toList());
        }

        // 12. Search books by author
        List<String> searchByAuthor(String author) {
            return books.values().stream()
                    .filter(b -> b.author.equalsIgnoreCase(author))
                    .map(b -> b.title + " - " + b.availableCopies + "/" + b.totalCopies + " available")
                    .sorted()
                    .collect(Collectors.toList());
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


