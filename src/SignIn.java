
import java.util.List;

public class SignIn {
	private List<User> users;

    public SignIn(List<User> users) {
        this.users = users;
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // User is authenticated
            }
        }
        return null; // Authentication failed
    }
}
