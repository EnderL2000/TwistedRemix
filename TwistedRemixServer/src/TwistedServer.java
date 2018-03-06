import Main.KryoHelper;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

import java.io.IOException;

public class TwistedServer extends Server {

	public Client player1, player2;

	public TwistedServer() {
		KryoHelper.getInstance().setServer(this);
		KryoHelper.getInstance().registerServerClasses();
		this.addListener(new ServerListener(this));
	}

	public void startServer() {
		start();

		try {
			bind (1099, 2000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
