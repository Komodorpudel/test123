package SoSe23.C_BP.bp11_SQL_sub.Aufgabe_1_neu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class ProductDAO {

    private Connection connection;

    private static final String url = "Test1";
    private static final String user = "Test2";
    private static final String password = "Test3";


    // -----------------------------------------------------------------------------

    public ProductDAO() {

        try {
            this.connection = DriverManager.getConnection(url, user, password);
        }

        catch (SQLException e) {
            System.exit(1);
        }

    }

    // -----------------------------------------------------------------------------

    public List<Product> getAllProducts() {

        ArrayList<Product> allProducts = new ArrayList<>();

        String query = "SELECT * " +
                       "FROM Product";

        try (
              Statement statement = connection.createStatement();
              // ResultSet kommt zurück
              ResultSet myResultSet = statement.executeQuery(query)
            ) {

            while (myResultSet.next()){ // Positioned before first row
                int id = myResultSet.getInt("id");
                String name = myResultSet.getString("name");
                double price = myResultSet.getDouble("price");
                
                
                Product temp = new Product(id, name, price);

                allProducts.add(temp);
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

        return allProducts;

    }

    // -----------------------------------------------------------------------------

    public void updateProductPrice (int productId, double newPrice) {

        String query = "UPDATE Product " +
                       "SET price = ? " +
                       "WHERE id = ?";
        
        PreparedStatement preparedStatement = null; // machen wir hier weil finally block sonst nicht den block kennt

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setDouble(1, newPrice);
            preparedStatement.setInt(2, productId);

            // Affected rows kommt zurück
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows affedcted: " + rowsAffected);
        }
        catch (SQLException e) {

            System.out.println("Erreor in prepareStatment: " + e.getMessage());

        }

        // Beachte try in finally block
        finally {

            try {
                if (preparedStatement != null){
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            }
            catch (SQLException e) {
                System.out.println("Error when closing: " + e.getMessage());
            }
        }
    }

    // -----------------------------------------------------------------------------

}
