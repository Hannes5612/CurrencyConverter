package mi.hdm_stuttgart.de.se1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Reader {

    private final static Scanner scan = new Scanner(System.in);
    private static Currency[] CurrencyList;

    /**Reading a txt file into an array, containing the currencies listed in the txt file.
     */
    static void init() {

        //this first part creates an array with ability to storage as many currencies, the currencys.txt file offers.

        try {
            BufferedReader br = new BufferedReader(new FileReader("rms_five.txt"));   //read file
            int lines = 0;                                                                      //integer for counting lines
            while (br.readLine() != null) lines++;                                              //ascend lines for every line that's not empty
            CurrencyList = new Currency[lines];                                                 //create array CurrencyList with lines amount of indexes
            br.close();                                                                         //BufferedReader gets terminated
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }




        //this second part converts each line of the currencys.txt file into an Currency object and adds it to the
        //CurrencyList Array
        try {
            BufferedReader br2 = new BufferedReader(new FileReader("rms_five.txt"));   //read file
            int i = 0;                                                                           //set array index 0
            String line = br2.readLine();                                                        //start reading lines
            while (line != null) {                                                               //while loop for creating the array
                String[] s = line.split(";");                                              //creating temporary array from the lines content, split at ';'
                CurrencyList[i] = new Currency(s[0], Float.parseFloat(s[1]));                    //creating a Currency from s, adding it to array CurrencyList at index i
                line = br2.readLine();                                                           //read next line
                i++;                                                                             //ascend i
            }                                                                                    //while loop ends with an empty line
            br2.close();                                                                         //BufferedReader gets terminated
        }catch(Exception e){
            System.out.println("An error occurred: " + e.getMessage());
        }

    }

    /**Method to determine a currency to use in the converter.
     * @return the found currency
     */

    static Currency setCurrency() throws InterruptedException {

        System.out.println("--Enter the currency's name or part of it(>x< to go back to main menu): ");     //Instruction to enter the search term
        String possibleCurrency = scan.next().toLowerCase();                                                //converting the input into a lower-case string
        if (possibleCurrency.charAt(0) == 'x') return null;                                                 //terminating the method with returning null in order to get back to the main menu when 'x' is entered
        int results = 0;                                                                                    //creating an integer 'results' to count the following matches
        for (Currency currency : CurrencyList) {                                                            //for-each loop with array 'CurrencyList'
            if (currency.getName().toLowerCase().contains(possibleCurrency)) {                              //if a currency's name contains the search term, 'results' ascends by one
                results++;
            }
        }
        if (results != 0) {                                                                                 //if there is not no result, a new array 'searchResults' gets created
            Currency[] searchResults = new Currency[results];                                               //having 'results' number indexes
            results = 0;                                                                                    //resetting 'results'

            for (Currency currency : CurrencyList) {                                                        //for-each loop to write into 'searchResults'
                if (currency.getName().toLowerCase().contains(possibleCurrency)) {                          //with search term matching currency
                    searchResults[results] = currency;                                                      //gets written to index number 'results'
                    results++;
                }
            }
            if (results==1) {                                                                               //when getting exact one result, this currency gets returned
                System.out.println("--Selected " +searchResults[0]+" as currency!");
                TimeUnit.SECONDS.sleep(2);                                                          //users selection gets displayed for two seconds
                return searchResults[0];
            }

            System.out.println("Found " + searchResults.length + " Results:");                              //when getting more than one result, user can chose the one he wanted
            int resultNo = 0;                                                                               //resultNo to later choose from
            for (Currency searchResult : searchResults) {                                                   //for-each loop with array 'searchResults'
                System.out.print("[" + resultNo + "]");                                                     //printing out 'resultNo'
                System.out.println(searchResult);                                                           //printing out the currencies of index 'resultNo'
                resultNo++;                                                                                 //ascending 'resultNo' by one
            }
            System.out.println("Please enter the belonging number of your " +
                    "required currency(>x< to go back to main menu):");                                     //user instructions

            while (true) {                                                                                      //while loop for exceptions
                try {
                    String input = scan.next();                                                                 //get input
                    if (input.charAt(0) == 'x') return null;                                                    //returning null if user chooses to go back to main menu
                    int cur = Integer.parseInt(input);                                                          //parsing input into integer
                    if (cur < searchResults.length && cur >= 0) {                                               //if user input is in range of 'searchResults' index range, the belonging currency
                        System.out.println("--Selected " +searchResults[cur]+" as currency!");                  //gets returned, including a info message
                        TimeUnit.SECONDS.sleep(2);                                                      //users selection gets displayed for two seconds
                        return searchResults[cur];
                    } else {
                        System.out.println("No valid input, please try again(>x< to go back to main menu):");   //if not in the index range, retry message
                    }
                } catch (Exception a) {
                    System.out.println("No valid input, please try again(>x< to go back to main menu):");       //if not an integer or 'x', retry message
                }
            }


        } else {
            System.out.println("No matches found, taking you back to the main menu");                           //assumed no currency matching the search term, null gets returned and
            TimeUnit.SECONDS.sleep(2);                                                                  //the main menu gets displayed again after 2 seconds
            return null;
        }

    }
}


