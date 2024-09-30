package Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private long id;
    private String libraryName;

    @Override
    public String toString() {
        return  id + " " + libraryName + '\'';
    }
}
