package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

import java.nio.channels.AsynchronousServerSocketChannel;

/**
 * Unit test of {@link App}.
 */
public class testCurrency {

    /**
     * Test if Currency Array is working
     */
    @Test
    public void testOfCurrency() {
        final String resultCurrency = "euro";
        final double resultSDR = 0.8059420000;
        Currency currency = new Currency(resultCurrency, resultSDR);

        Assert.assertEquals(resultCurrency, currency.getName());
        Assert.assertEquals(resultSDR, currency.getRateSDR(), 0.00000001);
        Assert.assertNotNull(currency);

    }

    @Test
    public void negativeTestCurrency() {


        Currency swedishKrona = new Currency("swedisch Krona", 0.0770853000);
        Assert.assertFalse(swedishKrona.getName().equals("swedish Krone"));

    }
}




