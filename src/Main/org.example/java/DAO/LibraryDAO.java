package DAO;

import Models.Library;

import java.sql.*;

public class LibraryDAO {
    private final Connection connection;

    public LibraryDAO() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
    }

    public void create(Library library) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO library (library_name) VALUES (?)");
        preparedStatement.setString(1, library.getLibraryName());
        preparedStatement.execute();
    }

    public Library read(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library WHERE id = ?");
        preparedStatement.setLong(1, id);
        Library library = new Library();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            library.setId(result.getLong("id"));
            library.setLibraryName(result.getString("library_name"));
        }
        return library;
    }

    public void update(int id, Library library) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE library set library_name = ?  WHERE id = ?");
        preparedStatement.setString(1,library.getLibraryName());
        preparedStatement.setLong(2,id);
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM library WHERE id = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.execute();
    }
}
