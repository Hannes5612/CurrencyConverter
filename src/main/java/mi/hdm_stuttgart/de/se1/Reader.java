package mi.hdm_stuttgart.de.se1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    BufferedReader bufferedReader = null;
    String line;


    private String readCurrency(String currency) throws IOException {

        try {
            bufferedReader = new BufferedReader(new FileReader("C:\\Git\\se1-currency-converter\\src\\main\\resources\\currencys.txt"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "The file was not found!");
            System.exit(0);
        }

        while ((line = bufferedReader.readLine()) != null){
            {
                String[] nameWaehrung = line.split(";");
                if (currency.toLowerCase().equals(nameWaehrung[0].toLowerCase())) {
                    String waehrungText = nameWaehrung[0];
                    return waehrungText;
                }
            }
        }
    return currency;
    }

    private double Faktor (String Waehrung){
//Here the buffered reader is reading the actual line
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] waehrung = line.split(";");
                if (Waehrung.toLowerCase().equals(waehrung[0].toLowerCase())){
                    final double umrechungsfaktor = Double.parseDouble(waehrung[1]);
                    return umrechungsfaktor;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage() + "Error reading file!");
        } finally {


        }
 return 1;
    }
}

