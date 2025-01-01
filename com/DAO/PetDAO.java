package src.main.java.com.DAO;

import src.main.java.com.Model.Pet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/webapps"; 
    private String jdbcUsername = "root"; 
    private String jdbcPassword = "admin"; 

    // SQL Queries
    private static final String INSERT_PET_SQL = "INSERT INTO pets (name, type, age, sex, health, status) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_PETS = "SELECT * FROM pets;";
    private static final String SELECT_PET_BY_ID = "SELECT * FROM pets WHERE id = ?;";
    private static final String UPDATE_PET_SQL = "UPDATE pets SET name = ?, type = ?, age = ?, sex = ?, health = ?, status = ? WHERE id = ?;";
    private static final String DELETE_PET_SQL = "DELETE FROM pets WHERE id = ?;";

    // Method to add a new pet
    public void addPet(Pet pet) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PET_SQL)) {
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getType());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getSex());
            preparedStatement.setString(5, pet.getHealth());
            preparedStatement.setString(6, pet.getStatus());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get all pets
    public List<Pet> getAllPets() {
        List<Pet> pets = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PETS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Pet pet = new Pet();
                pet.setId(resultSet.getInt("id"));
                pet.setName(resultSet.getString("name"));
                pet.setType(resultSet.getString("type"));
                pet.setAge(resultSet.getInt("age"));
                pet.setSex(resultSet.getString("sex"));
                pet.setHealth(resultSet.getString("health"));
                pet.setStatus(resultSet.getString("status"));
                pets.add(pet);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return pets; 
    }

    // Method to get a pet by ID
    public Pet getPetById(int id) {
        Pet pet = null;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pet = new Pet();
                pet.setId(resultSet.getInt("id"));
                pet.setName(resultSet.getString("name"));
                pet.setType(resultSet.getString("type"));
                pet.setAge(resultSet.getInt("age"));
                pet.setSex(resultSet.getString("sex"));
                pet.setHealth(resultSet.getString("health"));
                pet.setStatus(resultSet.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return pet; 
    }

    // Method to update a pet
    public void updatePet(Pet pet) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PET_SQL)) {
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getType());
            preparedStatement.setInt(3, pet.getAge());
            preparedStatement.setString(4, pet.getSex());
            preparedStatement.setString(5, pet.getHealth());
            preparedStatement.setString(6, pet.getStatus());
            preparedStatement.setInt(7, pet.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    // Method to delete a pet
    public void deletePet(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapps", "root", "admin");
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PET_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}