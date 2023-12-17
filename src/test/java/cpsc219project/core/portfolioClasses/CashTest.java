package cpsc219project.core.portfolioClasses;

import cpsc219project.core.portfolioClasses.Cash;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashTest {

    @Test
    void getValue(){
        Cash c1 = new Cash("Balance", 235.6);
        Cash c2 = new Cash("Cash", 15.5);
        System.out.println(c1.getValue());
    }

    @Test
    void addCash() {
        Cash c1 = new Cash("Balance", 235.6);
        c1.addCash(23.5);
        System.out.println(c1.getValue());
        System.out.println(235.6+23.5);
    }
}