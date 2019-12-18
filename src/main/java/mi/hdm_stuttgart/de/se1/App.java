package mi.hdm_stuttgart.de.se1;

import java.util.InputMismatchException;
import java.util.Scanner;

class App {
    static Currency buyCurrency;
    static Currency sellCurrency;
    static double amountBuy = 0;

    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        /**
         * While loop to accept user input in order to change the amount, buy- and sell currency.
         */

        while (true) {
            switch (mainMenu()) {
                case 0: buyCurrency = setCurrency();
                    break;
                case 1: sellCurrency = setCurrency();
                    break;
                case 2:
                    System.out.println("--Enter amount to buy: ");
                    amountBuy = scan.nextDouble();
                    break;
            }
            System.out.println();
        }
    }

    /**
     * Main menu to show the possible settings to edit
     * @return values to the above while loop.
     *
     */

    public static int mainMenu(){

        double amountSell = 0;
        if (sellCurrency!=null && amountBuy != 0.0 && buyCurrency != null ){
            amountSell = amountBuy/buyCurrency.getRateSDR()*sellCurrency.getRateSDR();
        }


        System.out.println("*************[ Currency converter ]*************");
        System.out.println("[0] Select a currency to buy: " + buyCurrency);
        System.out.println("[1] Select a currency to sell: " + sellCurrency);
        System.out.println("[2] Select the amount to convert to: " + amountBuy);
        System.out.println("Converting " + amountSell + " " + sellCurrency + " in " + amountBuy + " " + buyCurrency);
        int option = -1;
        do {
            System.out.print("--Please choose an option: ");
            option = scan.nextInt();
            if (option<0 || option>2){
                System.out.println("Not a possible option, please try again.");
            }
        } while (option < 0 || option > 2);

        return option;
    }

    /**
     * Method to set either the desired sell-currency or the currency wanted to buy.
     *
     * @return the found currency
     */

    public static Currency setCurrency(){
        System.out.println("Enter the currency's name or part of it: ");
        String possibleCurrency = scan.next();
        return new Currency("euro", 2);
    }



}
