package models;

import daos.ConnectionFactory;
import daos.User;
import daos.UserDAO;

import java.sql.Connection;
import java.util.List;

public class AppRunner {
    public static void main(String[] args){
        System.out.println("Getting connection");
        Connection connection = ConnectionFactory.getConnection();
        UserDAO userDAO = new UserDAO(connection);
        System.out.println("Calling getConnection()...3");
        List<User> userList = userDAO.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        System.out.println("Creating User");
        User newUser = new User(5, "khalil", "crumpler", "abc@gmail.com", "male", "philly");
        userDAO.create(newUser);
        System.out.println("User added to database");
        System.out.println("Updating user");
        newUser.setLast_name("Smith");
        userDAO.update(newUser);
        System.out.println("Removing User");
        userDAO.delete(7);
        userList = userDAO.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }



    }
}
