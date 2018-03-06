package com.ender.twistedListeners;

import twistedBuffers.SomeResponse;
import com.ender.twistedremix.TwistedClient;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class ClientListener extends Listener{
    private TwistedClient client;

    public ClientListener(TwistedClient client) {
        this.client = client;
    }

    @Override
    public void received(Connection connection, Object object) {
        if(object instanceof SomeResponse)
        {
            SomeResponse response = (SomeResponse)object;
            System.out.println(response.text);
        }
    }

    @Override
    public void connected(Connection connection) {
        super.connected(connection);
    }

    @Override
    public void disconnected(Connection connection) {
        //client.disconnect
        super.disconnected(connection);
    }
}
