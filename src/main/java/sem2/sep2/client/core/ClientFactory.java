package sem2.sep2.client.core;

import sem2.sep2.client.networking.contact.ContactClient;
import sem2.sep2.client.networking.contact.ContactClientImpl;
import sem2.sep2.client.networking.login.LoginClient;
import sem2.sep2.client.networking.login.LoginClientImpl;
import sem2.sep2.client.networking.register.RegisterClient;
import sem2.sep2.client.networking.register.CreateClientImpl;
import sem2.sep2.client.networking.room.RoomClient;
import sem2.sep2.client.networking.room.RoomClientImpl;

public class ClientFactory {
    private LoginClient loginClient;
    private RegisterClient createCLient;
    private RoomClient roomClient;
    private ContactClient contactClient;
    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public RegisterClient getCreateClient() {
        if (createCLient == null) {
            createCLient = new CreateClientImpl();
        }
        return createCLient;
    }
    public RoomClient getRoomClient() {
        if (roomClient == null) {
            roomClient = new RoomClientImpl();
        }
        return roomClient;
    }

    public ContactClient getContactClient()
    {
        if (contactClient == null) {
            contactClient = new ContactClientImpl();
        }
        return contactClient;
    }


}
