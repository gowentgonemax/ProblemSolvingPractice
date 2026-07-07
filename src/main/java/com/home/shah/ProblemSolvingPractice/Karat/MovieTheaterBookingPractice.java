package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class MovieTheaterBookingPractice {

    // ==================== ENUMS ====================
    enum SeatStatus {
        AVAILABLE, BOOKED, BLOCKED
    }

    enum MovieGenre {
        ACTION, COMEDY, DRAMA, HORROR, SCI_FI, ROMANCE
    }

    // ==================== ENTITY CLASSES ====================
    static class Movie {
        int movieId;
        String title;
        MovieGenre genre;
        int duration; // minutes
        double rating; // 0-10

        Movie(int movieId, String title, MovieGenre genre, int duration, double rating) {
            this.movieId = movieId;
            this.title = title;
            this.genre = genre;
            this.duration = duration;
            this.rating = rating;
        }
    }

    static class ShowTime {
        int showTimeId;
        int movieId;
        LocalDate showDate;
        LocalTime startTime;
        int capacity;
        int booked;

        ShowTime(int showTimeId, int movieId, LocalDate showDate, LocalTime startTime, int capacity) {
            this.showTimeId = showTimeId;
            this.movieId = movieId;
            this.showDate = showDate;
            this.startTime = startTime;
            this.capacity = capacity;
            this.booked = 0;
        }
    }

    static class Booking {
        int bookingId;
        int customerId;
        int showTimeId;
        List<String> seatNumbers; // e.g., ["A1", "A2"]
        double totalPrice;
        LocalDate bookingDate;

        Booking(int bookingId, int customerId, int showTimeId, List<String> seatNumbers, double totalPrice) {
            this.bookingId = bookingId;
            this.customerId = customerId;
            this.showTimeId = showTimeId;
            this.seatNumbers = new ArrayList<>(seatNumbers);
            this.totalPrice = totalPrice;
            this.bookingDate = LocalDate.now();
        }
    }

    // ==================== MANAGER CLASS ====================
    static class MovieTheaterManager {
        Map<Integer, Movie> movies = new HashMap<>();
        Map<Integer, ShowTime> showTimes = new HashMap<>();
        Map<Integer, Booking> bookings = new HashMap<>();
        Map<Integer, Map<String, SeatStatus>> theaterSeats = new HashMap<>(); // showTimeId -> seats
        int nextBookingId = 5000;

        // 1. Add a movie to the system
        // TODO: Store the movie in the 'movies' map using movieId as key.
        void addMovie(Movie movie) {
            // TODO: implement
        }

        // 2. Create a show time for a movie
        // TODO: Validate that movieId exists.
        //       Store ShowTime in 'showTimes' map.
        //       Initialize seat layout (rows A-H, seats 1-10) as AVAILABLE.
        //       Store in 'theaterSeats' map with showTimeId as key.
        boolean createShowTime(ShowTime showTime) {
            // TODO: implement
            return false;
        }

        // 3. Book seats for a show
        // TODO: Validate showTimeId exists and seats are available.
        //       Check if all requested seats are AVAILABLE (not BOOKED/BLOCKED).
        //       Calculate totalPrice = seatNumbers.size() * 10.
        //       Create Booking, mark seats as BOOKED, increment booked count.
        //       Return bookingId on success, -1 on failure.
        int bookSeats(int customerId, int showTimeId, List<String> seatNumbers) {
            // TODO: implement
            return -1;
        }

        // 4. Cancel a booking and free up seats
        // TODO: Find booking by bookingId.
        //       Mark all seats in the booking as AVAILABLE.
        //       Remove booking from map.
        //       Decrement booked count for the ShowTime.
        //       Return true if successful, false if booking not found.
        boolean cancelBooking(int bookingId) {
            // TODO: implement
            return false;
        }

        // 5. Get available seats for a show
        // TODO: Return list of all AVAILABLE seat numbers for a given showTimeId.
        //       Format as sorted list (e.g., ["A1", "A2", ...]).
        List<String> getAvailableSeats(int showTimeId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 6. Get occupancy rate for a show (percentage of booked seats)
        // TODO: Calculate booked seats / total capacity * 100.
        //       Return as a double (e.g., 75.5 for 75.5%).
        //       Return -1.0 if showTimeId not found.
        double getOccupancyRate(int showTimeId) {
            // TODO: implement
            return -1.0;
        }

        // 7. Get all shows for a movie on a specific date
        // TODO: Filter showTimes by movieId and showDate.
        //       Format each as: "HH:MM - capacity (occupied/capacity)".
        //       Sort by startTime ascending.
        //       Return as List<String>.
        List<String> getMovieShowsByDate(int movieId, LocalDate date) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 8. Get booking history for a customer
        // TODO: Filter bookings by customerId.
        //       For each booking, include movie title, seat numbers, price, date.
        //       Return as List<String>.
        List<String> getCustomerBookingHistory(int customerId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get most booked movies (sorted by number of bookings)
        // TODO: Group bookings by movieId and count.
        //       Sort by count descending.
        //       Format each as: "title (genre) - n bookings".
        //       Return as List<String>.
        List<String> getMostBookedMovies() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 10. Get revenue report by movie
        // TODO: For each movie, sum totalPrice from all bookings for its shows.
        //       Return Map<String (movieTitle), Double (revenue)>.
        Map<String, Double> getRevenueByMovie() {
            // TODO: implement
            return new HashMap<>();
        }

        // 11. Find available shows for a given date and genre
        // TODO: Filter shows on a specific date for movies of a given genre.
        //       Only include shows with at least 1 available seat.
        //       Format as: "title (rating) at HH:MM - n seats available".
        //       Sort by startTime.
        List<String> findShowsByGenreAndDate(MovieGenre genre, LocalDate date) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 12. Get seat layout visualization for a show
        // TODO: Return the current seat grid as a visual string (rows A-H, cols 1-10).
        //       Use 'X' for booked, '.' for available, '#' for blocked.
        //       Return as a formatted multi-line string.
        String getSeatLayout(int showTimeId) {
            // TODO: implement
            return "";
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        MovieTheaterManager theater = new MovieTheaterManager();

        // --- Setup movies ---
        theater.addMovie(new Movie(101, "Avatar", MovieGenre.SCI_FI, 162, 8.0));
        theater.addMovie(new Movie(102, "The Conjuring", MovieGenre.HORROR, 112, 7.5));
        theater.addMovie(new Movie(103, "Inception", MovieGenre.SCI_FI, 148, 8.8));

        // --- Create shows ---
        LocalDate today = LocalDate.now();
        theater.createShowTime(new ShowTime(1001, 101, today, LocalTime.of(18, 0), 80));
        theater.createShowTime(new ShowTime(1002, 101, today, LocalTime.of(21, 0), 80));
        theater.createShowTime(new ShowTime(1003, 102, today, LocalTime.of(19, 30), 80));

        // --- Test 1: Book seats ---
        System.out.println("=== Test 1: Book Seats ===");
        int booking1 = theater.bookSeats(201, 1001, Arrays.asList("A1", "A2", "A3"));
        System.out.println("Customer 201 books 3 seats (expect bookingId): " + booking1);

        // --- Test 2: Get available seats ---
        System.out.println("\n=== Test 2: Available Seats ===");
        List<String> available = theater.getAvailableSeats(1001);
        System.out.println("Available seats count (expect 77): " + available.size());

        // --- Test 3: Get occupancy rate ---
        System.out.println("\n=== Test 3: Occupancy Rate ===");
        double occupancy = theater.getOccupancyRate(1001);
        System.out.println("Occupancy rate (expect 3.75%): " + occupancy);

        // --- Test 4: Get shows by date ---
        System.out.println("\n=== Test 4: Shows by Date ===");
        List<String> shows = theater.getMovieShowsByDate(101, today);
        for (String show : shows) {
            System.out.println("  " + show);
        }

        // --- Test 5: Cancel booking ---
        System.out.println("\n=== Test 5: Cancel Booking ===");
        System.out.println("Cancel booking (expect true): " + theater.cancelBooking(booking1));
        System.out.println("Available after cancel (expect 80): " + theater.getAvailableSeats(1001).size());

        // --- Test 6: Most booked movies ---
        System.out.println("\n=== Test 6: Most Booked Movies ===");
        theater.bookSeats(202, 1001, Arrays.asList("B1"));
        theater.bookSeats(203, 1001, Arrays.asList("B2"));
        theater.bookSeats(204, 1002, Arrays.asList("C1"));
        List<String> mostBooked = theater.getMostBookedMovies();
        for (String movie : mostBooked) {
            System.out.println("  " + movie);
        }

        // --- Test 7: Revenue report ---
        System.out.println("\n=== Test 7: Revenue Report ===");
        Map<String, Double> revenue = theater.getRevenueByMovie();
        for (Map.Entry<String, Double> entry : revenue.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
        }
    }
}

