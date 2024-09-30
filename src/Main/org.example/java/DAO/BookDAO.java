package DAO;

import Models.Book;

import java.sql.*;


public class BookDAO {
    private final Connection connection;

    public BookDAO() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "postgres");
    }

    public void create(Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book (book_name , book_author) VALUES (? , ?)");
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getAuthorName());
        preparedStatement.execute();
    }

    public Book read(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE book_id = ?");
        preparedStatement.setLong(1, id);
        Book book = new Book();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            book.setId(result.getLong("book_id"));
            book.setBookName("book_name");
            book.setAuthorName("book_author");
        }
        return book;
    }

    public void update(int id, Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book set book_name = ? , book_author = ? WHERE book_id = ?");
        preparedStatement.setString(1,book.getBookName());
        preparedStatement.setString(2,book.getAuthorName());
        preparedStatement.setLong(3,id);
        preparedStatement.execute();
    }

    public void delete(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE book_id = ?");
        preparedStatement.setLong(1,id);
        preparedStatement.execute();
    }
}
