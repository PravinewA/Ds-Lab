import java.net.*;

public class MulticastPeer {
    public static void main(String[] args) {
        MulticastSocket socket = null;
        try {
            byte[] msg = args[1].getBytes();
            InetAddress group = InetAddress.getByName(args[0]);
            socket = new MulticastSocket(5678);
            DatagramPacket request = new DatagramPacket(msg, msg.length, group, 5678);
            socket.send(request);

            for (int i = 0; i <= 5; i++) {
                byte[] buffer = new byte[1000];
                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                System.out.println("Client : " + new String(response.getData()));

            }
        } catch (Exception e) {

        } finally {
            if (socket != null)
                socket.close();
        }
    }
}
