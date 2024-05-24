package sem2.sep2.shared.util;

import java.io.Serializable;

public class Request<T> implements Serializable {
    private String type;
    private T object;

    public Request(String type, T object) {
        this.type = type;
        this.object = object;
    }

    public String getType() {
        return type;
    }

    public T getObject() {
        return object;
    }
}
