package ru.geekbrains.communication.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Сервер готов");
            Socket accept = serverSocket.accept();
            System.out.println("Связь установлена " + accept);

            DataInputStream in = new DataInputStream(accept.getInputStream());
            DataOutputStream out = new DataOutputStream(accept.getOutputStream());

            Scanner sc = new Scanner(System.in);

            new Thread(() -> {
                while (true){
                    String msg = null;
                    try {
                        msg = in.readUTF();
                        System.out.println(msg);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

            while (true) {
                out.writeUTF("Server: " + sc.nextLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
