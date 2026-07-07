package com.home.shah.ProblemSolvingPractice.Karat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class OnlineStoreInventoryPractice {

    // ==================== ENUMS ====================
    enum OrderStatus {
        PENDING, PROCESSING, SHIPPED, DELIVERED, CANCELLED
    }

    enum ProductCategory {
        ELECTRONICS, CLOTHING, HOME, BOOKS, SPORTS
    }

    // ==================== ENTITY CLASSES ====================
    static class Product {
        int productId;
        String name;
        ProductCategory category;
        double price;
        int quantity;
        String description;

        Product(int productId, String name, ProductCategory category, double price, int quantity, String description) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.price = price;
            this.quantity = quantity;
            this.description = description;
        }
    }

    static class Customer {
        int customerId;
        String name;
        String email;
        String address;
        double totalSpent;

        Customer(int customerId, String name, String email, String address) {
            this.customerId = customerId;
            this.name = name;
            this.email = email;
            this.address = address;
            this.totalSpent = 0;
        }
    }

    static class Order {
        int orderId;
        int customerId;
        LocalDateTime orderDate;
        OrderStatus status;
        Map<Integer, Integer> items; // productId -> quantity
        double totalAmount;

        Order(int orderId, int customerId, Map<Integer, Integer> items, double totalAmount) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.orderDate = LocalDateTime.now();
            this.status = OrderStatus.PENDING;
            this.items = new HashMap<>(items);
            this.totalAmount = totalAmount;
        }
    }

    // ==================== MANAGER CLASS ====================
    static class StoreManager {
        Map<Integer, Product> products = new HashMap<>();
        Map<Integer, Customer> customers = new HashMap<>();
        List<Order> orders = new ArrayList<>();
        int nextOrderId = 8000;

        // 1. Add a product to inventory
        // TODO: Store product in 'products' map using productId as key.
        void addProduct(Product product) {
            // TODO: implement
        }

        // 2. Register a customer
        // TODO: Store customer in 'customers' map using customerId as key.
        void addCustomer(Customer customer) {
            // TODO: implement
        }

        // 3. Place an order
        // TODO: Validate customerId exists.
        //       Validate all productIds exist and have sufficient quantity.
        //       Calculate totalAmount = sum of (product.price * quantity) for each item.
        //       Create Order with status PENDING.
        //       Deduct quantities from product inventory.
        //       Return orderId on success, -1 if validation fails or out of stock.
        int placeOrder(int customerId, Map<Integer, Integer> items) {
            // TODO: implement
            return -1;
        }

        // 4. Cancel an order
        // TODO: Find order by orderId.
        //       If status is PENDING or PROCESSING, change to CANCELLED.
        //       Restore item quantities to inventory.
        //       Return true if successful, false if order not found or already shipped.
        boolean cancelOrder(int orderId) {
            // TODO: implement
            return false;
        }

        // 5. Update order status
        // TODO: Find order by orderId.
        //       Update status (PENDING -> PROCESSING -> SHIPPED -> DELIVERED).
        //       If transitioning to DELIVERED, add totalAmount to customer.totalSpent.
        //       Return true if successful, false if order not found or invalid status transition.
        boolean updateOrderStatus(int orderId, OrderStatus newStatus) {
            // TODO: implement
            return false;
        }

        // 6. Get products in stock (quantity > 0)
        // TODO: Filter products where quantity > 0.
        //       Format as: "name (category) - $price - quantity: n".
        //       Sort by category then name.
        List<String> getProductsInStock() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 7. Get low stock products (quantity < 10)
        // TODO: Filter products where 0 < quantity < 10.
        //       Format as: "name - quantity: n - reorder soon".
        //       Sort by quantity ascending.
        List<String> getLowStockProducts() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 8. Get out of stock products
        // TODO: Filter products where quantity == 0.
        //       Format as: "name (category)".
        //       Sort by name.
        List<String> getOutOfStockProducts() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 9. Get customer order history
        // TODO: Filter orders by customerId.
        //       Format each as: "Order [id] - [date] - status: [status] - $amount".
        //       Sort by orderDate descending (most recent first).
        List<String> getCustomerOrderHistory(int customerId) {
            // TODO: implement
            return new ArrayList<>();
        }

        // 10. Get best-selling products (by quantity sold)
        // TODO: Sum quantities sold for each product across all completed orders.
        //       Sort by total quantity descending.
        //       Format as: "productName - quantity sold: n".
        //       Return top 10 as List<String>.
        List<String> getBestSellingProducts() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 11. Get revenue by category
        // TODO: For each ProductCategory, sum totalAmount from all DELIVERED orders.
        //       Return Map<ProductCategory, Double>.
        Map<ProductCategory, Double> getRevenueByCategory() {
            // TODO: implement
            return new HashMap<>();
        }

        // 12. Get top customers (by total spent)
        // TODO: Sort customers by totalSpent descending.
        //       Format as: "name - total spent: $amount".
        //       Return top 10 as List<String>.
        List<String> getTopCustomers() {
            // TODO: implement
            return new ArrayList<>();
        }

        // 13. Get inventory value
        // TODO: For each product, calculate value = price * quantity.
        //       Sum all values.
        //       Return total as a double.
        double getInventoryValue() {
            // TODO: implement
            return 0;
        }

        // 14. Get pending orders
        // TODO: Filter orders with status PENDING or PROCESSING.
        //       Format as: "Order [id] - customer: [name] - $amount".
        //       Sort by orderDate ascending (oldest first).
        List<String> getPendingOrders() {
            // TODO: implement
            return new ArrayList<>();
        }
    }

    // ==================== TEST CASES ====================
    public static void main(String[] args) {
        StoreManager store = new StoreManager();

        // --- Setup products ---
        store.addProduct(new Product(1001, "Laptop", ProductCategory.ELECTRONICS, 999.99, 5, "High-performance laptop"));
        store.addProduct(new Product(1002, "T-Shirt", ProductCategory.CLOTHING, 19.99, 50, "Cotton t-shirt"));
        store.addProduct(new Product(1003, "Java Book", ProductCategory.BOOKS, 49.99, 8, "Learn Java programming"));
        store.addProduct(new Product(1004, "Pillow", ProductCategory.HOME, 29.99, 3, "Memory foam pillow"));
        store.addProduct(new Product(1005, "Soccer Ball", ProductCategory.SPORTS, 24.99, 0, "Official size soccer ball"));

        // --- Setup customers ---
        store.addCustomer(new Customer(2001, "John Doe", "john@example.com", "123 Main St"));
        store.addCustomer(new Customer(2002, "Jane Smith", "jane@example.com", "456 Oak Ave"));
        store.addCustomer(new Customer(2003, "Bob Johnson", "bob@example.com", "789 Pine Rd"));

        // --- Test 1: Place orders ---
        System.out.println("=== Test 1: Place Orders ===");
        Map<Integer, Integer> order1 = new HashMap<>();
        order1.put(1001, 1);
        order1.put(1002, 2);
        int orderId1 = store.placeOrder(2001, order1);
        System.out.println("Order 1 placed (expect valid ID): " + orderId1);

        Map<Integer, Integer> order2 = new HashMap<>();
        order2.put(1003, 1);
        order2.put(1004, 2);
        int orderId2 = store.placeOrder(2002, order2);
        System.out.println("Order 2 placed (expect valid ID): " + orderId2);

        // --- Test 2: Products in stock ---
        System.out.println("\n=== Test 2: Products In Stock ===");
        List<String> inStock = store.getProductsInStock();
        for (String product : inStock) {
            System.out.println("  " + product);
        }

        // --- Test 3: Out of stock ---
        System.out.println("\n=== Test 3: Out Of Stock ===");
        List<String> outOfStock = store.getOutOfStockProducts();
        for (String product : outOfStock) {
            System.out.println("  " + product);
        }

        // --- Test 4: Customer order history ---
        System.out.println("\n=== Test 4: Customer Order History ===");
        List<String> history = store.getCustomerOrderHistory(2001);
        for (String order : history) {
            System.out.println("  " + order);
        }

        // --- Test 5: Update order status ---
        System.out.println("\n=== Test 5: Update Order Status ===");
        System.out.println("Process order (expect true): " + store.updateOrderStatus(orderId1, OrderStatus.PROCESSING));
        System.out.println("Ship order (expect true): " + store.updateOrderStatus(orderId1, OrderStatus.SHIPPED));
        System.out.println("Deliver order (expect true): " + store.updateOrderStatus(orderId1, OrderStatus.DELIVERED));

        // --- Test 6: Inventory value ---
        System.out.println("\n=== Test 6: Inventory Value ===");
        double invValue = store.getInventoryValue();
        System.out.println("Total inventory value: $" + String.format("%.2f", invValue));

        // --- Test 7: Revenue by category ---
        System.out.println("\n=== Test 7: Revenue By Category ===");
        Map<ProductCategory, Double> revenue = store.getRevenueByCategory();
        for (Map.Entry<ProductCategory, Double> entry : revenue.entrySet()) {
            System.out.println("  " + entry.getKey() + ": $" + String.format("%.2f", entry.getValue()));
        }

        // --- Test 8: Pending orders ---
        System.out.println("\n=== Test 8: Pending Orders ===");
        List<String> pending = store.getPendingOrders();
        for (String order : pending) {
            System.out.println("  " + order);
        }
    }
}

