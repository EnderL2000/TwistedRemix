package com.ender.twistedremix;


import Main.KryoHelper;
import com.ender.twistedListeners.ClientListener;
import com.esotericsoftware.kryonet.Client;
import twistedBuffers.SomeRequest;

import java.io.IOException;

public class TwistedClient extends Client{

    public TwistedClient() {
        KryoHelper.getInstance().setClient(this);
        KryoHelper.getInstance().registerClientClasses();
        addListener(new ClientListener(this));
    }

    public void startClient() {
        start();
        try {
            connect(5000, "192.168.1.5", 1099, 2000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SomeRequest request = new SomeRequest();
        request.text = "Here is the request";
        sendTCP(request);
    }
}
