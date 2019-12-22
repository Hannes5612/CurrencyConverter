package mi.hdm_stuttgart.de.se1;



public class Currency {
    private String name;
    private double rateSDR;

    Currency(String name, double rateSDR) {
        this.name = name;
        this.rateSDR = rateSDR;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getRateSDR() {
        return  rateSDR;
    }

    public void setRateSDR(int rateSDR) {
        this.rateSDR = rateSDR;
    }
}
