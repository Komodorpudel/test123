package B_Uebung.uebung11_NS.A53_d_neu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import B_Uebung.uebung06_sub_4P.A26_A27.BankAccount;

public class BankDB {

    Connection connection;


    // -------------------------

    public void add (BankAccount bankAccount) throws LoadSaveException {

        if (connection == null) {
            throw new LoadSaveException("No connection established", null);

        }

        String sqlQuery = "INSERT INTO BankAccount " +
                          "VALUES (?, ?, ?)";

        try (PreparedStatement myStatement = connection.prepareStatement(sqlQuery)) {

            myStatement.setString(1, bankAccount.getAccountNumber());
            myStatement.setString(2, bankAccount.getAccountHolderName());
            myStatement.setDouble(3, bankAccount.getBalance());

            myStatement.executeUpdate();

        }

        catch (SQLException e) {
            throw new LoadSaveException("Insert failed: ", e);
        } 
    }

    // ------------------------

    public void delete (BankAccount bankAccount) throws LoadSaveException {

        if (connection == null) {
            throw new LoadSaveException("No connection established", null);

        }

        String sqlQuery = "DELETE FROM BankAccount " +
                          "WHERE accountNumber = ?";

        try (PreparedStatement myStatement = connection.prepareStatement(sqlQuery)) {

            myStatement.setString(1, bankAccount.getAccountNumber());

            myStatement.executeUpdate();
        }

        catch (SQLException e) {
            throw new LoadSaveException("Delete failed: ", e);
        }
    }
    
}
