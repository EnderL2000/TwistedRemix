public class MainServer {

    public TwistedServer server;

    public MainServer() {
        server = new TwistedServer();

        server.startServer();
    }

    public static void main(String[] args) {
        new MainServer();
    }
}
