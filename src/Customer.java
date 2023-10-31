
public class Customer {
	private int customerId;
    private String name;
    private String email;
    private String address;
    protected Cart cart;
    
    public Customer( String name, String email, String address) {
        this.customerId = custID();
        this.name = name;
        this.email = email;
        this.address = address;
        this.cart = new Cart(); // Initialize the cart
    }
    
    int custID() {
		return ++customerId;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public void removeFromCart(Product product) {
        cart.removeProduct(product);
    }

    public void viewCart() {
        cart.displayCart();
    }
    
    public void checkout() {
        double totalAmount = cart.calculateTotal();
        System.out.println("Checkout completed. Total amount: $" + totalAmount);
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Email: " + email + ", Address: " + address;
    }
}
