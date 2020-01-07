package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

public class testReader {
    @Test

    //TODO negativ Tests --> assertfalse

    public void testReader1() {
        Reader reader = new Reader();
        Reader.init();
        Currency swissFranc = new Currency("Swiss franc", 0.7393440000);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (swissFranc.equals(Reader.CurrencyList[i])){
                Assert.assertTrue(true);
            }
        }
        Currency chileanPeso = new Currency("Chilean peso", 0.0009636630);
        for (int i = 0; i < Reader.CurrencyList.length; i++) {
            if (chileanPeso.equals(Reader.CurrencyList[i])){
                //TODO set boolean true
                Assert.assertTrue(true);
            }
        } //TODO asserttrue hier rein!
    }

}
