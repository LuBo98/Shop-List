-- Ensure the database exists
CREATE DATABASE IF NOT EXISTS `shop-list`;

-- Use the `shop-list` database
USE `shop-list`;
-- Create the table if it does not exist
CREATE TABLE IF NOT EXISTS items_to_get (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            name VARCHAR(255) NOT NULL,
    amount VARCHAR(255) NOT NULL
    );
