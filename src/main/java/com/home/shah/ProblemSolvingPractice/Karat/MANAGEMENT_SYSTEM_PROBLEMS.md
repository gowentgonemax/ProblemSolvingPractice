# Management System Practice Problems

This collection contains 6 comprehensive system design and implementation practice problems, all structured similarly to the `GameManagerPractice` pattern. Each problem provides:
- **Entity classes** with realistic data structures
- **Manager class** with 12-14 TODO methods to implement
- **Detailed TODO comments** explaining each method's requirements
- **Comprehensive test cases** to validate your implementation

---

## 1. LibrarySystemPractice

**File:** `LibrarySystemPractice.java`

**Problem:** Implement a library management system to track books, members, and borrowing records.

**Key Entities:**
- `Book` — title, author, ISBN, copies available
- `Member` — patron information with membership date
- `BorrowRecord` — borrowing history with due dates and return status

**Methods to Implement:** 12
1. Add book to library
2. Add member to library
3. Borrow a book (14-day loan)
4. Return a book (with overdue tracking)
5. Get available books
6. Get member borrow history
7. Get overdue items (sorted by days overdue)
8. Get top borrowers (by borrow count)
9. Get book statistics (times borrowed, avg loan duration)
10. Get member statistics (total borrowed, checked out, overdue)
11. Get most popular books
12. Search books by author

**Key Concepts:**
- Date/time handling (LocalDate)
- Filtering and sorting collections
- Grouping and counting operations
- Status tracking and analytics

---

## 2. MovieTheaterBookingPractice

**File:** `MovieTheaterBookingPractice.java`

**Problem:** Implement a movie theater booking system with seat management and revenue tracking.

**Key Entities:**
- `Movie` — title, genre, duration, rating
- `ShowTime` — movie + date/time + capacity
- `Booking` — customer seats + total price

**Methods to Implement:** 12
1. Add movie to system
2. Create show time (with seat layout initialization)
3. Book seats (with availability checking)
4. Cancel booking (free up seats)
5. Get available seats for a show
6. Get occupancy rate (percentage)
7. Get all shows for a movie on a date
8. Get customer booking history
9. Get most booked movies
10. Get revenue report by movie
11. Find shows by genre and date
12. Get seat layout visualization (grid format)

**Key Concepts:**
- 2D seat grid management
- Occupancy calculations
- Nested data structures (Map of Maps)
- Date/time filtering
- Revenue aggregation

---

## 3. HotelReservationPractice

**File:** `HotelReservationPractice.java`

**Problem:** Implement a hotel reservation system with room management and occupancy tracking.

**Key Entities:**
- `Room` — room type, price per night, capacity, floor
- `Guest` — patron information
- `Reservation` — guest + room + dates + status

**Methods to Implement:** 12
1. Add room to hotel
2. Register guest
3. Make reservation (with date range checking)
4. Cancel reservation
5. Check in guest
6. Check out guest
7. Get available rooms for date range
8. Get reservation history for guest
9. Get occupancy rate for specific date
10. Get revenue by room type
11. Get top guests (loyalty ranking)
12. Get rooms pending cleaning (checked out today)

**Key Concepts:**
- Date range overlapping checks
- Status transitions (CONFIRMED → CHECKED_IN → CHECKED_OUT)
- Occupancy percentage calculations
- Revenue grouping by type
- Loyalty metrics

---

## 4. RestaurantReservationPractice

**File:** `RestaurantReservationPractice.java`

**Problem:** Implement a restaurant reservation system with table management and peak-time analytics.

**Key Entities:**
- `Table` — capacity, location, dining area
- `Customer` — patron with visit tracking
- `Reservation` — table + date + time + party size + status

**Methods to Implement:** 13
1. Add table to restaurant
2. Register customer
3. Make reservation (best-fit table selection)
4. Seat customer (mark SEATED, track visits)
5. Complete reservation
6. Cancel reservation
7. Mark no-show
8. Get available tables
9. Get customer reservation history
10. Get top customers (most visits)
11. Get reservation status counts by date
12. Get peak reservation times (busiest hours)
13. Get table utilization report

**Key Concepts:**
- Best-fit algorithm (smallest table that fits party)
- Time slot analysis
- Customer loyalty tracking
- Status state machine
- Utilization metrics

