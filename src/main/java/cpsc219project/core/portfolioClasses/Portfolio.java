package cpsc219project.core.portfolioClasses;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Portfolio {

    /**
     * A portfolio contains assets.
     */
    private static Cash cash;
    private static List<Stock> stocks;

    private static Map<String, Double> marketValue;

    public Portfolio(Cash cash, List<Stock> stocks){
        this.cash = cash;
        this.stocks = stocks;
    }
    public static Cash getCash() {
        return cash;
    }

    public static List<Stock> getStocks() {
        return stocks;
    }

    public static Stock getStock(String symbol){
        for (Stock stock : stocks) {
        if (stock.getSymbol().equals(symbol)) {
            return stock;
        }
    }
        return null;
    }

    /**
    public static cpsc219project.core.portfolioClasses.Asset createPortfolio(List<cpsc219project.core.portfolioClasses.Asset> initialAsset) {
        portfolio.addAll(initialAsset);
        return null;
    }*/

    public static double portfolioBV() {
        double portfolioBV = 0;
        List<Stock> stocks = Portfolio.getStocks();
        double stockVal = 0;
        for (Stock stock : stocks) {
            stockVal += stock.stockBV();
        }
        double cashVal = Portfolio.getCash().getValue();
        portfolioBV += cashVal + stockVal;
        return portfolioBV;
    }

    /**
     * Calculates the market value of a portfolio.
     * Input must be a map that uses a stock's symbol as a key and contains the
     * current price of a stock.
     * @param marketValues
     * @return
     */
    public static double portfolioMV(Map<String, Double> marketValues) {
        double portfolioMV = 0;
        List<Stock> stocks = Portfolio.getStocks();
        double stockVal = 0;
        for (Stock stock : stocks) {
            if (marketValues.containsKey(stock.getSymbol())){
                stockVal += stock.stockMV(marketValues.get(stock.getSymbol()));
            }
        }
        double cashVal = Portfolio.getCash().getValue();
        portfolioMV += cashVal + stockVal;
        return portfolioMV;
    }

    /**
     * Return on Investment function
     * @return
     */
    public static double portfolioROI(Map<String, Double> marketValues){
        double portfolioMV = portfolioMV(marketValues);
        double portfolioBV = portfolioBV();
        double portfolioROI = ((portfolioMV- portfolioBV) / portfolioBV) * 100;
        return portfolioROI;
    }

    /**
     * Computes the Book value of a portfolio.
     * @param prices
     * @return
     */
    public static StringBuilder portStockGains(Map<String, Double> prices){
        List<Stock> stocks = Portfolio.getStocks();
        StringBuilder stockGains = new StringBuilder();
        double stockGain = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Stock stock : stocks) {
            if (prices.containsKey(stock.getSymbol())){
                stockGain = stock.percentageChange(prices.get(stock.getSymbol()));
                String formattedSG = decimalFormat.format(stockGain);
                stockGains.append(stock.getSymbol()).append(" is up by ").append(formattedSG).append("%.").append("\n");
            }
        }
        return stockGains;
    }

    /**
     * This method finds how much each asset is composed in the portfolio.
     * Takes in map that has the stock's symbol as a key and contains the current
     * price of each stock.
     * @param prices
     * @return
     */
    public static String portComp(Map<String, Double> prices){
        List<Stock> stocks = Portfolio.getStocks();
        double stockOccupy = 0;
        double sumStockOccupy = 0;
        StringBuilder SO = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Stock stock: stocks){
            if (prices.containsKey(stock.getSymbol())){
                stockOccupy = (stock.stockMV(prices.get(stock.getSymbol()))/Portfolio.portfolioMV(prices))*100;
                String formattedSO = decimalFormat.format(stockOccupy);
                sumStockOccupy += stockOccupy;
                SO.append(stock.getSymbol()).append(": ").append(formattedSO).append("% ").append("of portfolio.").append("\n");
            }
        }
        double cashOccupy = 100 - sumStockOccupy ;
        String CO = Portfolio.getCash().getName() + ": " + decimalFormat.format(cashOccupy) + "% " + "of portfolio";
        return CO + "\n" + SO ;
    }

    /**
     * To be used in transaction class. Checks if a stock that is intended to
     * buy already in exists in the portfolio.
     * @param symbol
     * @return
     */
    public boolean hasStock(String symbol) {
        for (Stock stock : stocks) {
            if (stock.getSymbol().equals(symbol)) {
                return true; // cpsc219project.core.portfolioClasses.Stock with the given symbol is found in the portfolio
            }
        }
        return false; // cpsc219project.core.portfolioClasses.Stock with the given symbol is not found in the portfolio
    }

    public String toString(){
        String cash = Portfolio.getCash().toString();
        List<Stock> stocks = Portfolio.getStocks();
        StringBuilder StringStock = new StringBuilder();
        for (Stock stock : stocks) {
            StringStock.append(stock.toString()).append("\n");
        }
        return cash + "\n" + StringStock;
    }

}
