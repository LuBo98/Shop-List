package com.born.list_share.persistence;

import com.born.list_share.config.DbConfig;
import com.born.list_share.persistence.entity.ItemsToGetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final DbConfig dbConfig;
    private Connection connection;

    private void connect() {
        if (connection == null) {
            String url = dbConfig.getUrl();
            System.out.println("Connecting to " + url + " with username: " + dbConfig.getUsername() + " and password: " + dbConfig.getPassword());
            String username = dbConfig.getUsername();
            String password = dbConfig.getPassword();

            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Database connected successfully!");
            } catch (SQLException e) {
                System.err.println("Failed to connect to the database.");
                e.printStackTrace();
            }
        }
    }

    public List<ItemsToGetEntity> getItemsToGet() throws SQLException {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM items_to_get");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<ItemsToGetEntity> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new ItemsToGetEntity(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("amount")));
        }
        return list;
    }

    public void postItemsToGet(ItemsToGetEntity itemsToGetEntity) throws SQLException {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO items_to_get(name, amount) VALUES (?, ?)");
        preparedStatement.setString(1, itemsToGetEntity.getName());
        preparedStatement.setString(2, itemsToGetEntity.getAmount());
        preparedStatement.executeUpdate();
    }

    public void removeItemsToGet(Integer id) throws SQLException {
        connect();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM items_to_get WHERE id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
