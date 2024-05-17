package sem2.sep2.client.core;

import sem2.sep2.client.networking.contact.ContactClient;
import sem2.sep2.client.networking.contact.ContactClientImpl;
import sem2.sep2.client.networking.login.LoginClient;
import sem2.sep2.client.networking.login.LoginClientImpl;
import sem2.sep2.client.networking.register.CreateClient;
import sem2.sep2.client.networking.register.CreateClientImpl;
import sem2.sep2.client.networking.room.RoomClient;
import sem2.sep2.client.networking.room.RoomClientImpl;

public class ClientFactory {
    private LoginClient loginClient;
    private CreateClient createCLient;
    private RoomClient reserveClient;
    private ContactClient contactClient;
    public LoginClient getLoginClient() {
        if (loginClient == null) {
            loginClient = new LoginClientImpl();
        }
        return loginClient;
    }

    public CreateClient getCreateClient() {
        if (createCLient == null) {
            createCLient = new CreateClientImpl();
        }
        return createCLient;
    }
    public RoomClient getReserveClient() {
        if (reserveClient == null) {
            reserveClient = new RoomClientImpl();
        }
        return reserveClient;
    }

    public ContactClient getContactClient()
    {
        if (contactClient == null) {
            contactClient = new ContactClientImpl();
        }
        return contactClient;
    }
}
