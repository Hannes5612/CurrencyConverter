package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test of {@link App}.
 */
public class testConversion {
    @Test
    public void TestConversion1(){
        Reader.init();
        double amountSell = 0;
        Currency buy = Reader.CurrencyList[6];      //Australian dollar;0.4987750000
        Currency sell = Reader.CurrencyList[20];    //Mexican peso;0.0382284000
        double amountBuy = 5.874539;
        amountSell = Currency.conversion(amountBuy, sell, buy);
        Assert.assertEquals(amountSell, 76.646, 0.001);
    }

    @Test
    public void TestConversionNegative(){
        Reader.init();
        double amountSell = 0;
        boolean conversionSuccess = true;
        Currency buy = new Currency("Haus", 0.757);
        Currency sell = Reader.CurrencyList[20];    //Mexican peso;0.0382284000
        double amountBuy = 5.874539;
        amountSell = Currency.conversion(amountBuy, sell, buy);
        if (amountSell != 0) conversionSuccess = false;
        Assert.assertFalse(conversionSuccess);


    }




}
