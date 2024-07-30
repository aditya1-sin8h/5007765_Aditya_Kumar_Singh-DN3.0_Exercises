import java.util.*;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
    }
}

class SearchAlgorithms {

    // Linear search algorithm
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }
        return null; // Product not found
    }
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductId() == targetId) {
                return midProduct;
            } else if (midProduct.getProductId() < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null; // Product not found
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        // Create products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Mouse", "Electronics"),
            new Product(3, "Keyboard", "Electronics"),
            new Product(4, "Monitor", "Electronics"),
            new Product(5, "Fan", "Furniture")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        // Search for a product using linear search
        Product resultLinear = SearchAlgorithms.linearSearch(products, 3);
        System.out.println("Linear Search Result: " + (resultLinear != null ? resultLinear : "Product not found"));

        // Search for a product using binary search
        Product resultBinary = SearchAlgorithms.binarySearch(products, 3);
        System.out.println("Binary Search Result: " + (resultBinary != null ? resultBinary : "Product not found"));
    }
}
