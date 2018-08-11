import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        BookData.getINSTANCE()
                .getBooks()
                .addAll(CsvBooksImporter.bookImportFromFile("books.csv"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello user!");

            while (true) {
                System.out.println("Please choose your option:");
                System.out.println("2 - contact");
                System.out.println("8 - print list of books");
                System.out.println("9 - exit");

                String usersChoice = scanner.nextLine();
                if (StringUtils.isNumeric(usersChoice)) {
                    switch (usersChoice) {
                        case "9":
                            System.out.println("Thank you and CU next time!");
                            return;
                        case "2":
                            System.out.println("\nbookstore@bookstore.p2\n");
                            continue;
                        case "8":
                            BookData.printBooks();
                            continue;

                        default:
                            continue;
                    }
                } else {
                    System.out.println("Please write a number");
                }
            }
        }
    }
