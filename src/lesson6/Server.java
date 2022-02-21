package lesson6;

import com.sun.security.ntlm.Client;
import javafx.css.SimpleStyleableBooleanProperty;
import sun.text.normalizer.UTF16;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Socket clientSocket=null;
        Scanner scanner=new Scanner(System.in);

        try (ServerSocket serverSocket=new ServerSocket(8170)) {
            System.out.println("Cервер запущен");
clientSocket=serverSocket.accept();
            System.out.println("Client connected:" +clientSocket.getRemoteSocketAddress());
            DataInputStream inputStream=new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream=new DataOutputStream(clientSocket.getOutputStream());

            Thread thread= new Thread(()->{
            try {
                while (true){
                    outputStream.writeUTF(scanner.nextLine());
                }
                    } catch (IOException e) {
            e.printStackTrace();
        }
    });
        Thread threadReader = null;
        threadReader.setDaemon(true);
        threadReader.start();
           while (true){
               String str =inputStream.readUTF();
               if(str.equals("/end")) {
                   System.out.println("Client disconnected");
                   outputStream.writeUTF("//end");
                   break;
               }else {
                   System.out.println("Client"+str);
               }
               }
    } catch (IOException e) {
        e.printStackTrace();
    }finally

    {
        try {
            Server.close();
        } catch (NullPointerException e){
        e.printStackTrace();
    }
    }
}

    private static void close() {
    }
}
