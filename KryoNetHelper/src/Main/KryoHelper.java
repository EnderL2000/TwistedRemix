package Main;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;
import twistedBuffers.SomeRequest;
import twistedBuffers.SomeResponse;

public class KryoHelper {

    private static final KryoHelper kryoHelper = new KryoHelper();

    public Server server;
    public Client client;

    private KryoHelper() {

    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void registerServerClasses() {
        if (server != null) {
            //Register server classes
            Kryo kryo = server.getKryo();
            registerClasses(kryo);
        }
    }

    public void registerClientClasses() {
        if (client != null) {
            //Register client classes
            Kryo kryo = client.getKryo();
            registerClasses(kryo);
        }
    }

    private void registerClasses(Kryo kryo) {
        kryo.register(SomeRequest.class);
        kryo.register(SomeResponse.class);
    }

    public static KryoHelper getInstance() {
        return kryoHelper;
    }
}
