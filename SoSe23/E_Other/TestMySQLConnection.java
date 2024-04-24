package SoSe23.E_Other;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMySQLConnection {

    public static void main(String[] args) {

        // Ersetzen Sie diese Werte mit den richtigen Daten Ihrer MySQL-Datenbank
        String url = "jdbc:mysql://educos-srv01.informatik.uni-augsburg.de:3306/theDatabase?useSSL=false&\serverTimezone=Europe/Berlin";
        String username = "student";
        String password = "inFormatik2";

        System.out.println("Connecting to the database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected successfully!");

            DatabaseMetaData metaData = connection.getMetaData();
            String[] types = {"TABLE"};
            ResultSet tables = metaData.getTables(null, null, "%", types);

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                ResultSet columns = metaData.getColumns(null, null, tableName, "%");

                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    System.out.println("  Column: " + columnName);
                }
            }
        }
        
        catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
    }
}
