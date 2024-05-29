package sem2.sep2.shared.util.users;

import java.io.Serializable;

public class Manager extends User implements Serializable
{
    private String password;
    private static Manager instance = null;

    private Manager() {
        super("admin", "admin");
    }

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
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