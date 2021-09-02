package ru.gb.chat.server;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public void loadDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection () {
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/users", "root", "");
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
