package sem2.sep2.shared.util.users;

public class Manager extends User {
    private String password;

    public Manager(String password) {
        super("admin", password);
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return "admin";
    }

}