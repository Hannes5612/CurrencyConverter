package mi.hdm_stuttgart.de.se1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class App {
    private static Currency buyCurrency;
    private static Currency sellCurrency;
    private static double amountBuy = 0;
    private final static Scanner scan = new Scanner(System.in);

    /**
     * While loop to accept user input in order to change the amount, buy- and sell currency.
     */

    public static void main(String[] args) throws InterruptedException {

        Reader.init();

        while (true) {
            createSpace();
            switch (mainMenu()) {                                                                            //main menu --> switch for giving user different options to set
                case 0:
                    System.out.println("--Selecting currency to buy!");                                     //option for set the Currency the user want to buy
                    buyCurrency = Reader.setCurrency();                                                     //set the currency with the setCurrency() method of the Class Reader
                    break;
                case 1:
                    System.out.println("--Selecting currency to sell!");                                    //option for set the Currency the user wants to sell
                    sellCurrency = Reader.setCurrency();                                                    //set the currency with the setCurrency() method of the Class "Reader"
                    break;
                case 2:
                    System.out.println("--Enter amount of currency to buy(>x< to go back to main menu): "); //option for set an amount of money to change
                    amountBuy = setBuy();                                                                   //set the amount to convert with the setBuy Method of the Class "App"
                    break;
                case 3:
                    System.out.println("--Invalid input, please try again.");                               //case for a invalid user input -> prints the Information of an invalid input
                    TimeUnit.SECONDS.sleep(2);                                                     //leave the message for 2 seconds before break
                    break;
            }
        }
    }

    /**
     * Main menu to show the possible settings to edit
     *
     * @return values to the above while loop.
     */

    private static int mainMenu() {

        double amountSell = 0.0;
        if (sellCurrency != null && amountBuy != 0.0 && buyCurrency != null) {
            amountSell = amountBuy / sellCurrency.getRateSDR() * buyCurrency.getRateSDR();
        }
        System.out.println("*************[ Currency converter ]*************");

        if (amountSell == 0.0) {
            if (buyCurrency == null) System.out.println(" Currency to buy: not set");
            if (buyCurrency != null) System.out.println(" Currency to buy: " + buyCurrency);
            if (sellCurrency == null) System.out.println("Currency to sell: not set");
            if (sellCurrency != null) System.out.println("Currency to sell: " + sellCurrency);
        }
        if (amountSell != 0.0) {
            System.out.println("Buying " + amountBuy + " of " + buyCurrency);
            System.out.println("Selling " + Math.round(amountSell*100.00)/100.00 + " of " + sellCurrency);
        }
        if (amountBuy!=0.0 && (sellCurrency==null||buyCurrency==null)){
            System.out.print("  Wanting to buy: " + amountBuy +" ");
            if (buyCurrency!=null) {
                System.out.println(buyCurrency) ;
            }else{
                System.out.println();
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("[0] Select a currency to buy");
        System.out.println("[1] Select a currency to sell");
        System.out.println("[2] Select the amount to be converted");


        int option = -1;
        System.out.print("--Please choose an option (>x< to exit): ");
        String input = scan.next();
        if (input.charAt(0) == '0') option = 0;
        else if (input.charAt(0) == '1') option = 1;
        else if (input.charAt(0) == '2') option = 2;
        else if (input.charAt(0) == 'x') {
            System.exit(0);
        } else return 3;


        return option;
    }

    /**
     * Method to set either the desired sell-currency or the currency wanted to buy.
     *
     * @return the found currency
     */
    private static double setBuy() {
        while (true) {
            String input = scan.next();
            try {
                if (input.charAt(0) == 'x') return 0.0;
                return Double.parseDouble(input);
            } catch (Exception n) {
                System.out.println("No valid input, please try again(>x< to go back to main menu):");
            }
        }
    }

    /**
     * Creating empty lines to let the console appear more tidy
     */
    private static void createSpace(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
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
