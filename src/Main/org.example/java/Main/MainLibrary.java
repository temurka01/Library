package Main;

import DAO.LibraryDAO;
import DAO.SomeDao;
import Models.Book;
import DAO.BookDAO;
import Models.Library;


import java.sql.*;
import java.util.ArrayList;

public class MainLibrary {
    public static void main(String[] args) throws SQLException {
        SomeDao someDao = new SomeDao();
        ArrayList<Book> book = someDao.libraryContains("Библиотека имени Ленина");

        int i = 0;
    }
}
