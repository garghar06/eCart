
public class PremiumCustomers extends Customer{
	String membershipCard;

    public PremiumCustomers( String name, String email, String address,String membershipCard) {
        super(name, email, address);
        this.membershipCard = membershipCard; 
    }

    public void accessPremiumFeatures() {
        System.out.println("Welcome, premium customer! Enjoy additional benefits.");
    }
    @Override
    public void checkout() {
        double totalAmount = cart.calculateTotal();
        double discountedAmount = applyPremiumDiscount(totalAmount);
        System.out.println("Checkout completed. Total amount: $" + discountedAmount);
    }
    private double applyPremiumDiscount(double totalAmount) {
        return totalAmount * 0.9;
    }
    
}
