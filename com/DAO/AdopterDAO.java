package src.main.java.com.DAO;


import src.main.java.com.Model.Adopter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdopterDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/webapps"; 
    private static String jdbcUsername = "root"; 
    private static String jdbcPassword = "admin";
    
    //register adopter
    public static void registerAdopter(Adopter adopter) {
        String sql = "INSERT INTO adopters (name, contact_info, email, password, age) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, adopter.getName());
            preparedStatement.setString(2, adopter.getContactInfo());
            preparedStatement.setString(3, adopter.getEmail());
            preparedStatement.setString(4, adopter.getPassword()); 
            preparedStatement.setInt(5, adopter.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //email
    public static Adopter getAdopterByEmail(String email) {
        Adopter adopter = null;
        String sql = "SELECT * FROM adopters WHERE email = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                adopter = new Adopter();
                adopter.setId(resultSet.getInt("id"));
                adopter.setName(resultSet.getString("name"));
                adopter.setContactInfo(resultSet.getString("contact_info"));
                adopter.setEmail(resultSet.getString("email"));
                adopter.setPassword(resultSet.getString("password")); 
                adopter.setAge(resultSet.getInt("age"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adopter; 
    }
} 