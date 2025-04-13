package library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void loadFromFile(String filename) {
        try (Scanner fileScanner = new Scanner(new java.io.File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    books.add(new Book(id, title, author));
                    if (id >= indexId) {
                        indexId = id + 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("📁 Fichier introuvable ou vide, on commence de zéro.");
        }
    }
    public void saveToFile(String filename) {
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            for (Book book : books) {
                writer.println(book.getId() + "," + book.getTitle() + "," + book.getAuthor());
            }
        } catch (Exception e) {
            System.out.println("❌ Erreur lors de la sauvegarde du fichier.");
        }
    }

}
