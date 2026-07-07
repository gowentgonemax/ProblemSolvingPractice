package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class RestaurantReservationPractice {

    // ==================== ENUMS ====================
    enum DiningArea {
        INDOOR, PATIO, BAR, PRIVATE_ROOM
    }

    enum ReservationStatus {
        CONFIRMED, SEATED, COMPLETED, CANCELLED, NO_SHOW
    }

    // ==================== ENTITY CLASSES ====================
    static class Table {
        int tableId;
        DiningArea area;
        int capacity;
        String location; // "Window", "Corner", etc.

        Table(int tableId, DiningArea area, int capacity, String location) {
            this.tableId = tableId;
            this.area = area;
            this.capacity = capacity;
            this.location = location;
        }
    }

    static class Customer {
        int customerId;
        String name;
        String phone;
        String email;
        int visitCount;

        Customer(int customerId, String name, String phone, String email) {
            this.customerId = customerId;
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.visitCount = 0;
        }
    }

    static class Reservation {
        int reservationId;
        int customerId;
        int tableId;
        LocalDate date;
        LocalTime time;
        int partySize;
        ReservationStatus status;
        LocalTime actualArrivalTime; // null if not yet seated

        Reservation(int reservationId, int customerId, int tableId, LocalDate date, LocalTime time, int partySize) {
            this.reservationId = reservationId;
            this.customerId = customerId;
            this.tableId = tableId;
            this.date = date;
            this.time = time;
            this.partySize = partySize;
            this.status = ReservationStatus.CONFIRMED;
            this.actualArrivalTime = null;
        }
    }

    // ==================== MANAGER CLASS ====================
    static class RestaurantManager {
        Map<Integer, Table> tables = new HashMap<>();
        Map<Integer, Customer> customers = new HashMap<>();
        List<Reservation> reservations = new ArrayList<>();
        int nextReservationId = 7000;

        // 1. Add a table to the restaurant
        // TODO: Store the table in the 'tables' map using tableId as key.
        void addTable(Table table) {
            // TODO: implement
        }

        // 2. Register a customer
        // TODO: Store the customer in the 'customers' map using customerId as key.
        void addCustomer(Customer customer) {
            // TODO: implement
        }

        // 3. Make a reservation
        // TODO: Validate customerId exists.
        //       Find an available table with capacity >= partySize for the date/time.
        //       Preference: find the smallest table that fits partySize.
        //       Create Reservation and add to list.
        //       Return reservationId on success, -1 if no suitable table found.
        int makeReservation(int customerId, LocalDate date, LocalTime time, int partySize) {
            // TODO: implement
            return -1;
        }

        // 4. Seat a customer (mark reservation as SEATED)
        // TODO: Find reservation by reservationId.
        //       Verify status is CONFIRMED and reservation date/time match current or past.
        //       Set status to SEATED, set actualArrivalTime to current time.
        //       Increment customer's visitCount.
        //       Return true if successful, false otherwise.
        boolean seatCustomer(int reservationId) {
            // TODO: implement
            return false;
        }

        // 5. Complete a reservation (mark as COMPLETED)
        // TODO: Find reservation by reservationId.
        //       Verify status is SEATED.
        //       Set status to COMPLETED.
        //       Return true if successful, false otherwise.
        boolean completeReservation(int reservationId) {
            // TODO: implement
            return false;
        }

        // 6. Cancel a reservation
        // TODO: Find reservation by reservationId.
        //       If status is CONFIRMED or SEATED, set to CANCELLED.
        //       Return true if successful, false if not found or already completed.
        boolean cancelReservation(int reservationId) {
            // TODO: implement
            return false;
        }

        // 7. Mark a reservation as NO_SHOW
        // TODO: Find reservation by reservationId.
        //       If status is CONFIRMED (reservation time has passed), set to NO_SHOW.
        //       Return true if successful, false otherwise.
        boolean markNoShow(int reservationId) {
            // TODO: implement
            return false;
        }

        // 8. Get available tables for a date and time
        // TODO: Filter tables not booked for the given date/time.
        //       Format each as: "Table [id] (area, capacity) - location".
        //       Sort by capacity ascending (prefer smaller tables).
        List<String> getAvailableTables(LocalDate date, LocalTime time) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get reservations for a customer
        // TODO: Filter reservations by customerId.
        //       Format each as: "[date] [time] - party of [size] - status".
        //       Sort by date descending (most recent first).
        List<String> getCustomerReservationHistory(int customerId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 10. Get top customers (most visits/reservations)
        // TODO: Sort customers by visitCount descending.
        //       Format as: "name - n visits".
        //       Return top 10 as List<String>.
        List<String> getTopCustomers() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 11. Get reservation status for a date
        // TODO: For a given date, count reservations by status.
        //       Return Map<ReservationStatus, Integer> with counts.
        Map<ReservationStatus, Integer> getReservationStatusByDate(LocalDate date) {
            // TODO: implement
            return new HashMap<>();
        }

        // 12. Get peak reservation times
        // TODO: Count reservations by time slot (e.g., 17:00, 18:00, 19:00, 20:00).
        //       Format as: "HH:MM - n reservations".
        //       Sort by count descending.
        //       Return top times as List<String>.
        List<String> getPeakReservationTimes() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 13. Get table utilization report
        // TODO: For each table, count how many completed reservations it had.
        //       Format as: "Table [id] - [count] reservations - [area]".
        //       Sort by count descending.
        List<String> getTableUtilizationReport() {
            // TODO: implement
            return new ArrayList<>();
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        RestaurantManager restaurant = new RestaurantManager();

        // --- Setup tables ---
        restaurant.addTable(new Table(101, DiningArea.INDOOR, 2, "Window"));
        restaurant.addTable(new Table(102, DiningArea.INDOOR, 4, "Corner"));
        restaurant.addTable(new Table(103, DiningArea.PATIO, 6, "Garden View"));
        restaurant.addTable(new Table(104, DiningArea.PRIVATE_ROOM, 8, "Private"));

        // --- Setup customers ---
        restaurant.addCustomer(new Customer(401, "Alice Chen", "555-1111", "alice@email.com"));
        restaurant.addCustomer(new Customer(402, "Bob Wilson", "555-2222", "bob@email.com"));
        restaurant.addCustomer(new Customer(403, "Carol Davis", "555-3333", "carol@email.com"));

        // --- Test 1: Make reservations ---
        System.out.println("=== Test 1: Make Reservations ===");
        LocalDate today = LocalDate.now();
        int res1 = restaurant.makeReservation(401, today.plusDays(1), LocalTime.of(18, 30), 2);
        System.out.println("Reservation for 2 people (expect valid ID): " + res1);

        int res2 = restaurant.makeReservation(402, today.plusDays(1), LocalTime.of(19, 0), 4);
        System.out.println("Reservation for 4 people (expect valid ID): " + res2);

        int res3 = restaurant.makeReservation(403, today.plusDays(1), LocalTime.of(20, 0), 6);
        System.out.println("Reservation for 6 people (expect valid ID): " + res3);

        // --- Test 2: Get available tables ---
        System.out.println("\n=== Test 2: Available Tables ===");
        List<String> available = restaurant.getAvailableTables(today.plusDays(2), LocalTime.of(19, 0));
        System.out.println("Available tables (expect 4):");
        for (String table : available) {
            System.out.println("  " + table);
        }

        // --- Test 3: Seat customer ---
        System.out.println("\n=== Test 3: Seat Customer ===");
        System.out.println("Seat customer (expect true): " + restaurant.seatCustomer(res1));

        // --- Test 4: Get customer history ---
        System.out.println("\n=== Test 4: Customer Reservation History ===");
        List<String> history = restaurant.getCustomerReservationHistory(401);
        for (String res : history) {
            System.out.println("  " + res);
        }

        // --- Test 5: Complete reservation ---
        System.out.println("\n=== Test 5: Complete Reservation ===");
        System.out.println("Complete reservation (expect true): " + restaurant.completeReservation(res1));

        // --- Test 6: Cancel reservation ---
        System.out.println("\n=== Test 6: Cancel Reservation ===");
        System.out.println("Cancel reservation (expect true): " + restaurant.cancelReservation(res2));

        // --- Test 7: Reservation status by date ---
        System.out.println("\n=== Test 7: Reservation Status ===");
        Map<ReservationStatus, Integer> status = restaurant.getReservationStatusByDate(today.plusDays(1));
        for (Map.Entry<ReservationStatus, Integer> entry : status.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
    }
}

