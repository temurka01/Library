package Main;

import library.Book;
import library.LibraryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLibrary {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        LibraryService libraryService = (LibraryService) context.getBean("libraryService");
        System.out.println(libraryService.read(4));
        libraryService.create(new Book("Тарас Бульба", "Гоголь"));
        libraryService.update(new Book("Анна Каренина", "Толстой"), new Book("Анна Каренина", "Л.Н.Толстой"));
        libraryService.delete(new Book("Вишневый сад", "Чехов"));
        libraryService.upload();
    }
}
