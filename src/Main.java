import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        Library listOfBooks = new Library();
        listOfBooks.addBook("love", "samira");
        listOfBooks.addBook("bonheur", "nono");
        System.out.println(listOfBooks.getBooks());
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("\n1. Ajouter un livre ");
            System.out.println("2. lister les livre ");
            System.out.println("3. suprimer un livre");
            System.out.println("0. Quitter");
            System.out.print("Votre Choix: ");
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix){
                case 1:
                    System.out.print(" Entrer le nom de livre  : ");
                    String title = scanner.nextLine();
                    System.out.print(("Entrer le nom de l'auteur :"));
                    String author = scanner.nextLine();
                    listOfBooks.addBook(title, author);
                    System.out.println("Bravo, livre ajouter ");
                    break;
                case 2:
                    System.out.println("-----liste des livres-----");
                    for (Book b : listOfBooks.getBooks()){
                        System.out.println(b);
                    }
                    break;
                case 3:
                    System.out.println("Donner le id de livre a supprimer");
                    int id = scanner.nextInt();
                    if (listOfBooks.removeBook(id)){
                        System.out.println("Livre supprimer");
                    }
                    else{
                        System.out.println("Livrre Introuvable");
                    }
                    break;
                case 0:
                    System.out.println("A bientot");
                    return;
                default:
                    System.out.println("Choix invalid");
            }
        }

    }
}