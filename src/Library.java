import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private int indexId = 1;

    public void addBook(String title, String author){
        books.add(new Book(indexId++, title, author));
    }

    public List<Book> getBooks(){
        return books;
    }
    public boolean removeBook(int id){
        return books.removeIf(book -> book.getId() == id);
    }
}
