package ru.gb.chat.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AuthenticationService {
    public List<Users> all(){
        Connection connection = DBConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");

            List<Users> users = new ArrayList<>();
            while (resultSet.next()){
                users.add(
                        new Users(
                                resultSet.getString("login"),
                                resultSet.getString("pass")
                        )
                );
            }
            return users;

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    public Optional<Users> findEntryByCredentials(String login, String password) {
        Iterator<Users> iterator = all().iterator();
        while (iterator.hasNext()) {
            Users next = iterator.next();
            if (next.getLogin().equals(login) && next.getPass().equals(password)) {
                return Optional.of(next);
            }
        }
        return Optional.empty();
    }

}
