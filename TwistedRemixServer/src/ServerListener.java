
import twistedBuffers.SomeRequest;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import twistedBuffers.SomeResponse;

public class ServerListener extends Listener{
    private TwistedServer server;

    public ServerListener(TwistedServer server) {
        this.server = server;
    }

    @Override
    public void received(Connection connection, Object object) {
        if(object instanceof SomeRequest)
        {
            SomeRequest request = (SomeRequest)object;
            System.out.println(request.text + "From the client");

            SomeResponse response = new SomeResponse();
            response.text = "Thanks";
            connection.sendTCP(response);
        }
    }

    @Override
    public void disconnected(Connection connection) {
        //server.disconnect
    }

    @Override
    public void connected(Connection connection) {

    }
}
