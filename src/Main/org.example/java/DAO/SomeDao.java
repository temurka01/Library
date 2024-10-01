package DAO;

import Models.Book;
import Models.Library;

import java.sql.*;
import java.util.ArrayList;

public class SomeDao {
    private final Connection connection;

    public SomeDao() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
    }

    public void addBookToLibrary(int bookId, int libraryId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mapping  VALUES (?,?)");
        preparedStatement.setLong(1, libraryId);
        preparedStatement.setLong(2,bookId);
        preparedStatement.execute();
    }

    public Library findLibrary(String bookName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM library WHERE id = (SELECT library_id FROM mapping WHERE book_id = (SELECT book_id FROM book WHERE book_name = ?))");
        preparedStatement.setString(1, bookName);
        Library library = new Library();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            library.setId(result.getLong("id"));
            library.setLibraryName(result.getString("library_name"));
        }
        return library;
    }

    public ArrayList<Book> libraryContains(String libraryName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT b.book_id, b.book_name, b.book_author FROM public.book b JOIN public.mapping m ON b.book_id = m.book_id JOIN public.library l ON m.library_id = l.id WHERE l.library_name = ?");
        preparedStatement.setString(1,libraryName);
        ArrayList<Book> books = new ArrayList<Book>();
        ResultSet result = preparedStatement.executeQuery();
        while(result.next()) {
            books.add(new Book(result.getInt("book_id"),result.getString("book_name"),result.getString("book_author")));
        }
        return books;
    }

}