---

## 5. GymMembershipPractice

**File:** `GymMembershipPractice.java`

**Problem:** Implement a gym membership system with attendance tracking and member analytics.

**Key Entities:**
- `Member` — membership tier, expiration date, status
- `Equipment` — gym equipment with availability
- `AttendanceRecord` — check-in/check-out records

**Methods to Implement:** 13
1. Add member (with status validation)
2. Add equipment
3. Check in member
4. Check out member
5. Renew membership
6. Suspend membership
7. Get active members
8. Get member attendance records
9. Get member attendance statistics
10. Get current occupancy (checked-in today)
11. Get expiring memberships (within 7 days)
12. Get most active members this month
13. Get equipment availability

**Key Concepts:**
- Membership status management
- Check-in/check-out pairing
- Session duration calculations (minutes)
- Current month filtering
- Occupancy counting
- Expiration date checks

---

## 6. OnlineStoreInventoryPractice

**File:** `OnlineStoreInventoryPractice.java`

**Problem:** Implement an online store inventory system with order management and revenue tracking.

**Key Entities:**
- `Product` — category, price, quantity in stock
- `Customer` — purchasing history and total spent
- `Order` — items purchased, status, total amount

**Methods to Implement:** 14
1. Add product to inventory
2. Register customer
3. Place order (inventory validation)
4. Cancel order (restore inventory)
5. Update order status (with spent tracking)
6. Get products in stock
7. Get low stock products (< 10)
8. Get out of stock products
9. Get customer order history
10. Get best-selling products (quantity sold)
11. Get revenue by category
12. Get top customers (by total spent)
13. Get inventory value (price × quantity)
14. Get pending orders

**Key Concepts:**
- Inventory management (decrement/increment)
- Status transitions (PENDING → DELIVERED)
- Revenue aggregation by category
- Stock level tracking
- Order validation
- Customer spending tracking

---

## How to Use These Problems

### For Each Problem:
1. **Read the entity classes** to understand the data model
2. **Read the TODO comments** carefully — they explain what each method should do
3. **Study the test cases** in `main()` to understand expected behavior
4. **Implement each TODO method** following the specifications
5. **Run the test cases** to validate your implementation
6. **Verify the output** matches expected results

### Implementation Tips:
- Use Java Streams API for filtering, sorting, and grouping
- Handle edge cases (null checks, empty lists, invalid IDs)
- Pay attention to the date/time requirements
- Follow the format strings in TODO comments
- Think about the most efficient way to group/aggregate data

### Difficulty Progression:
1. **LibrarySystemPractice** — Basic crud + simple analytics (start here)
2. **MovieTheaterBookingPractice** — Seat management + occupancy (medium)
3. **HotelReservationPractice** — Date range logic + status tracking (medium)
4. **RestaurantReservationPractice** — Best-fit algorithm + time analysis (medium-hard)
5. **GymMembershipPractice** — Attendance pairing + date filtering (hard)
6. **OnlineStoreInventoryPractice** — Complex inventory + multi-entity aggregation (hard)

---

## Key Patterns Used

All problems follow this architecture:

```
Enums (status, category, type)
    ↓
Entity Classes (Book, Member, etc.)
    ↓
Manager Class with Maps/Lists
    ↓
CRUD Methods (add, remove, update, retrieve)
    ↓
Analytics Methods (grouping, aggregation, sorting)
    ↓
Test Cases (main method with examples)
```

---

## Common Data Structures

- **HashMap<Integer, T>** — Store entities by ID
- **ArrayList<T>** — Store records/transactions
- **Map<K, Long>** — Count occurrences for grouping
- **LocalDate, LocalTime, LocalDateTime** — Date/time handling
- **Collectors.groupingBy()** — Group entities
- **stream().filter().sorted().collect()** — Query patterns

---

## Learning Outcomes

After implementing these problems, you'll be proficient with:
✅ Designing real-world data models  
✅ Using Java Collections Framework effectively  
✅ Stream API for data filtering and aggregation  
✅ Date/time handling in Java  
✅ Business logic implementation  
✅ System design patterns  
✅ Writing maintainable, scalable code  

---

**Good luck! Happy coding!** 🚀

