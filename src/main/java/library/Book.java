package library;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public class Book {
    private String bookName;
    private String authorName;

    @Override
    public String toString() {
        return bookName + "/" + authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookName().equals(book.getBookName()) && getAuthorName().equals(book.getAuthorName());
    }
}
