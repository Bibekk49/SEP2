package sem2.sep2.shared.util.contactManager;

import sem2.sep2.shared.util.users.Guest;

import java.io.Serializable;


public class Message implements Serializable {
    private Guest guestSender;
    private String messageBody;

    public Message(Guest guestSender, String messageBody) {
        this.guestSender = guestSender;
        this.messageBody = messageBody;
    }

    public String getUserNameSender() {
        return guestSender.getUsername();
    }

    public String getMessageBody() {
        return messageBody;
    }

    public int getGuestID() {
        return guestSender.getId();
    }

}

