
import java.util.List;

public class SignUp {
	private List<User> users;

    public SignUp(List<User> users) {
        this.users = users;
    }

    public boolean registerUser(String username, String password) {
        // Check if the username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                System.out.println("Username is already taken. Please choose a different one.");
                return false; // Registration failed
            }
        }

        // If the username is not taken, create a new user and add it to the list
        User newUser = new User(username, password);
        users.add(newUser);
        System.out.println("Registration successful. Welcome, " + username + "!");
        return true;
    }

}

