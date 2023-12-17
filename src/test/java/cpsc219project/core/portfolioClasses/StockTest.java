package cpsc219project.core.portfolioClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.SocketHandler;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void getValue(){
        Stock s1 = new Stock("Suncor", 40.5, "SU", 70);
        Stock s2 = new Stock("Blue", 70.2, "BL", 30);
        Stock s3 = new Stock("Yellow", 13.4, "YL", 45);
        assertEquals(s1.getValue(), 40.5);
        assertEquals(s2.getValue(), 70.2);
        assertEquals(s3.getValue(), 13.4);
    }

    @Test
    void setValue(){
        Stock s1 = new Stock("Suncor", 40.5, "SU",70);
        Stock s2 = new Stock("Blue", 70.2, "BL", 30);
        Stock s3 = new Stock("Shoes", 120.6, "SS", 10);
        s1.setValue((s1.getValue() + 50.2)/2);
        s2.setValue(80.3);
        s3.setValue(150.0);
        assertEquals(s1.getValue(), 45.35);
        assertEquals(s2.getValue(), 80.3);
        assertEquals(s3.getValue(), 150.0);
    }

    @org.junit.jupiter.api.Test
    void stockMV() {
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        System.out.println(stock1.stockMV(135.3));
        System.out.println(stock1.stockBV());
    }

    @Test
    void stockBV(){
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("TD", 88.4, "TD", 60);
        Stock stock3 = new Stock("Microsoft", 357.9, "MSFT", 10);
        assertEquals(stock1.stockBV(), 129.4*40, "Apple");
        assertEquals(stock2.stockBV(), 88.4*60, "TD");
        assertEquals(stock3.stockBV(), 357.9*10, "MSFT");
    }

    @Test
    void percentageChange(){
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        System.out.println(stock1.percentageChange(135.7));
    }
}