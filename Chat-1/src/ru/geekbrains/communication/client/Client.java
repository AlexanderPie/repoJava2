package ru.geekbrains.communication.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public Client() {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);
            new Thread(() -> {
                while (true) {
                    try {
                        out.writeUTF("Client: " + sc.nextLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while (true) {
                String msg = in.readUTF();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
