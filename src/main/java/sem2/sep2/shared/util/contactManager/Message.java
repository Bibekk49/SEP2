package sem2.sep2.shared.util.contactManager;

import sem2.sep2.shared.util.users.Guest;
import sem2.sep2.shared.util.users.Manager;

import java.io.Serializable;


public class Message implements Serializable {
    private Guest guestSender;
    private String messageBody;

    //This constructor is used by the guest to send a message to the manager
    public Message(Guest guestSender, String messageBody) {
        this.guestSender = guestSender;
        this.messageBody = messageBody;
    }
    //This constructor is used by Manager to send a message to the guest
    public Message(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getUserNameSender() {
        return guestSender.getUsername();
    }

    public String getMessageBody() {
        return messageBody;
    }
    public String toString() {
        return "Message{" +
                "Guest Sender=" + guestSender +
                "Message='" + messageBody + '\'' +
                '}';
    }

}

