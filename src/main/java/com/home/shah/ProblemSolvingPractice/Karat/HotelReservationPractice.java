package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class HotelReservationPractice {

    // ==================== ENUMS ====================
    enum RoomType {
        SINGLE, DOUBLE, SUITE, DELUXE
    }

    enum ReservationStatus {
        CONFIRMED, CHECKED_IN, CHECKED_OUT, CANCELLED
    }

    // ==================== ENTITY CLASSES ====================
    static class Room {
        int roomId;
        RoomType roomType;
        double pricePerNight;
        String floor;
        int capacity;

        Room(int roomId, RoomType roomType, double pricePerNight, String floor, int capacity) {
            this.roomId = roomId;
            this.roomType = roomType;
            this.pricePerNight = pricePerNight;
            this.floor = floor;
            this.capacity = capacity;
        }
    }

    static class Guest {
        int guestId;
        String name;
        String email;
        String phone;

        Guest(int guestId, String name, String email, String phone) {
            this.guestId = guestId;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }
    }

    static class Reservation {
        int reservationId;
        int guestId;
        int roomId;
        LocalDate checkInDate;
        LocalDate checkOutDate;
        ReservationStatus status;
        double totalPrice;

        Reservation(int reservationId, int guestId, int roomId, LocalDate checkInDate, LocalDate checkOutDate) {
            this.reservationId = reservationId;
            this.guestId = guestId;
            this.roomId = roomId;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.status = ReservationStatus.CONFIRMED;
            this.totalPrice = 0;
        }
    }

    // ==================== MANAGER CLASS ====================
    static class HotelManager {
        Map<Integer, Room> rooms = new HashMap<>();
        Map<Integer, Guest> guests = new HashMap<>();
        List<Reservation> reservations = new ArrayList<>();
        int nextReservationId = 3000;

        // 1. Add a room to the hotel
        // TODO: Store the room in the 'rooms' map using roomId as key.
        void addRoom(Room room) {
            // TODO: implement
        }

        // 2. Register a guest
        // TODO: Store the guest in the 'guests' map using guestId as key.
        void addGuest(Guest guest) {
            // TODO: implement
        }

        // 3. Make a reservation
        // TODO: Validate guestId and roomId exist.
        //       Check if room is available for the date range (checkInDate to checkOutDate).
        //       Calculate totalPrice = (checkOutDate - checkInDate) * pricePerNight.
        //       Create Reservation, add to list.
        //       Return reservationId on success, -1 if room unavailable or invalid input.
        int makeReservation(int guestId, int roomId, LocalDate checkInDate, LocalDate checkOutDate) {
            // TODO: implement
            return -1;
        }

        // 4. Cancel a reservation
        // TODO: Find reservation by reservationId and set status to CANCELLED.
        //       Return true if successful, false if not found or already cancelled.
        boolean cancelReservation(int reservationId) {
            // TODO: implement
            return false;
        }

        // 5. Check in a guest (mark reservation as CHECKED_IN)
        // TODO: Find reservation by reservationId, verify status is CONFIRMED.
        //       Change status to CHECKED_IN.
        //       Return true if successful, false otherwise.
        boolean checkInGuest(int reservationId) {
            // TODO: implement
            return false;
        }

        // 6. Check out a guest (mark reservation as CHECKED_OUT)
        // TODO: Find reservation by reservationId, verify status is CHECKED_IN.
        //       Change status to CHECKED_OUT.
        //       Return true if successful, false otherwise.
        boolean checkOutGuest(int reservationId) {
            // TODO: implement
            return false;
        }

        // 7. Get available rooms for a date range
        // TODO: Filter rooms that have no overlapping reservations in the date range.
        //       Format each as: "Room [roomId] - type (capacity guests) - $pricePerNight/night".
        //       Sort by roomId ascending.
        List<String> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 8. Get reservation history for a guest
        // TODO: Filter reservations by guestId.
        //       Format each as: "Reservation [id] - Room [roomId] - [checkInDate] to [checkOutDate] - $totalPrice".
        //       Sort by checkInDate descending (most recent first).
        List<String> getGuestReservations(int guestId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get occupancy rate for a specific date
        // TODO: For a given date, count how many rooms are occupied (have active reservations).
        //       Return occupancy percentage (occupied / total rooms * 100).
        //       Return -1.0 if no rooms exist.
        double getOccupancyRateForDate(LocalDate date) {
            // TODO: implement
            return -1.0;
        }

        // 10. Get revenue report by room type
        // TODO: Group all completed reservations by RoomType.
        //       Sum totalPrice for each room type.
        //       Return Map<RoomType, Double> with total revenue per type.
        Map<RoomType, Double> getRevenueByRoomType() {
            // TODO: implement
            return new HashMap<>();
        }

        // 11. Get guests with most reservations (loyalty ranking)
        // TODO: Group reservations by guestId and count.
        //       Sort by count descending.
        //       Format as: "guestName - n reservations".
        //       Return as List<String>.
        List<String> getTopGuests() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 12. Get rooms that need cleaning (checked-out today)
        // TODO: Find all reservations with status CHECKED_OUT and checkOutDate = today.
        //       For each, list the room.
        //       Format as: "Room [roomId] - type".
        //       Return as List<String>.
        List<String> getRoomsPendingCleaning() {
            // TODO: implement
            return new ArrayList<>();
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        HotelManager hotel = new HotelManager();

        // --- Setup rooms ---
        hotel.addRoom(new Room(101, RoomType.SINGLE, 80.0, "1", 1));
        hotel.addRoom(new Room(102, RoomType.DOUBLE, 120.0, "1", 2));
        hotel.addRoom(new Room(103, RoomType.SUITE, 200.0, "2", 4));
        hotel.addRoom(new Room(104, RoomType.DELUXE, 250.0, "3", 4));

        // --- Setup guests ---
        hotel.addGuest(new Guest(501, "John Doe", "john@example.com", "555-1234"));
        hotel.addGuest(new Guest(502, "Jane Smith", "jane@example.com", "555-5678"));
        hotel.addGuest(new Guest(503, "Bob Johnson", "bob@example.com", "555-9999"));

        // --- Test 1: Make reservations ---
        System.out.println("=== Test 1: Make Reservations ===");
        LocalDate today = LocalDate.now();
        int res1 = hotel.makeReservation(501, 101, today.plusDays(1), today.plusDays(4));
        System.out.println("Reservation 1 (expect valid ID): " + res1);

        int res2 = hotel.makeReservation(502, 102, today.plusDays(2), today.plusDays(6));
        System.out.println("Reservation 2 (expect valid ID): " + res2);

        int res3 = hotel.makeReservation(503, 103, today.plusDays(5), today.plusDays(8));
        System.out.println("Reservation 3 (expect valid ID): " + res3);

        // --- Test 2: Get available rooms ---
        System.out.println("\n=== Test 2: Available Rooms ===");
        List<String> available = hotel.getAvailableRooms(today.plusDays(1), today.plusDays(2));
        System.out.println("Available rooms (expect 3): " + available.size());
        for (String room : available) {
            System.out.println("  " + room);
        }

        // --- Test 3: Check in/out ---
        System.out.println("\n=== Test 3: Check In/Out ===");
        System.out.println("Check in reservation (expect true): " + hotel.checkInGuest(res1));
        System.out.println("Check out reservation (expect true): " + hotel.checkOutGuest(res1));

        // --- Test 4: Get guest reservations ---
        System.out.println("\n=== Test 4: Guest Reservations ===");
        List<String> guestRes = hotel.getGuestReservations(501);
        for (String res : guestRes) {
            System.out.println("  " + res);
        }

        // --- Test 5: Occupancy rate ---
        System.out.println("\n=== Test 5: Occupancy Rate ===");
        double occupancy = hotel.getOccupancyRateForDate(today.plusDays(2));
        System.out.println("Occupancy on day 2 (expect 50%): " + occupancy);

        // --- Test 6: Top guests ---
        System.out.println("\n=== Test 6: Top Guests ===");
        hotel.makeReservation(501, 102, today.plusDays(10), today.plusDays(12));
        List<String> topGuests = hotel.getTopGuests();
        for (String guest : topGuests) {
            System.out.println("  " + guest);
        }

        // --- Test 7: Cancel reservation ---
        System.out.println("\n=== Test 7: Cancel Reservation ===");
        System.out.println("Cancel reservation (expect true): " + hotel.cancelReservation(res2));
    }
}

