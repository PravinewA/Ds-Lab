import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    int calculateSum(int a, int b) throws RemoteException;
}