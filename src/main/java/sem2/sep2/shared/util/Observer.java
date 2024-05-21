package sem2.sep2.shared.util;

import java.rmi.Remote;

public interface Observer extends Remote {
    void update() throws Exception;
}
