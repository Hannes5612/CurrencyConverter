package mi.hdm_stuttgart.de.se1;

import java.util.InputMismatchException;
import java.util.Scanner;

class App {
    static String buyCurrency = "not yet defined";
    static String sellCurrency = "not yet defined";
    static double amountBuy = 0;
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            switch (mainMenu()) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public static int mainMenu(){
        System.out.println("*************[ Currency converter ]*************");
        System.out.println("[0] Select currency to buy: " + buyCurrency);
        System.out.println("[1] Select currency to sell: " + sellCurrency);
        System.out.println("[2] Select amount to convert: " + amountBuy);
        int option = -1;
        do {
            System.out.print("> Please choose an option: ");
            try {
                option = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\nSpast.");
                System.exit(1);
            }
        } while (option < 0 || option > 2);

        return option;
    }
}
