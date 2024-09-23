package Models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Book {
    private long id;
    private String bookName;
    private String authorName;

    @Override
    public String toString() {
        return id + "/" + bookName + "/" + authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getBookName().equals(book.getBookName()) && getAuthorName().equals(book.getAuthorName());
    }
}
