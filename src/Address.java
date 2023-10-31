
public class Address {
	private String city;
	private String state;
	private String zipcode;
	
	public Address(String city,String state,String zipcode) {
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	
	public String toString() {
		return city+" "+state+" "+zipcode;
	}
}
