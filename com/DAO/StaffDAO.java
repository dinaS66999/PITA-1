package src.main.java.com.DAO;


import src.main.java.com.Model.Staff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StaffDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/webapps"; 
    private String jdbcUsername = "root"; 
    private String jdbcPassword = "admin"; 

    private static final String INSERT_STAFF_SQL = "INSERT INTO staff (name, age, gender, address, phone_number, email, password) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_STAFF_BY_EMAIL = "SELECT * FROM staff WHERE email = ?;";

    //register staff
    public void registerStaff(Staff staff) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL)) {
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setInt(2, staff.getAge());
            preparedStatement.setString(3, staff.getGender());
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setString(5, staff.getPhoneNumber());
            preparedStatement.setString(6, staff.getEmail());
            preparedStatement.setString(7, staff.getPassword()); 
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Staff getStaffByEmail(String email) {
        Staff staff = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                staff = new Staff();
                staff.setId(resultSet.getInt("id"));
                staff.setName(resultSet.getString("name"));
                staff.setAge(resultSet.getInt("age"));
                staff.setGender(resultSet.getString("gender"));
                staff.setAddress(resultSet.getString("address"));
                staff.setPhoneNumber(resultSet.getString("phone_number"));
                staff.setEmail(resultSet.getString("email"));
                staff.setPassword(resultSet.getString("password")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staff; 
    }
}