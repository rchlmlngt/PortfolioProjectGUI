package cpsc219project.core.portfolioClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PortfolioTest {

    @Test
    void getStock(){
        Stock s1 = new Stock("Suncor", 40.5, "SU",70);
        Stock s2 = new Stock("Blue", 70.2, "BL", 30);
        Stock s3 = new Stock("Red", 30.5, "RD", 83);
        Cash C = new Cash("Cash", 253.78);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        Stock stock = portfolio.getStock("SU");
        System.out.println(stock);
        System.out.println(portfolio.getStock("SU"));
        System.out.println(portfolio.getStock("TD"));
    }

    @Test
    void portfolioBV() {
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        double exp1 = 129.4*40 + 243.6*35 + 250;
        assertEquals(portfolio1.portfolioBV(), exp1);
    }

    @Test
    void portfolioMV() {
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Stock stock3 = new Stock("Intel", 33.5, "INTC", 57);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        Map<String, Double> marketPrices = new HashMap<>();
        marketPrices.put("APPL", 135.7);
        marketPrices.put("TSLA", 240.2);
        marketPrices.put("INTC", 44.2);
        System.out.println(portfolio1.portfolioMV(marketPrices));
        double exp1 = 135.7*40 + 240.2*35 + 44.2*57 + 250;
        System.out.println(exp1);
    }

    @Test
    void portfolioROI() {
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Stock stock3 = new Stock("Intel", 33.5, "INTC", 57);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        Map<String, Double> marketValues = new HashMap<>();
        marketValues.put("APPL", 135.7);
        marketValues.put("TSLA", 240.2);
        marketValues.put("INTC", 44.2);
        System.out.println(portfolio1.portfolioROI(marketValues));
        double PBV = portfolio1.portfolioBV();
        double PMV = portfolio1.portfolioMV(marketValues);
        double exp1 = ((PMV - PBV)/PBV)*100;
        System.out.println(exp1);
    }

    @Test
    void portStockGains(){
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Stock stock3 = new Stock("Intel", 33.5, "INTC", 57);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        Map<String, Double> marketValues = new HashMap<>();
        marketValues.put("APPL", 135.7);
        marketValues.put("TSLA", 240.2);
        marketValues.put("INTC", 44.2);
        System.out.println(portfolio1.portStockGains(marketValues));
        //System.out.println(stock1.percentageChange(135.7));
        //System.out.println(marketValues.get(stock1.getSymbol()));
        //System.out.println(stock1.percentageChange(marketValues.get(stock1.getSymbol())));
        //System.out.println(stock1.getSymbol());
        //System.out.println(marketValues);
        System.out.println(marketValues.get(stock2.getSymbol()));
    }

    @Test
    void portComp(){
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Stock stock3 = new Stock("Intel", 33.5, "INTC", 57);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        Map<String, Double> marketValues = new HashMap<>();
        marketValues.put("APPL", 135.7);
        marketValues.put("TSLA", 240.2);
        marketValues.put("INTC", 44.2);
        System.out.println(portfolio1.portComp(marketValues));
    }

    @Test
    void hasStock(){
        Stock s1 = new Stock("Suncor", 40.5, "SU",70);
        Stock s2 = new Stock("Blue", 70.2, "BL", 30);
        Stock s3 = new Stock("Red", 30.5, "RD", 83);
        Cash C = new Cash("Cash", 253.78);
        List<Stock> stocks = new ArrayList<>();
        stocks.add(s1);
        stocks.add(s2);
        stocks.add(s3);
        Portfolio portfolio = new Portfolio(C, stocks);
        System.out.println(portfolio.hasStock("RD"));
        System.out.println(portfolio.hasStock("TSLA"));
        System.out.println(portfolio.toString());
    }

    @Test
    void Asset(){
        Stock stock1 = new Stock("Apple", 129.4, "APPL", 40);
        Stock stock2 = new Stock("Tesla", 243.6,"TSLA", 35);
        Stock stock3 = new Stock("Intel", 33.5, "INTC", 57);
        Cash cash = new Cash("Cash", 250);
        List<Stock> stocks =  new ArrayList<>();
        stocks.add(stock1);
        stocks.add(stock2);
        stocks.add(stock3);
        Portfolio portfolio1 = new Portfolio(cash, stocks);
        System.out.println(stocks);
        System.out.println(portfolio1.toString());
    }
}