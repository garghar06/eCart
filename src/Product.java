import java.util.ArrayList;
import java.util.List;

public class Product {
	private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Price: rupee " + price;
    }
    
    public static List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Product A", 10.99));
        products.add(new Product(2, "Product B", 19.99));
        products.add(new Product(3, "Product C", 7.49));
        return products;
    }
}
