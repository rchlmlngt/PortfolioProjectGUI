package cpsc219project.core.portfolioClasses;

import cpsc219project.core.portfolioClasses.Portfolio;
import cpsc219project.core.portfolioClasses.Stock;

public class Transaction {
    /**
     * The transaction class modifies and updates a
     * portfolio.
     */

    private static Portfolio portfolio;

    public Transaction(Portfolio portfolio){
        this.portfolio = portfolio;
    }

    public void buyStock(String Name, String Symbol, double Price, int Shares){
        double cost = Price*Shares;
        if (cost > portfolio.getCash().getValue()) {
            System.out.println("Insufficient funds to buy stock.");
        } else {
            if (portfolio.hasStock(Symbol)) {
                portfolio.getCash().removeCash((Price * Shares));
                Stock stock = portfolio.getStock(Symbol);
                stock.setValue((stock.getValue() + Price) / 2);
                stock.setShares(stock.getShares() + Shares);
                System.out.println("Bought " + Shares + " shares of " + Name + " for $" + Price + " per share.");
            }else {
                portfolio.getCash().removeCash((Price * Shares));
                Stock newStock = new Stock(Name, Price, Symbol, Shares);
                Portfolio.getStocks().add(newStock);
                System.out.println("Bought " + Shares + " shares of " + Name + " at $" + Price + " per share.");
            }
        }
    }

    public void sellStock(String Name, String Symbol, double Price, int Shares){
        Stock stock = portfolio.getStock(Symbol);
        if (stock == null || stock.getShares() < Shares) {
            System.out.println("Not have enough shares to sell.");
        } else {
            double revenue = Price*Shares;
            portfolio.getCash().addCash(revenue);
            stock.setShares(stock.getShares() - Shares);
            System.out.println("Sold " + Shares + " shares of " + Name + " at $" + Price + " per share.");
        }
    }

    public void addCash(double money){
        portfolio.getCash().addCash(money);
    }

    public void removeCash(double money){
        if(portfolio.getCash().getValue() < money){
            System.out.println("Not enough balance.");
        } else {
            portfolio.getCash().removeCash(money);
        }
    }
}
