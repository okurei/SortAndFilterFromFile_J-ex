import java.util.Scanner;

public class MainMenu {

    Scanner scan = new Scanner(System.in);

    public void mainMenu(){
        System.out.println("Select: ");
        System.out.println("1 to add a new book");
        System.out.println("2 to remove a book");
        System.out.println("3 to search for a book by title");
        System.out.println("4 to search for the number of copy by ISBN");
        System.out.println("5 to display all the book in the library");
        System.out.println("6 to count the total number of book");
        System.out.println("7 to exit");
        String selection = scan.nextLine();
        switch (selection){
            case "1" -> System.out.println("1");
            case "2" -> System.out.println("2");
            case "3" -> System.out.println("3");
            case "4" -> System.out.println("4");
            case "5" -> System.out.println("5");
            case "6" -> System.out.println("6");
            case "7" -> System.exit(0);
            default -> mainMenu();
        }
    }
}
