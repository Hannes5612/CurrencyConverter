package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

public class testReader {
    @Test
    public void testReader() {
        Reader.init();
        Currency swissFranc = new Currency("Swiss franc", 0.7393440000);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (swissFranc.getName().equals(Reader.CurrencyList[i].getName())) {
                Assert.assertEquals(swissFranc.getRateSDR(), Reader.CurrencyList[i].getRateSDR(), 0.000000001);
            }
        }

    }

    @Test
    public void testReader2() {
        Reader.init();
        Currency chileanPeso = new Currency("Chilean peso", 0.0009636630);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (chileanPeso.getName().equals(Reader.CurrencyList[i].getName())) {
                Assert.assertEquals(chileanPeso.getRateSDR(), Reader.CurrencyList[i].getRateSDR(), 0.000000001);
            }
        }

    }

    @Test
    public void testReaderNegativeSDR() {
        Reader.init();
        boolean condition = false;
        Currency Euro = new Currency("Euro", 0.0229636630);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (Euro.getName().equals(Reader.CurrencyList[i].getName())) {
                if (Math.abs(Euro.getRateSDR() - Reader.CurrencyList[i].getRateSDR()) <= 0.000000001) {
                    condition = true;
                }
                Assert.assertFalse(condition);

            }
        }


    }

    @Test
    public void testReaderNegativeSDR2() {
        Reader.init();
        boolean condition = false;
        Currency algerianDinar = new Currency("Algerian dinar", 0.1629636630);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (algerianDinar.getName().equals(Reader.CurrencyList[i].getName())) {
                if (Math.abs(algerianDinar.getRateSDR() - Reader.CurrencyList[i].getRateSDR()) <= 0.000000001) {
                    condition = true;
                }
                Assert.assertFalse(condition);

            }
        }

    }
}
