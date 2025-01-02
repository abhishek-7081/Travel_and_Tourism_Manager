package com.example.dao;

import User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    private UserDao userDao;
    private Connection connection;

    @BeforeEach
    public void setUp() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        userDao = new UserDao(connection);

        // Set up database schema
        String createTableQuery = "CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id))";
        connection.prepareStatement(createTableQuery).execute();
    }

    @AfterEach
    public void tearDown() throws Exception {
        connection.prepareStatement("DROP TABLE users").execute();
        connection.close();
    }

    @Test
    public void testSaveUser() throws Exception {
        User user = new User("Jane Doe");
        boolean result = userDao.save(user);

        assertTrue(result, "User should be saved successfully.");

        // Verify saved data
        String query = "SELECT * FROM users WHERE name = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, "Jane Doe");
        ResultSet resultSet = statement.executeQuery();

        assertTrue(resultSet.next(), "User should be found in the database.");
        assertEquals("Jane Doe", resultSet.getString("name"));
    }

    @Test
    public void testSaveUserFailure() throws Exception {
        // Intentionally cause a failure by closing the connection
        connection.close();

        User user = new User("John Doe");
        boolean result = userDao.save(user);

        assertFalse(result, "User save should fail due to closed connection.");
    }
}
