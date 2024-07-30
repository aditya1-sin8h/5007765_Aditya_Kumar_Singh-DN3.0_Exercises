//import java.util.*;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
    }
}

class SortingAlgorithms {

    // Bubble Sort algorithm
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort algorithm
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
}
public class SortingOrders {
    public static void main(String[] args) {
        // Create an array of orders
        Order[] orders = {
            new Order(1, "Aditya", 250.75),
            new Order(2, "Bhuvan", 150.20),
            new Order(3, "Charles", 300.50),
            new Order(4, "Diana", 100.00),
            new Order(5, "Hamil", 175.40)
        };

        // Sort orders by totalPrice using Bubble Sort
        SortingAlgorithms.bubbleSort(orders);
        System.out.println("Bubble Sort Result:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Re-create the array for Quick Sort
        orders = new Order[]{
            new Order(1, "Aditya", 250.75),
            new Order(2, "Bhuvan", 150.20),
            new Order(3, "Charles", 300.50),
            new Order(4, "Diana", 100.00),
            new Order(5, "Hamil", 175.40)
        };

        // Sort orders by totalPrice using Quick Sort
        SortingAlgorithms.quickSort(orders, 0, orders.length - 1);
        System.out.println("Quick Sort Result:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
