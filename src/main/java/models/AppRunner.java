package models;

import daos.ConnectionFactory;

import java.sql.Connection;

public class AppRunner {
    public static void main(String[] args){
        Connection connection = ConnectionFactory.getConnection();
    }
}
