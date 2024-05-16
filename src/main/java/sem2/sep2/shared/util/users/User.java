package sem2.sep2.shared.util.users;

import java.io.Serializable;

public abstract class User implements Serializable {
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User other = (User) obj;
            return userName.equals(other.userName);
        }
        return false;
    }
}
