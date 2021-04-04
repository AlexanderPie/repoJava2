package ru.geekbrains;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;

public class ClientHandler {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;
    private Server server;

    public ClientHandler(Socket socket, Server chatServer) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new ServerException("Что-то пошло не так.", e);
        }

        new Thread(() -> {
            doAuth(chatServer);
            listen();
        }).start();

    }

    public String getName() {
        return name;
    }

    private void listen(){
        receive();
    }

    private void doAuth(Server chatServer){

        send("Пройдите аутентификацию");
        while(true){
            try {
                String mes = in.readUTF();
                if (mes.startsWith("-auth")){
                    String[] cred = mes.split(" ");
                    String login = cred[1];
                    String pass = cred[2];
                    Optional<Auth.Entry> mayBeCred = chatServer.getAuth().getEntryByCred(login, pass);
                    if (mayBeCred.isPresent()){
                        Auth.Entry creds = mayBeCred.get();
                        if (!chatServer.isOcc(creds.getName())){
                            chatServer.subs(this);
                            chatServer.broadcast(String.format("User [%s] залогинен", creds.getName()));
                            return;
                        } else send("User залогинен");
                    } else {
                        send("Неверные логин/пароль");
                    }
                } else {send("Неверный формат");}
            } catch (IOException e) {
                throw new ServerException("Что-то пошло не так при аутентификации", e);
            }
        }
    }

    public void receive(){
        while (true){
            String msg = null;
            try {
                msg = in.readUTF();
                server.broadcast(String.format("[%s]: %s", name, msg));
            } catch (IOException e) {
                throw new ServerException("Что-то пошло не так при приеме сообщения", e);            }

        }
    }

    public void send(String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            throw new ServerException("Что-то пошло не так при отправке сообщения", e);
        }
    }

}
