package Services;

import library.Book;
import library.Library;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private final Library library;
    private final String path;

    public LibraryService(String p) {
        path = p;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            List<Book> books = new ArrayList<Book>();
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split("/");
                books.add(new Book(lines[0], lines[1]));
            }
            library = new Library("Библиотека имени Ленина", books);
        } catch (IOException e) {
            throw new RuntimeException("IOException :C");
        }
    }

    public void create(Book book) {
        library.getBooks().add(book);
    }

    public Book read(int id) {
        return library.getBooks().get(id);
    }

    public void update(Book prev, Book curr) {
        int id = library.getBooks().indexOf(prev);
        if (id != -1) library.getBooks().set(id, curr);
        else create(curr);
    }

    public void delete(Book book) {
        library.getBooks().remove(book);
    }

    public void upload() {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false));
            for (int i = 0; i < library.getBooks().size(); i++) {
                bufferedWriter.write(library.getBooks().get(i).toString() + "\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException :C");
        }
    }
}
