
public class Name {
	private String fname;
	private String lname;
	
	public Name(String fname,String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getFname() {
		return fname;
	}
	public String getLname() {
		return lname;
	}
	
	public String toString() {
		return fname+" "+lname;
	}
}
