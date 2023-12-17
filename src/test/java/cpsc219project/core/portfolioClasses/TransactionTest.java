package cpsc219project.core.portfolioClasses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void transaction() {
    }

    @Test
    void buyStock() {
        Stock s1 = new Stock("Suncor", 40.5, "SU",70);
        Stock s2 = new Stock("Blue", 70.2, "BL", 30);
        Stock s3 = new Stock("Red", 30.5, "RD", 83);
        Cash C = new Cash("Cash", 253.78);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        System.out.println(portfolio.toString());
        Transaction transaction = new Transaction(portfolio);
        transaction.buyStock("TD", "TD", 80.4, 2);
        System.out.println(portfolio.toString());
        System.out.println(portfolio.portfolioBV());
        System.out.println(40.5*70 + 70.2*30 + 30.5*83 + 253.78);
    }

    @Test
    void sellStock(){
        Stock s1 = new Stock("Calculus", 267.3, "CALC", 67);
        Stock s2 = new Stock("Phone", 290.3, "PHN", 45);
        Stock s3 = new Stock("Plants", 20.4, "PLT", 30);
        Cash C = new Cash("Balance", 0);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        System.out.println(portfolio.toString());
        Transaction transaction = new Transaction(portfolio);
        transaction.sellStock("Calculus", "CALC", 290.6, 30);
        System.out.println(portfolio.toString());
        transaction.buyStock("Phone","PHN", 270.5, 50);
        transaction.buyStock("TD", "TD", 85.4, 30);
        System.out.println(portfolio.toString());
        System.out.println(8718 - (85.4*30));
    }

    @Test
    void addCash(){
        Stock s1 = new Stock("Calculus", 267.3, "CALC", 67);
        Stock s2 = new Stock("Phone", 290.3, "PHN", 45);
        Stock s3 = new Stock("Plants", 20.4, "PLT", 30);
        Cash C = new Cash("Balance", 0);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        Transaction transaction = new Transaction(portfolio);
        transaction.addCash(300);
        System.out.println(portfolio.toString());
        transaction.addCash(350);
        System.out.println(portfolio.toString());
    }

    @Test
    void removeCash(){
        Stock s1 = new Stock("Calculus", 267.3, "CALC", 67);
        Stock s2 = new Stock("Phone", 290.3, "PHN", 45);
        Stock s3 = new Stock("Plants", 20.4, "PLT", 30);
        Cash C = new Cash("Balance", 650);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        Transaction transaction = new Transaction(portfolio);
        transaction.removeCash(350);
        System.out.println(portfolio.toString());
        transaction.removeCash(300);
        System.out.println(portfolio.toString());
    }
}