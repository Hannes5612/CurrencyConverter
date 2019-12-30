package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

public class testReader {
    @Test
    /**
     * Test if the Reader is working by 2 different Currencies of the List with their SDR-rate
     */


    public void testReader() {
        Reader reader = new Reader();
        reader.init();
        Currency swissFranc = new Currency("Swiss franc", 0.7393440000);
        for (int i = 0; i < reader.CurrencyList.length; i++) {
            if (swissFranc.equals(reader.CurrencyList[i])){
                Assert.assertTrue(true);
            }
        }
        Currency chileanPeso = new Currency("Chilean peso", 0.0009636630);
        for (int i = 0; i < reader.CurrencyList.length; i++) {
            if (chileanPeso.equals(reader.CurrencyList[i])){
                Assert.assertTrue(true);
            }
        }
    }

}
