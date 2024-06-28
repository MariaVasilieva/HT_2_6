package org.example;

import org.example.task4.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    private Connection connection;

    public DatabaseQueryService() {
        try {
            this.connection = Database.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> resultList = new ArrayList<>();
        String sqlFilePath = "sql\\find_max_projects_client.sql";
        try (Statement statement = connection.createStatement()) {
            String sqlQuery = readSQLFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("project_total");
                MaxProjectCountClient client = new MaxProjectCountClient(projectCount, name);
                resultList.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка під час виконання SQL-запиту", e);
        }
        return resultList;
    }
    List<LongestProject> findLongestProject(){
        List<LongestProject> resultList = new ArrayList<>();
        String sqlFilePath = "sql\\find_longest_project.sql";
        try (Statement statement = connection.createStatement()) {
            String sqlQuery = readSQLFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int projectId = resultSet.getInt("ID");
                int durationMonths = resultSet.getInt("MONTH_COUNT");
                LongestProject projectInfo = new LongestProject(projectId, durationMonths);
                resultList.add(projectInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка під час виконання SQL-запиту", e);
        }
        return resultList;
    }
    List<MaxSalaryWorker> findMaxSalaryWorker(){
        List<MaxSalaryWorker> resultList = new ArrayList<>();
        String sqlFilePath = "sql\\find_max_salary_worker.sql";
        try (Statement statement = connection.createStatement()) {
            String sqlQuery = readSQLFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");
                MaxSalaryWorker workerInfo = new MaxSalaryWorker(salary, name);
                resultList.add(workerInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка під час виконання SQL-запиту", e);
        }
        return resultList;
    }
    List<YoungestEldestWorkers> findYoungestEldestWorkers(){
        List<YoungestEldestWorkers> resultList = new ArrayList<>();
        String sqlFilePath = "sql\\find_youngest_eldest_workers.sql";
        try (Statement statement = connection.createStatement()) {
            String sqlQuery = readSQLFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                String type = resultSet.getString("TYPE");
                String name = resultSet.getString("NAME");
                String birthday = resultSet.getString("BIRTHDAY");
                YoungestEldestWorkers workerInfo = new YoungestEldestWorkers(type, name, birthday);
                resultList.add(workerInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка під час виконання SQL-запиту", e);
        }
        return resultList;
    }
    List<ProjectPrice> printProjectPrice(){
        List<ProjectPrice> resultList = new ArrayList<>();
        String sqlFilePath = "sql\\print_project_prices.sql";
        try (Statement statement = connection.createStatement()) {
            String sqlQuery = readSQLFile(sqlFilePath);
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int projectId = resultSet.getInt("ID");
                int price = resultSet.getInt("PRICE");
                ProjectPrice projectInfo = new ProjectPrice(projectId, price);
                resultList.add(projectInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Помилка під час виконання SQL-запиту", e);
        }
        return resultList;
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

    public static void main(String[] args) {
        List<MaxProjectCountClient> maxProjectCountClients = new DatabaseQueryService().findMaxProjectsClient();
        maxProjectCountClients.forEach(it -> System.out.println(it));
    }
}
