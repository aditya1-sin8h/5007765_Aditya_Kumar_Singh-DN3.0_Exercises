import java.util.*;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private float price;

    Product(int productId, String productName, int quantity, float price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public float getPrice() { return price; }

    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: " + price;
    }
}

class Inventory{
    private List<Product> productList;

    public Inventory() {
        productList = new ArrayList<>();
    }

    // Add a new product
    public void addProduct(Product product) {
        productList.add(product);
    }

    // Update an existing product
    public void updateProduct(int productId, Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                productList.set(i, updatedProduct);
                return;
            }
        }
        System.out.println("Product with ID " + productId + " does not exist.");
    }

    // Delete a product
    public void deleteProduct(int productId) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == productId) {
                productList.remove(i);
                return;
            }
        }
        System.out.println("Product with ID " + productId + " does not exist.");
    }

    // Print all products
    public void printInventory() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}

public class InventoryManagement{
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product product1 = new Product(4, "laptop", 1, 50000);
        Product product2 = new Product(9, "Mouse", 1, 500);
        Product product3 = new Product(1, "Keyboard", 1, 900);
        Product updateProduct = new Product(4, "Laptop", 1, 60000);

        inventory.addProduct(product1);
        inventory.addProduct(product2);

        inventory.printInventory();

        inventory.updateProduct(4, updateProduct);
        inventory.addProduct(product3);
        inventory.printInventory();

        inventory.deleteProduct(1);
        inventory.printInventory();
    }
}