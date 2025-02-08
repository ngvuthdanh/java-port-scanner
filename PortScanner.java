import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class PortScanner {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java PortScanner <host>");
            return;
        }

        String targetHost = args[0];

        int startPort = 1;
        int endPort = 65535;

        System.out.println("Starting port scan for host: " + targetHost);

        for (int port = startPort; port <= endPort; port++) {
            if (isPortOpen(targetHost, port)) {
                System.out.println("Port " + port + " is open.");
            }
        }
    }


    private static boolean isPortOpen(String host, int port) {
        try (Socket socket = new Socket()) {
            SocketAddress address = new InetSocketAddress(host, port);
            socket.connect(address, 200);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
