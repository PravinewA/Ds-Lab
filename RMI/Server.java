import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
    public Server() {
    }

    public int calculateSum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            Server s = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(s, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);
            System.out.println("Server running...");
        } catch (Exception e) {

        }
    }
}