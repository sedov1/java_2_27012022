package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientUser {
    public static final String SERVER_ADRESS = "localhost";
    public static final int SERVER_PORT = 8170;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(SERVER_ADRESS, SERVER_PORT);
            System.out.println("Connected in server" + socket.getRemoteSocketAddress());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread threadReader = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            threadReader.setDaemon(true);
            threadReader.start();
            while (true) {
                String str = inputStream.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Client disconnected");
                    outputStream.writeUTF("//end");
                    break;
                } else {
                    System.out.println("Server" + str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ClientUser.close();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private static void close() {
    }
}





