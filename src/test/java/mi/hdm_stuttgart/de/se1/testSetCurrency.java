package mi.hdm_stuttgart.de.se1;

import org.junit.Assert;
import org.junit.Test;

public class testSetCurrency {
    @Test
    public void testSetNoOption() throws InterruptedException {
        boolean condition = false;
        Reader.init();
        Currency test = new Currency("Euro", 0.8059419989585876);
        Currency test2 = Reader.setCurrency("euro",0);
        if (test.getName().equals(test2.getName())&&test.getRateSDR()==test2.getRateSDR()){
            condition=true;
        }
        Assert.assertTrue(condition);
    }
    @Test
    public void testSetNoOption2() throws InterruptedException {
        boolean condition = false;
        Reader.init();
        Currency test = new Currency("Swiss franc", 0.7393440008163452);
        Currency test2 = Reader.setCurrency("swiss",0);
        if (test.getName().equals(test2.getName())&&test.getRateSDR()==test2.getRateSDR()){
            condition=true;
        }
        Assert.assertTrue(condition);
    }

    @Test
    public void testSetWithOption() throws InterruptedException {
        boolean condition = false;
        Reader.init();
        Currency test = new Currency("Singapore dollar", 0.5347530245780945);
        Currency test2 = Reader.setCurrency("doll", 5);
        if (test.getName().equals(test2.getName())&&test.getRateSDR()==test2.getRateSDR()){
            condition=true;
        }
        Assert.assertTrue(condition);
    }

    @Test
    public void testSetWithOption2() throws InterruptedException {
        boolean condition = false;
        Reader.init();
        Currency test = new Currency("Polish zloty", 0.1893800050020218);
        Currency test2 = Reader.setCurrency("lo", 1);
        if (test.getName().equals(test2.getName())&&test.getRateSDR()==test2.getRateSDR()){
            condition=true;
        }
        Assert.assertTrue(condition);
    }

}
