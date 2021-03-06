package mi.hdm_stuttgart.de.se1;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class App {
    public static Currency buyCurrency;
    public static Currency sellCurrency;
    static double amountBuy = 0.0;
    static double amountSell = 0.0;                                                                            //starting value of amountSell
    private final static Scanner scan = new Scanner(System.in);

    /**
     * While loop to accept user input in order to change the amount, buy- and sell currency.
     */

    public static void main(String[] args) throws InterruptedException {

        Reader.init();

        while (true) {
            clearConsole();
            switch (mainMenu()) {                                                                                            //switch in method mainMenu() for giving user different options to set
                case 0:
                    System.out.println("--Selecting currency to buy!");                                                    //option for set the Currency the user wants to buy
                    System.out.println("--Enter the currency's name or part of it(>x< to go back to main menu): ");        //Instruction to enter the search term
                    buyCurrency = Reader.setCurrency(scan.next().toLowerCase(), -1);                               //set the currency with the setCurrency() method of the Class Reader
                    break;
                case 1:
                    System.out.println("--Selecting currency to sell!");                                                //option for set the Currency the user wants to sell
                    System.out.println("--Enter the currency's name or part of it(>x< to go back to main menu): ");     //Instruction to enter the search term
                    sellCurrency = Reader.setCurrency(scan.next().toLowerCase(), -1);                           //set the currency with the setCurrency() method of the Class "Reader"
                    break;
                case 2:
                    System.out.println("--Enter amount of currency to buy(>x< to go back to main menu): ");            //option for set an amount of money to change
                    amountBuy = setBuy(scan.next());                                                                   //set the amount to convert with the setBuy Method of the Class "App"
                    break;
                case 3:
                    System.out.println("--Invalid input, please try again.");                                          //case for a invalid user input -> prints the Information of an invalid input
                    TimeUnit.SECONDS.sleep(2);                                                                 //leave the message for 2 seconds before break
                    break;
            }
        }
    }

    /**
     * Main menu to show the possible settings to edit
     *
     * @return values to the above while loop.
     */

    public static int mainMenu() {                                                                         //mainMenu method which contains all the options of buy, sell and set the amount


        if (sellCurrency != null && amountBuy != 0.0 && buyCurrency != null) {
            Currency.conversion(amountBuy, sellCurrency, buyCurrency);
        }

        System.out.println("*************[ Currency converter ]*************");                             //layout of the Currency Converter --> starting point

        if (amountSell == 0.0) {
            if (buyCurrency == null)
                System.out.println(" Currency to buy: not set");                       //if buyCurrency is empty show the information that the user can set one
            if (buyCurrency != null)
                System.out.println(" Currency to buy: " + buyCurrency);                //show the selected Currency to buy if buyCurrency is not empty
            if (sellCurrency == null)
                System.out.println("Currency to sell: not set");                      //if sellCurrency is empty show the information that the user can set one
            if (sellCurrency != null)
                System.out.println("Currency to sell: " + sellCurrency);              //show the selected Currency to sell if sellCurrency is not empty
        }
        if (amountSell != 0.0) {
            System.out.println("Buying " + Math.round(amountBuy * 100.00) / 100.00 + " of " + buyCurrency);                               //showing the selected Currency the user want to buy and the amount of it
            System.out.println("Selling " + Math.round(amountSell * 100.00) / 100.00 + " of " + sellCurrency);  //showing the rounded amount of the Currency that the user wants to sell
        }
        if (amountBuy != 0.0 && (sellCurrency == null || buyCurrency == null)) {
            System.out.print("  Wanting to buy: " + amountBuy + " ");                                        //showing the amount of buy if buyCurrency and sellCurrency are not set
            if (buyCurrency != null) {                                                                        //showing the buyCurrency if it is not empty or just print an empty line
                System.out.println(buyCurrency);
            } else {
                System.out.println();
            }
        }

        System.out.println("------------------------------------------------");                             //layout of the different options
        System.out.println("[0] Select a currency to buy");                                                 //user can chose between different options given through numbers
        System.out.println("[1] Select a currency to sell");
        System.out.println("[2] Select the amount to be converted");


        int option = -1;
        System.out.print("--Please choose an option (>x< to exit): ");                                      //exit option to end the program
        String input = scan.next();                                                                         //set input to the user input
        if (input.charAt(0) == '0')
            option = 0;                                                             //set the int option to the input of the user
        else if (input.charAt(0) == '1') option = 1;
        else if (input.charAt(0) == '2') option = 2;
        else if (input.charAt(0) == 'x') {
            System.exit(0);                                                                          //exit in "x"-Case
        } else
            return 3;                                                                                    //return 3 to repeat all in case that the user input was something completely different


        return option;                                                                                      //return the chosen option
    }

    /**
     * Method to set either the desired sell-currency or the currency wanted to buy.
     *
     * @return the found currency
     */
    private static double setBuy(String input) {                                                                        //method for set the Buy Currency
        while (true) {
            try {
                if (input.charAt(0) == 'x')
                    return 0.0;                                                     //set the amount to get converted to 0 if user input is an "x"
                return Double.parseDouble(input);                                                           //otherwise return the Double of the amount to convert
            } catch (Exception n) {                                                                         //catch if user input is not a double or not an x
                System.out.println("No valid input, please try again(>x< to go back to main menu):");       //print warning message that the input was not valid
            }
        }
    }

    /**
     * Creating empty lines to let the console appear more tidy
     */

    public static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else
            {
                System.out.print("\033[H\033[2J");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }


}
