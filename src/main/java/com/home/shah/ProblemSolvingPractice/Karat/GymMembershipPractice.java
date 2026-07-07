package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class GymMembershipPractice {

    // ==================== ENUMS ====================
    enum MembershipTier {
        BASIC, PREMIUM, ELITE
    }

    enum MembershipStatus {
        ACTIVE, EXPIRED, SUSPENDED, CANCELLED
    }

    enum AttendanceStatus {
        CHECK_IN, CHECK_OUT
    }

    // ==================== ENTITY CLASSES ====================
    static class Member {
        int memberId;
        String name;
        String email;
        MembershipTier tier;
        MembershipStatus status;
        LocalDate joinDate;
        LocalDate renewalDate; // expiration date

        Member(int memberId, String name, String email, MembershipTier tier, int membershipMonths) {
            this.memberId = memberId;
            this.name = name;
            this.email = email;
            this.tier = tier;
            this.status = MembershipStatus.ACTIVE;
            this.joinDate = LocalDate.now();
            this.renewalDate = joinDate.plusMonths(membershipMonths);
        }
    }

    static class Equipment {
        int equipmentId;
        String name;
        String type; // "Cardio", "Strength", "Flexibility"
        int quantity;
        int availableCount;

        Equipment(int equipmentId, String name, String type, int quantity) {
            this.equipmentId = equipmentId;
            this.name = name;
            this.type = type;
            this.quantity = quantity;
            this.availableCount = quantity;
        }
    }

    static class AttendanceRecord {
        int recordId;
        int memberId;
        LocalDate date;
        AttendanceStatus status; // CHECK_IN or CHECK_OUT
        String timeIn; // HH:MM format, null if CHECK_OUT only

        AttendanceRecord(int recordId, int memberId, LocalDate date, AttendanceStatus status, String timeIn) {
            this.recordId = recordId;
            this.memberId = memberId;
            this.date = date;
            this.status = status;
            this.timeIn = timeIn;
        }
    }

    // ==================== MANAGER CLASS ====================
    static class GymManager {
        Map<Integer, Member> members = new HashMap<>();
        Map<Integer, Equipment> equipment = new HashMap<>();
        List<AttendanceRecord> attendanceRecords = new ArrayList<>();
        int nextRecordId = 9000;

        // 1. Add a new member
        // TODO: Validate memberId is unique.
        //       Check status and set to EXPIRED if renewalDate < today.
        //       Store in 'members' map.
        boolean addMember(Member member) {
            // TODO: implement
            return false;
        }

        // 2. Add equipment to the gym
        // TODO: Store equipment in the 'equipment' map using equipmentId as key.
        void addEquipment(Equipment eq) {
            // TODO: implement
        }

        // 3. Check in a member
        // TODO: Validate memberId exists and status is ACTIVE.
        //       Create AttendanceRecord with status CHECK_IN and current time.
        //       Return true if successful, false if member not found or inactive.
        boolean checkInMember(int memberId) {
            // TODO: implement
            return false;
        }

        // 4. Check out a member
        // TODO: Find the most recent CHECK_IN record for memberId today.
        //       Create a new CHECK_OUT record.
        //       Return true if successful, false if no active check-in found.
        boolean checkOutMember(int memberId) {
            // TODO: implement
            return false;
        }

        // 5. Renew membership
        // TODO: Find member by memberId.
        //       Extend renewalDate by 1 month (or specified months).
        //       Set status to ACTIVE.
        //       Return true if successful, false if member not found.
        boolean renewMembership(int memberId, int months) {
            // TODO: implement
            return false;
        }

        // 6. Suspend membership
        // TODO: Find member by memberId and set status to SUSPENDED.
        //       Return true if successful, false if not found.
        boolean suspendMembership(int memberId) {
            // TODO: implement
            return false;
        }

        // 7. Get active members
        // TODO: Filter members with status ACTIVE and renewalDate >= today.
        //       Format as: "name (tier) - expires [date]".
        //       Sort by tier (ELITE, PREMIUM, BASIC) and name.
        List<String> getActiveMembers() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 8. Get attendance for a member
        // TODO: Filter AttendanceRecords by memberId.
        //       Format as: "[date] [CHECK_IN/CHECK_OUT] [time]".
        //       Sort by date descending (most recent first).
        List<String> getMemberAttendance(int memberId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get attendance statistics for a member
        // TODO: For a given memberId, count total check-ins this month (using current date).
        //       Calculate average session duration (in minutes) by matching CHECK_IN/CHECK_OUT pairs.
        //       Return Map with keys: "memberId", "checkInsThisMonth", "avgSessionMinutes".
        Map<String, Object> getMemberAttendanceStats(int memberId) {
            // TODO: implement
            return new HashMap<>();
        }

        // 10. Get gym occupancy (currently checked in members)
        // TODO: For today, count members who have CHECK_IN but no CHECK_OUT.
        //       Return the count as an integer.
        int getCurrentOccupancy() {
            // TODO: implement
            return 0;
        }

        // 11. Get expiring memberships (renewal needed soon)
        // TODO: Filter members with status ACTIVE and renewalDate between today and today+7 days.
        //       Format as: "name - expires [date] - tier".
        //       Sort by renewalDate ascending.
        List<String> getExpiringMemberships() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 12. Get member activity ranking (most active members this month)
        // TODO: For each active member, count check-ins in current month.
        //       Sort by count descending.
        //       Format as: "name - n visits".
        //       Return top 10 as List<String>.
        List<String> getMostActiveMembersThisMonth() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 13. Get equipment usage statistics
        // TODO: For a given date, count how many times each equipment was used.
        //       (Assume usage = number of check-ins where member used equipment)
        //       Format as: "equipmentName (type) - available: n/total".
        //       Return as List<String>.
        List<String> getEquipmentAvailability() {
            // TODO: implement
            return new ArrayList<>();
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        GymManager gym = new GymManager();

        // --- Setup equipment ---
        gym.addEquipment(new Equipment(1, "Treadmill", "Cardio", 5));
        gym.addEquipment(new Equipment(2, "Dumbbell Set", "Strength", 3));
        gym.addEquipment(new Equipment(3, "Yoga Mat", "Flexibility", 10));

        // --- Setup members ---
        Member m1 = new Member(601, "Alice Anderson", "alice@gym.com", MembershipTier.PREMIUM, 6);
        Member m2 = new Member(602, "Bob Brown", "bob@gym.com", MembershipTier.BASIC, 3);
        Member m3 = new Member(603, "Carol Clark", "carol@gym.com", MembershipTier.ELITE, 12);

        gym.addMember(m1);
        gym.addMember(m2);
        gym.addMember(m3);

        // --- Test 1: Check in/out ---
        System.out.println("=== Test 1: Check In/Out ===");
        System.out.println("Alice checks in (expect true): " + gym.checkInMember(601));
        System.out.println("Bob checks in (expect true): " + gym.checkInMember(602));
        System.out.println("Current occupancy (expect 2): " + gym.getCurrentOccupancy());
        System.out.println("Alice checks out (expect true): " + gym.checkOutMember(601));

        // --- Test 2: Get active members ---
        System.out.println("\n=== Test 2: Active Members ===");
        List<String> active = gym.getActiveMembers();
        for (String member : active) {
            System.out.println("  " + member);
        }

        // --- Test 3: Membership renewal ---
        System.out.println("\n=== Test 3: Renew Membership ===");
        System.out.println("Renew Bob's membership (expect true): " + gym.renewMembership(602, 1));

        // --- Test 4: Suspend membership ---
        System.out.println("\n=== Test 4: Suspend Membership ===");
        System.out.println("Suspend Bob's membership (expect true): " + gym.suspendMembership(602));
        System.out.println("Bob tries to check in (expect false): " + gym.checkInMember(602));

        // --- Test 5: Get attendance records ---
        System.out.println("\n=== Test 5: Attendance Records ===");
        List<String> attendance = gym.getMemberAttendance(601);
        for (String record : attendance) {
            System.out.println("  " + record);
        }

        // --- Test 6: Attendance stats ---
        System.out.println("\n=== Test 6: Attendance Stats ===");
        Map<String, Object> stats = gym.getMemberAttendanceStats(601);
        System.out.println("  " + stats);

        // --- Test 7: Equipment availability ---
        System.out.println("\n=== Test 7: Equipment Availability ===");
        List<String> equipment = gym.getEquipmentAvailability();
        for (String eq : equipment) {
            System.out.println("  " + eq);
        }

        // --- Test 8: Most active members ---
        System.out.println("\n=== Test 8: Most Active Members ===");
        List<String> mostActive = gym.getMostActiveMembersThisMonth();
        for (String member : mostActive) {
            System.out.println("  " + member);
        }
    }
}

