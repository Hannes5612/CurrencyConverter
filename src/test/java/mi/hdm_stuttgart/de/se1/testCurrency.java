package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test of {@link App}.
 */
public class testCurrency {
    //TODO negativ tests

    /**
     * Test if Currency Array is working
     */
    @Test
    public void testOfCurrency() {
        final String resultCurrency = "euro";
        final double resultSDR = 0.8059420000;
        Currency currency = new Currency(resultCurrency, resultSDR);

        Assert.assertEquals(resultCurrency, currency.getName());
        Assert.assertEquals(resultSDR, currency.getRateSDR(), 0.1);

    }



}
