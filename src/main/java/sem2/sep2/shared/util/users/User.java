package sem2.sep2.shared.util.users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password) {
        validateUsername(userName);
        this.userName = userName;
        validatePassword(password);
        this.password = password;
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User other = (User) obj;
            return userName.equals(other.userName);
        }
        return false;
    }

    private void validatePassword(String password) {
        if (password.length() < 3) {
            throw new IllegalStateException("Password should be between 3 and 8 characters.");
        } else if (password.length() > 9) {
            throw new IllegalStateException("Password should be between 3 and 8 characters.");
        }
    }

    private void validateUsername(String username) {
        if (username.length() < 3) {
            throw new IllegalStateException("Username should be between 3 and 8 characters.");
        } else if (username.length() > 9) {
            throw new IllegalStateException("Username should be between 3 and 8 characters.");
        }
    }
    public abstract String getEmployeeType();
}
