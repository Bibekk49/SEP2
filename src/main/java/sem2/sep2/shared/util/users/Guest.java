package sem2.sep2.shared.util.users;

public class Guest extends User {
    private String username;
    private String password;

    public Guest(String username, String password) {
        super(username, password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
