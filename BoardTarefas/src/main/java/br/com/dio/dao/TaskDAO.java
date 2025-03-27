package br.com.dio.dao;

import br.com.dio.conexaoMySql.ConnectionMySQL;
import br.com.dio.model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    public void adicionarTarefa(String title,String description){
        String sql = "INSERT INTO tasks (title, description) VALUES (?, ?)";
        try (Connection c = ConnectionMySQL.getConnection();
        PreparedStatement s = c.prepareStatement(sql)){

            s.setString(1,title);
            s.setString(2,description);
            s.executeUpdate();
            System.out.println("Task added");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Task> listAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Connection c = ConnectionMySQL.getConnection();
             Statement s = c.createStatement();
             ResultSet rs = s.executeQuery(sql)) {

            while (rs.next()) {
                tasks.add(new Task(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("status")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }
    public void updateStatus(int id ,String newStatus){
        String sql = "UPDATE tasks SET status = ? WHERE id = ?";
        try(Connection c = ConnectionMySQL.getConnection();
        PreparedStatement s = c.prepareStatement(sql)){
            s.setString(1,newStatus);
            s.setInt(2,id);
            int rowsAffected = s.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("NEW STATUS UPDATE");
            } else {
                System.out.println("NO TASKS FOUND THAT ID");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void deleteTask(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection c = ConnectionMySQL.getConnection();
             PreparedStatement s = c.prepareStatement(sql)) {
            s.setInt(1, id);
            int rowsAffected = s.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("TASK DELETED");
            } else {
                System.out.println("\"NO TASKS FOUND THAT ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
