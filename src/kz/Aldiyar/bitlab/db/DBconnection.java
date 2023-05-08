package kz.Aldiyar.bitlab.db;

import kz.Aldiyar.bitlab.servlets.Task;

import java.sql.*;
import java.util.ArrayList;

public class DBconnection {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aldik_db",
                    "root",
                    "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Task> getTasks() {

        ArrayList<Task> tasks = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * from tasks");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                Task task = new Task();
                task.setName(resultSet.getString("name"));
                task.setId(resultSet.getInt("id"));
                task.setDescription(resultSet.getString("description"));
                task.setDescription1(resultSet.getString("description1"));
                task.setDeadlineDate(resultSet.getString("deadlineDate"));

                tasks.add(task);
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void addTask(Task task) {
        try {
            PreparedStatement statement = connection.prepareStatement(" " +
                    "INSERT into tasks (name, description, description1, deadlineDate) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, task.getName());
            statement.setString(2, task.getDescription());
            statement.setString(3, task.getDescription1());
            statement.setString(4, task.getDeadlineDate());

            statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Task getTask(int id) {

        Task task = null;
        try {
            PreparedStatement statement = connection.prepareStatement(" " +
                    "SELECT * from tasks WHERE id = ? LIMIT 1");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                task = new Task();
                task.setName(resultSet.getString("name"));
                task.setId(resultSet.getInt("id"));
                task.setDescription(resultSet.getString("description"));
                task.setDescription1(resultSet.getString("description1"));
                task.setDeadlineDate(resultSet.getString("deadlineDate"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }


    public static void updateTask(Task task){
    try {
        PreparedStatement statement = connection.prepareStatement("" +
                "UPDATE tasks " +
                "SET " +
                "name = ?, " +
                "description = ?, " +
                "description1 = ?, " +
                "deadlineDate = ?, " +
                "WHERE id = ?");

        statement.setString(1, task.getName());
        statement.setString(2, task.getDescription());
        statement.setString(3, task.getDescription1());
        statement.setString(4, task.getDeadlineDate());
        statement.setInt(5, task.getId());
        statement.executeUpdate();
        statement.close();

    }catch (Exception e) {
        e.printStackTrace();
    }
    }
    public static void deleteTask(int id){
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE from tasks where id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();

            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

