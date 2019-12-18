package mi.hdm_stuttgart.de.se1;

class Conversion {
    double curr1;
    double curr2;

    double currencyConvert(double fromSDR,double fromAmount, double toSDR){
        fromSDR=curr1;
        toSDR=curr2;
        return fromAmount/fromSDR*toSDR;
    }
}
