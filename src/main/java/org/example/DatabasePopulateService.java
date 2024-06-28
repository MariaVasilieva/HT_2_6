package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String path = "sql\\populate_db.sql";
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()){
            String sqlQuery = readSQLFile(path);
            System.out.println(sqlQuery);
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readSQLFile(String path) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            br.lines().forEach(line -> sb.append(line).append("\n"));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
}
