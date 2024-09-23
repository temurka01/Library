package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Library {
    private String libraryName;
    private List<Book> books;
}
