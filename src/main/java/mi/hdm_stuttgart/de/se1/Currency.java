package mi.hdm_stuttgart.de.se1;


import static mi.hdm_stuttgart.de.se1.App.*;

public class Currency {
    private String name;
    private double rateSDR;

    Currency(String name, double rateSDR) {                                     //Constructor for the ArrayList with different Currencys and their SDR rate
        this.name = name;                                                       //set the name
        this.rateSDR = rateSDR;                                                 //set the SDR rate
    }

    public static double conversion(double amountBuy, Currency sellCurrency, Currency buyCurrency){
        amountSell = amountBuy / sellCurrency.getRateSDR() * buyCurrency.getRateSDR();                  //convertion in SDR rate
        return amountSell;
    }
    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }                                   //getter for return the Currencys name

    double getRateSDR() {
        return rateSDR;
    }                                                                          //getter for return the Currencys SDR rate
                                                                              //--> no setter needed because Currencys name and SDR rate set with the Constructor at the begin

}
