import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppyCart {

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
        SignUp signUp = new SignUp(users);
        SignIn signIn = new SignIn(users);

        // Create sample products
        List<Product> products = Product.getSampleProducts();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Welcome to the E-Cart Application!");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    // User registration
                    System.out.print("Enter your username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String newPassword = scanner.nextLine();

                    signUp.registerUser(newUsername, newPassword);
                    break;

                case 2:
                    // User sign-in
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    User authenticatedUser = signIn.authenticateUser(username, password);
                    if (authenticatedUser != null) {
                        System.out.println("Sign-in successful. Welcome, " + username + "!");

                        Customer customer = new Customer(username,"email","add");
                        if (customer instanceof PremiumCustomers) {
                            // Create a PremiumCustomer
                            customer = (PremiumCustomers) customer;
                            ((PremiumCustomers) customer).accessPremiumFeatures();
                        } else {
                            // Create a regular Customer
                            customer = new Customer(username,"email","add");
                        }

                        Cart cart = customer.cart;

                        while (true) {
                            System.out.println("\nE-Cart Menu:");
                            System.out.println("1. View Products");
                            System.out.println("2. Add Product to Cart");
                            System.out.println("3. View Cart");
                            System.out.println("4. Checkout");
                            System.out.println("5. Sign Out");
                            System.out.print("Select an option: ");

                            int cartChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character

                            switch (cartChoice) {
                                case 1:
                                    // Display available products
                                    System.out.println("Available Products:");
                                    for (Product product : products) {
                                        System.out.println(product);
                                    }
                                    break;

                                case 2:
                                    // Add a product to the cart
                                    System.out.print("Enter the product ID to add to your cart: ");
                                    int productId = scanner.nextInt();
                                    Product selectedProduct = findProductById(products, productId);
                                    if (selectedProduct != null) {
                                        cart.addProduct(selectedProduct);
                                        System.out.println(selectedProduct.getName() + " added to the cart.");
                                    } else {
                                        System.out.println("Product not found.");
                                    }
                                    break;

                                case 3:
                                    // View the cart
                                    System.out.println("Your Cart Contents:");
                                    for (Product product : cart.getItems()) {
                                        System.out.println(product);
                                    }
                                    break;

                                case 4:
                                    // Checkout
                                    double total = cart.calculateTotal();
                                    System.out.println("Total Amount: $" + total);
                                    customer.checkout();
                                    System.out.println("Checkout completed. Thank you for shopping!");
                                    break;

                                case 5:
                                    // Sign out
                                    System.out.println("Signing out. Goodbye!");
                                    scanner.close();
                                    return;

                                default:
                                    System.out.println("Invalid choice. Please select a valid option.");
                            }
                        }
                    } else {
                        System.out.println("Sign-in failed. Please check your username and password.");
                    }
                    break;

                case 3:
                    // Exit
                    System.out.println("Exiting the E-Cart Application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static Product findProductById(List<Product> products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
        
        

	}


