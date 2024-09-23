package Main;

import Models.Book;
import Services.BookService;


import java.sql.*;
import java.util.Scanner;

public class MainLibrary {
    public static void main(String[] args) throws SQLException {

        BookService service = new BookService();

//        Scanner scanner = new Scanner(System.in);
//        Book book = new Book();
//        book.setBookName(scanner.nextLine());
//        book.setAuthorName(scanner.nextLine());
//        service.create(book);


        //System.out.println(service.read(3));


        //service.delete(12);


        service.update(12,new Book(0,"first","second"));
    }
}
