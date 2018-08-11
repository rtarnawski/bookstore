import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello user!");
        System.out.println("Please choose your option");
        System.out.println("2 - contact");
        System.out.println("9 - exit");

        while (true) {
            String usersChoice = scanner.nextLine();
                if (StringUtils.isNumeric(usersChoice)) {
                    switch (usersChoice) {
                        case "9":
                            System.out.println("Thank you and CU next time!");
                            return;
                        case "2":
                            System.out.println("bookstore@bookstore.pl");
                            return;
                        default:
                            return;
                    }
                }else{
                        System.out.println("Please write a number");
                    }
        }
    }
}