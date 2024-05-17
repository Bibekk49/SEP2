package sem2.sep2.client.networking.contact;

import sem2.sep2.shared.util.Request;

public interface ContactClient
{
  Request sendMessage(String message);
}
