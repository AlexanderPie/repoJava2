package ru.gb.chat.server;

public class Users {
    private String login;
    private String pass;

    public Users(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "Users{" +
                "login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
