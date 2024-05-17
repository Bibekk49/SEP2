package sem2.sep2.shared;

import java.beans.PropertyChangeListener;

public interface Subject {
    void addListener(String eventName, PropertyChangeListener listener);
    void removeListener(String eventName, PropertyChangeListener listener);
}
